/*
http://localhost:3000

미들웨어 : 하나의 독립된 함수(use 메서드로 설정)
라우터 : (요청 패턴 /,/users,/sales,/bbs)

클라이언트 요청 -> 미들웨어#0 -> 라우터(/) -> 클라이언트 응답
클라이언트 요청 -> 미들웨어#0 -> 라우터(/users) -> 클라이언트 응답
클라이언트 요청 -> 미들웨어#0 -> 라우터(/sales) -> 클라이언트 응답
*/



// Express 기본 모듈
var express = require("express");
var http = require("http");

//익스프레스 객체 생성
var app = express();

//기본 포트를 app객체의 속성으로 설정
//express 서버 객체의 메서드(set,get,use)
app.set("port",process.env.PORT||3000);


//미들웨어 객체(use) 생성
// - 미들웨어는 따로 호출안해도 자동으로 실행된다. / 여러 개 있으면 미들웨어1이 끝나면 미들웨어2가 자동으로 실행
// - 브라우저에서 request가 왔을 때 서버에서 어떤 작업을 할 지 router를 통해 설정
app.use(function(req,res,next) { //사용자의 요구가 이상없이 들어오면 next가 실행
	
	console.log("첫번째 미들웨어 실행..");
	
	//res.writeHead("200", {"Content-type":"text/html;charset=utf-8"});
	//res.end("<h1>Express 서버에서 응답한 결과입니다.</h1>")
	
	req.user ="suzi";
	
	next(); //두번 째 미들웨어로 처리를 넘긴다.
	
});

//미들웨어 객체 생성
// - 이 코드가 없으면 웹 접속 시 Cannot Get / 이 뜬다.
app.use("/",function(req,res,next) {
	
	console.log("두번째 미들웨어 실행..");
	
	res.writeHead("200", {"Content-type":"text/html;charset=utf-8"});
	res.end("<h1>Express 서버에서" + req.user + "응답한 결과입니다.</h1>")
	
});


//Express 서버 시작
http.createServer(app).listen(app.get("port"),function() {
	
	console.log("익스프레스 서버를 시작했습니다: " + app.get("port"));
	
});

