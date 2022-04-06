// 암호화
// 암호화되는 작업을 하기 위해서 모듈이 필요하다 
// npm install crypto --save 암호화 모듈을 설치한다.
// crypto 모듈은 사용자가 pwd를 입력하면 그 pwd에다가 salt라는 키를 붙여서 암호화 한다

//Express 기본 모듈
require("dotenv").config();
var express = require("express");
var http = require("http");
var path = require("path");
var serveStatic = require("serve-static");
var expressErrorHandler = require("express-error-handler");
var expressSession = require("express-session");
var mongoose = require("mongoose");

//crypto(암호화)모듈
var crypto = require("crypto")

var database;
var UserSchema;
var UserModel;

//데이터베이스 연결
function connectDB(){	
	
	//데이터베이스 연결 정보
	var databaseUrl = "mongodb://localhost:27017/shopping";
	
	//연결
	mongoose.connect(databaseUrl);
	
	database = mongoose.connection;
	
	database.on("open",function(){

		// 스키마 모델 객체
		createUserSchema(); // 함수로 호출할것임
		
	});
	
	database.on("error",console.error.bind(console,"몽구스 연결 에러..."));
	
	database.on("disconnected",function(){
		
		console.log("DB연결이 끊겼습니다 5초후 재연결 합니다");
		setInterval(connectDB(),5000);
	});
	
}

//스키마 정의 한것을 함수로 뺼것임 그 사이에 Virtual를 넣으면 함수가 길어지므로 

function createUserSchema(){
	
	// 스키마를 호출하고 몽구스를 쓰게된다.
	UserSchema = require("./database/userSchema").createSchema(mongoose);
	
	
	
	// Model 정의	
	UserModel = mongoose.model("users3",UserSchema);

	console.log("UserModel 정의함.");
	
}

//익스프레스 객체 생성
var app = express();

app.set("port",process.env.PORT||3000);

app.use(express.urlencoded({extended:false})); //post방식일 때 한글 깨짐 방지

app.use("/public",serveStatic(path.join(__dirname,"public")));

app.use(expressSession({
	
	secret:"my key",
	resave:true,
	saveUninitialized:true
	
}));

//사용자를 인증하는 함수
var authUser = function(database,id,pwd,callback){
	
	console.log("authUser 함수 호출..");
			
	//아이디와 비밀번호 검색

	
	//id가 function(id,callback) 에서 find({id:id}로 찾아 오게되면서 결과가 callback함수가 에러면 err 잘나오면result 로 들어감
	// 즉 , 콜백함수는 id를 찾았을경우 실행된결과를 받음

	UserModel.findById(id, function(err,result){ 		// 아이디 패스워드 체크했었는데 이젠 id만 주면됨

		// 에러가 있으면 이걸 실행 
		if(err) {
			callback(err,null);
			return;
		}
		
		//데이터가 있을경우
		if(result.length>0){	
			console.log("아이디와 일치하는 사용자 찾음")
			// 무조건 배열로 넘어옴
			
			// ._doc = 도큐먼트 DB 값을 비교
			
			
			// 암호화된 데이터 비교
			var user = new UserModel({id:id});
			
			var authenticated = 
									
				user.authenticate(pwd,result[0]._doc.salt,result[0]._doc.hashed_password); // 위에 메소드 UserSchema.method("authenticate",function(inputPwd,inSalt,hashed_password) 호출
											// pwd , salt키 = db암호화된 비교작업
			
			// authenticated 에는 true 아니면 fasle 가 들어가게됨
			
		
		} if(authenticated){ // 사용자가 입력한 pwd가 일치하나 ?  	
				console.log("비밀번호 일치함")
				callback(null,result); // 에러는 없으니 null ,데이터 있으니 result 는 넣어줌 	
			
		} else {
			console.log("비밀번호가 일치하지 않음");
			callback(null,null); // 에러없고 결과가 없으니 null , null
			
			}
						
		/*} else {
			
			console.log("아이디와 일치하는 데이터가 없습니다.");
			callback(null,null); // 에러없고 결과가 없으니 null , null
		
			
		}*/
		
	});
	
}

//사용자를 추가하는 함수
var addUser = function(database,id,pwd,name,callback){
	
	console.log("addUser 함수 호출..");
	
	var users = new UserModel({"id":id, "pwd":pwd, "name":name});
	
	users.save(function(err,result){
		
		if(err){
			callback(err,null);
			return;
		}
		
		if(result){
			
			console.log("사용자 추가..");
			
		}else{
			console.log("사용자 추가 실패..");
		}
		callback(null,result);			
	});
	
};
//--------------------------------------------------------
// 라우터 객체 생성
var router = express.Router();

