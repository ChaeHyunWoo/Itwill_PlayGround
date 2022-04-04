
/*
  http://localhost:3000
  
  미들 웨어 : 하나의 독립된 함수 (use 메소드로 설정)
  라우터 : (요청 패턴 /,/users,/sales/bbs)
  
  클라이언트요청 -> 미들웨어 #0 -> 라우터(/) -> 클라이언트의 응답
  
	클라이언트가 요청 -> Middleware#1 -> Router(/users) -> 클라이언트의 응답
	클라이언트가 요청 -> Middleware#2 -> Router(/sales) -> 클라이언트의 응답
  
*/
 

//Express 기본 모듈
var express = require("express");
var http = require("http");

//익스프레스 객체 생성
var app = express();

//기본 포트를 app객체의 속성으로 설정
//express 서버객체의 메소드(set,get,use)
app.set("port",process.env.PORT||3000);//익스프레스 안에 app에 port를 넣는다 

//미들웨어 객체(use) 생성
app.use(function(req,res,next) {
	
	console.log("첫번째 미들웨어 실행...");
	
	res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
	res.end("<h1>Express 서버에서 응답한 결과입니다.</h1>")
	
	req.user = " suzi ";
	
	//json형태의 데이터 그대로 보여준다
	res.send({name:'배수지',age:27});
	
	res.status(403).send("접근금지!!");
	res.redirect("http://m.naver.com");
	
	//Get 방식 : req.query.name
	//POST 방식 :req.body.name
	//GET POST 방식  : req.param('name')
	
	var userAgent = req.header("User-Agent");//브라우저 정보 
	
	//var paramName = req.query.name;//get방식
	var paramName = req.param('name'); // 이렇게도 가능 = get,post 방식
	var paramName = req.body.name ; //post방식 -> Error 뜬다.
	

	res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
	res.write("<h1>Express 서버에서 응답한 결과입니다.</h1>")
	res.write("<div><p>User-Agent: " + userAgent + "</p></div>");
	res.write("<div><p>User-Agent: " + paramName + "</p></div>");
	res.end();
	
	
	//next();
	
});

app.use(function(req,res,next){
	
	console.log("두번째 미들웨어 실행..");
	
	res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
	res.end("<h1>Express 서버에서" + req.user +  "응답한 결과입니다.</h1>")
	
});

//Express 서버 시작
//var server = http.createServer();

http.createServer(app).listen(app.get("port"),function(){
	console.log("익스프레스 서버를 시작했습니다 " + app.get("port"));
});

