
/*
채팅 서버 만들기

* Web Socket : 웹 서버로 소켓을 연결한후 데이터를 주고받을 수 
  있도록 만든 HTML5 표준으로 웹브라우져가 이 기능을 지원하지 않아도
  Web Socket을 사용할 수 있게 만든것이 Socket.io 모듈
  
  * cors모듈 : Ajax의 XMLHttpRequest 는 보안 문제를 이유로  
  웹사이트를 제공하는 서버이외의 다른서버에는 접속할 수 없는데 
  cors (Cross-Origin Resource Sharing)를 사용하면 제약이 풀림
*/

require("dotenv").config();
var express = require("express");
var http = require("http");
var path = require("path");
//var bodyParser = require("body-parser"); //예전에는 bodyParser를 호출해야 했지만 express에 내장이 되어 안써도 괜춘
var serveStatic = require("serve-static"); //특정 폴더를 패스로 접근 가능하게 하는것.
var expressErrorHandler = require("express-error-handler");
var expressSession = require("express-session");

//
var passport = require("passport");
var flash = require("connect-flash");


var config = require("./config"); 
var database = require("./database/database");
var routerLoader = require("./router/routerLoader");

var cors = require("cors");

//익스프레스 객체 생성
var app = express();

//뷰 엔진 설정
app.set("views",__dirname + "/views");
app.set("view engine","ejs"); //엔진을 ejs로 할꺼얌
console.log("뷰엔진이 ejs로 설정되었습니다.");



app.set("port",process.env.PORT||config.serverPort);

app.use(express.urlencoded({extended:false}));

app.use("/public",serveStatic(path.join(__dirname,"public"))); //public (실제)폴더의 이름을 써준것
//사용자정의

app.use(cors());

app.use(expressSession({

	secret:"my key",
	resave:true,
	saveUninitialized:true

}));

app.use(passport.initialize());
app.use(passport.session());
app.use(flash());



//라우터 객체 생성
var router = express.Router();

routerLoader.init(app,router);


//패스포트 설정
var configPassport = require("./passport/passport");
configPassport(app,passport); //passport.js는 매개변수가 app,passport가 필요하기 때문에 넘겨준다,

//패스포트 라우팅 설정
var userPassport = require("./router/userPassport");
userPassport(router,passport);



var errorHandler = expressErrorHandler({

	static: { //미리 메모리상에 올려둔것
		"404":"./public/404.html" //404에러가 뜨면 public에 404.html로 가라
	}
});

app.use(expressErrorHandler.httpError(404));
app.use(errorHandler); //변수명 담아줌


//이걸 쓰면 에러가 떠도 서버가 죽지않고 살아있다.
process.on("uncaughtException", function(err) {
	console.log("서버 프로세스 종료하지 않고 유지함.");
})


//Express 서버 시작

var host = "localhost";

var server = http.createServer(app).listen(app.get("port"),function(){ 

	console.log("익스프레스 서버를 시작했습니다.:" + app.get("port"));

	//DB연결 함수 호출
	database.init(app,config); 

});

var io = require("socket.io")(server);

var loginID = {}; //빈 객체생성 - 객체생성을 해야 변수를 넣을 수 있음

io.sockets.on("connection",function(socket) {
	
	console.log("Connection Info : ", socket.request.connection._peername);
	
	//ip : socket.request.connection._peername.address
	//port : socket.request.connection._peername.port
	
	//각각의 클라이언트마다 고유한 key값이 있어야 함
	//모바일 : 핸드폰 번호
	//socket.io가 만드는 고유 정보(socket.id : QR_사용자정의)
	
	//로그인
	socket.on("login",function(login) {
		
		console.log("login 이벤트 받음");
		
		loginID[login.id] = socket.id;
		
		console.log("접속한 소켓 ID : " + socket.id);
		
		socket.loginId = login.id; // 사용자 ID
		socket.loginAlias = login.alias; //사용자 alias
		
		
		
		//응답 메세지
		sendResponse(socket, "login", "200", 
				socket.loginId + "(" + socket.loginAlias + ") 가 로그인 되었습니다.");
		
		console.log("접속한 클라이언트 ID 갯수: " + Object.keys(loginID).length);
		
	});
	
	
	//로그아웃
	socket.on("logout",function(logout) {
		
		sendResponse(socket, "logout", "444", logout.id + "가 로그아웃 되었습니다.");
		
		//Object key에서 socket.id 삭제
		delete loginID[logout.id];
		
		console.log("접속한 클라이언트 ID 갯수: " + Object.keys(loginID).length);
		
	});
	
	
	//메세지
	socket.on("message",function(message) {
	
		console.log("message 이벤트를 받았습니다.");
		
		if(message.receiver=='ALL') {
			console.log("모든 클라이언트에게 message를 전송");
			
			io.sockets.emit("message",message);
			
		}else{ // !ALL
			
			if(loginID[message.receiver]) {
				
				//io.sockets.connected(loginID[message.receiver]).emit("message",message); //3.0
				io.to(loginID[message.receiver]).emit("message",message); //4.0
				
				sendResponse(socket, "message","200",message.receiver + "에게 메세지를 전송했습니다.");
				
			}else{//로그인을 안했을 경우
				sendResponse(socket, "login","404","상대방의 로그인 ID를 찾을 수 없습니다.");
				
			}
			
		}
		
	});
	
});


//응답 함수
function sendResponse(socket,command,code,message) {
	
	var returnMessage = {command:command, code:code, message:message};
	
	
	//서버에서 뭔가 보낼 때는 emit
	socket.emit("response",returnMessage);
	
}

