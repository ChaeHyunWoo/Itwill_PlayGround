// cookie-parser

//Express 기본 모듈
require("dotenv").config();
var express = require("express");
var http = require("http");
var path = require("path");
var serveStatic = require("serve-static"); //특정 폴더를 패스로 접근 가능하게 하는것.
var expressErrorHandler = require("express-error-handler");

//쿠키 모듈
var cookieParser = require("cookie-parser");

//익스프레스 객체 생성
var app = express();

//기본 포트를 app 객체의 속성으로 설정
//express 서버 객체의 메소드(set.get.use)
app.set("port",process.env.PORT)

app.use(express.urlencoded({extended:false}));

app.use("/public",serveStatic(path.join(__dirname,"public"))); //public (실제)폴더의 이름을 써준것

app.use(cookieParser());

//라우터 객체 추가 
var router = express.Router();


// 라우팅 함수 등록
router.route("/process/showCookie").get(function(req,res){ //"/process/login"라는 경로로 .post 방식으로 왔을때 함수 실행ㅇ
	
	console.log("/process/showCookie 호출.."); 
	
	res.send(req.cookies);
	
});

router.route("/process/setUserCookie").get(function(req,res) { 
	
	console.log("/process/setUserCookie 호출..");
	
	//쿠키 만들기
	res.cookie("user", {
		id: "suzi",
		name: "배수지",
		authorize: true // 인증에 관련된 것
	});
	
	//redirect 응답
	res.redirect("/process/showCookie");
	
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