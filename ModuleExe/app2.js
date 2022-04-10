//암호화
//npm install crypto --save
//crypto 모듈은 pwd + salt(key)를 합쳐서 암호화 //salt(key)는 사용자정의

//Express 기본 모듈
require("dotenv").config();
var express = require("express");
var http = require("http");
var path = require("path");
//var bodyParser = require("body-parser"); //예전에는 bodyParser를 호출해야 했지만 express에 내장이 되어 안써도 괜춘
var serveStatic = require("serve-static"); //특정 폴더를 패스로 접근 가능하게 하는것.
var expressErrorHandler = require("express-error-handler");
var expressSession = require("express-session");
//var mongoose = require("mongoose"); database.js안에 만들어줬기에 필요x

var user = require("./router/user"); //router에 user.js파일
var config = require("./config"); 
var database = require("./database/database");
var routerLoader = require("./router/routerLoader");

//익스프레스 객체 생성
var app = express();

//뷰 엔진 설정
app.set("views",__dirname + "/views");
//app.set("view engine","ejs"); //엔진을 ejs로 할꺼얌
//console.log("뷰엔진이 ejs로 설정되었습니다.");

app.set("view engine","jade"); //엔진을 ejs로 할꺼얌
console.log("뷰엔진이 jade로 설정되었습니다.");

app.set("port",process.env.PORT||config.serverPort);

app.use(express.urlencoded({extended:false}));

app.use("/public1",serveStatic(path.join(__dirname,"public1"))); //public (실제)폴더의 이름을 써준것
//사용자정의

app.use(expressSession({

	secret:"my key",
	resave:true,
	saveUninitialized:true

}));

//-----------------------------------------------------------------------------
//라우터 객체 생성
var router = express.Router();

routerLoader.init(app,router);

var errorHandler = expressErrorHandler({

	static: { //미리 메모리상에 올려둔것
		"404":"./public/404.html" //404에러가 뜨면 public에 404.html로 가라
	}
});

app.use(expressErrorHandler.httpError(404));
app.use(errorHandler); //변수명 담아줌


//Express 서버 시작
//var server = http.createServer();

http.createServer(app).listen(app.get("port"),function(){ //위에 set으로 넣어둔 port를 get으로 가져온거

	console.log("익스프레스 서버 on~~ 포트번호는:" + app.get("port"));

	//DB연결 함수 호출
	database.init(app,config); 

});






























