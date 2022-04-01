
// Express 기본 모듈
var express = require("express");
var http = require("http");

//익스프레스 객체 생성
var app = express();

//기본 포트를 app객체의 속성으로 설정
//express 서버 객체의 메서드(set,get,use)
app.set("port",process.env.PORT||3000); //port에 3000번을 넣을 것이다.
//env안에 포트가있으면 기존 포트를 쓰고 없으면 3천을 써라

//Express 서버 시작
http.createServer(app).listen(app.get("port"),function() {
	
	console.log("익스프레스 서버를 시작했습니다: " + app.get("port"));
	
});