

//Express 기본 모듈
require("dotenv").config();
var express = require("express");
var http = require("http");
var path = require("path");

//var bodyParser = require("body-parser"); //예전에는 bodyParser를 호출해야 했지만 express에 내장이 되어 안써도 괜춘
var serveStatic = require("serve-static"); //특정 폴더를 패스로 접근 가능하게 하는것.

//익스프레스 객체 생성
var app = express();

//기본 포트를 app 객체의 속성으로 설정
//express 서버 객체의 메소드(set.get.use)
app.set("port",process.env.PORT)

//중첩된 객체표헌을 허용할지 선택하는것
//application/x-www.form-urlencoded로 파싱하겠다는것 application/x-www.form-urlencoded은 default값
app.use(express.urlencoded({extended:false}));

app.use(serveStatic(path.join(__dirname,"public"))); //public (실제)폴더의 이름을 써준것

//Middleware 객체(use) 생성
app.use(function(req,res,next){
	
	console.log("POST 미들웨어 실행.."); 
	
	res.send({name:'천우희',age:34}); //json 타입의 데이터가 그대로 보내짐
	
	res.status(403).send("접근금지");
	res.sendStatus(403); //Forbidden (403)자체가 접근금지라는뜻
	res.redirect("http://naver.com");
	
	//전송방식에 따른 데이터를 받아내는 방식
	//Get방식 : req.query.name //request.getParameter 쓴것 
	//Post방식 : req.body.name 
	//Get/Post : req.param("name") //둘중 어느거로 보내던 상관x 따옴표도 큰따옴표 작은 따옴표 상관x
	
	var userAgent = req.header("User-Agent");//브라우저 정보 Mozilla가 브라우저를 처음만든 회사 M/S에 합병됌
	
	var paramId = req.body.id; 
	var paramPwd = req.body.pwd; 
	//var paramName = req.body.name //Post방식으론 받을 수 없듬
	
	
	res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
	res.write("<h1>Express 서버에서 응답한 결과</h1>")
	res.write("<div><p>ID: " + paramId + "</p></div>");
	res.write("<div><p>Pwd: " + paramPwd + "</p></div>");
	res.end();
});



//Express 서버 시작
//var server = http.createServer();

http.createServer(app).listen(app.get("port"),function(){ //위에 set으로 넣어둔 port를 get으로 가져온거

	console.log("익스프레스 서버 on~~ 포트번호는:" + app.get("port"));
	
});






