// 로그인 라우터
router.route("/process/login").post(function(req,res){
	
	console.log("/process/login 호출..");
	
	var id = req.body.id;
	var pwd = req.body.pwd;
	
	
	
	if(database){
	
		authUser(database, id, pwd, function(err,result){
			
			if(err) {throw err;}
			
			if(result){
				
				var userName = result[0].name;
				
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h1>로그인 성공</h1>")
				res.write("<div>아이디: " + id + "</div>");
				res.write("<div>이름: " + userName + "</div>");
				res.write("<br/><br/><a href='/public/login.html'>다시 로그인</a>");
				res.end();				
				
			}else{
				
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h1>로그인 실패</h1>")				
				res.write("<div>아이디 또는 패스워드를 확인하세요</div>");
				res.write("<br/><br/><a href='/public/login.html'>다시 로그인</a>");
				res.end();
			}	
		});
	}else{
		
		res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
		res.write("<h1>데이터베이스 연결 실패</h1>")				
		res.write("<div>데이터베이스를 연결하지 못했습니다.</div>");		
		res.end();		
	}	
});

//사용자 추가 라우터
router.route("/process/addUser").post(function(req,res){
	
	console.log("/process/addUser 호출..");
	
	var id = req.body.id;
	var pwd = req.body.pwd;
	var name = req.body.name;
	
	if(database){
		
		addUser(database, id, pwd, name, function(err,result){
			
			if(err) {throw err;}
			
			if(result){
				
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h1>사용자 추가 성공</h1>")	
				res.end();			
				
			}else{		
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h1>사용자 추가 실패</h1>")	
				res.end();			
			}
		});
		
		
	}else{
		
		res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
		res.write("<h1>데이터베이스 연결 실패</h1>")				
		res.write("<div>데이터베이스를 연결하지 못했습니다.</div>");		
		res.end();
		
	}
});

// 사용자 리스트 라우터
// 폼버튼을 눌렀을때의 주소임 
router.route("/process/listUser").post(function(req,res){
	
	console.log("/process/listUser 호출됨")
	
	// db에서 데이터 가져옴
	
	if(database) { // 데이터베이스 객체가 있으면 연결해서 데이터 가져옴
		
		/*UserSchema.static("findAll",function(callback){
			return this.find({}, callback);
		})*/
		
		// 함수 호출하면됨 
		UserModel.findAll(function(err,result){  // 모든데이터 가져오는 메소드 static("findAll",  -> find{} 넘겨주는값이 필요없음 function(err,result) 로 처리 
			
			
			if(err) { // 에러가 발생하면 
				
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h2>사용자 리스트 조회중 에러 발생</h2>")				
				res.end();
				
				return; // 밑에 실행하지 않게 return 꼭 써줌 
			}
			
			if(result){ // 정상적으로 데이터를 가지고 왔을때
				
				// 모양 디자인 만드는 것임 
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h2>사용자 리스트</h2>")
				res.write("<div><ul>");
				
				
				for(var i=0; i<result.length; i++) {	
					var id = result[i]._doc.id; // 여러개니까 i번째 
					var name = result[i]._doc.name;
					var age = result[i]._doc.age;
				
					// ul안에 들어가있으니 li , number니까 # 하나 붙이고 i+1은 일련번호 , : 구분자 해주고 엔터치고 id + , + name + , + age + <li>
					res.write('<li>#'+ (i+1) + ' : ' 
							+ id + ", " + name + ' , ' + age + '</li>' )
				}
				
				
				res.write("</ul></div>");
				res.write("<br/><br/><a href='/public/listUser.html'>리스트</a>");
				res.end()
				
			} else {
				// 데이터가 없을 경우 
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h2>사용자 조회 실패</h2>")				
				res.end();
			}
		})  	
	}	
});

//라우터 객체 등록
app.use("/",router);

var errorHandler = expressErrorHandler({
	
	static: {
		"404":"./public/404.html"
	}
	
});

app.use(expressErrorHandler.httpError(404));
app.use(errorHandler);


//Express 서버 시작
http.createServer(app).listen(app.get("port"),function(){
	
	console.log("익스프레스 서버를 시작했습니다: " + app.get("port"));
	
	//DB연결 함수 호출
	connectDB();
	
});