

//Express 기본 모듈
require("dotenv").config();
var express = require("express");
var http = require("http");
var path = require("path");

//var bodyParser = require("body-parser"); //예전에는 bodyParser를 호출해야 했지만 express에 내장이 되어 안써도 괜춘
var serveStatic = require("serve-static"); //특정 폴더를 패스로 접근 가능하게 하는것.

//에러 핸들러 모듈
var expressErrorHandler = require("express-error-handler");

//익스프레스 객체 생성
var app = express();

//기본 포트를 app 객체의 속성으로 설정
//express 서버 객체의 메소드(set.get.use)
app.set("port",process.env.PORT)

app.use(express.urlencoded({extended:false}));

app.use("/public",serveStatic(path.join(__dirname,"public"))); //public (실제)폴더의 이름을 써준것

//라우터 객체 추가 
var router = express.Router();


//Middleware 객체(use) 생성             //주소별로옴기기에 next는 필요없다
router.route("/process/login").post(function(req,res){ //"/process/login"라는 경로로 .post 방식으로 왔을때 함수 실행ㅇ
	
	console.log("/process/login 처리"); 
	
	
	
	var paramId = req.body.id || req.query.id; 
	var paramPwd = req.body.pwd || req.query.pwd; 
	//var paramName = req.body.name //Post방식으론 받을 수 없듬
	
	
	res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
	res.write("<h1>Express 서버에서 응답한 결과</h1>")
	res.write("<div><p>ID: " + paramId + "</p></div>");
	res.write("<div><p>Pwd: " + paramPwd + "</p></div>");
	res.write("<br><br><a href='/public/login2.html'>로그인페이지</a>");
	res.end();
});


//라우터 객체를 app객체에 추가
app.use("/", router);

var errorHandler = expressErrorHandler({
	
	static : {
		"404":"./public/404.html"
	}
	
});

app.use(expressErrorHandler.httpError(404));
app.use(errorHandler);


//Express 서버 시작
//var server = http.createServer();

http.createServer(app).listen(app.get("port"),function(){ //위에 set으로 넣어둔 port를 get으로 가져온거

	console.log("익스프레스 서버 on~~ 포트번호는:" + app.get("port"));
	
});






























