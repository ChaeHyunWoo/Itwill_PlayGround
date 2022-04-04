

//Express 기본 모듈
require("dotenv").config();
var express = require("express");
var http = require("http");
var path = require("path");
var serveStatic = require("serve-static"); 
var expressErrorHandler = require("express-error-handler");
var expressSession = require("express-session");

//몽고DB 모듈
var MongoClient = require("mongodb").MongoClient;

//데이터베이스 객체를 위한 변수
var database; //java에서 conn 만든거랑 같은 의미

//데이터베이스 연결
function connectDB() {
	
	//데이터베이스 연결 정보
	var databaseUrl = "mongodb://localhost:27017/shopping";
	
	//연결
	MongoClient.connect(databaseUrl,function(err,dbase) { // err는 연결안됬을 때 / dbase는 성공적으로 연결됬을 때
		
		if(err) throw err;
		
		console.log("데이터베이스에 연결되었습니다 : " + databaseUrl);
		
		database = dbase.db("shopping"); // conn만들기 끝
		
	});
	
}

//익스프레스 객체 생성
var app = express();

app.set("port",process.env.PORT||3000);

app.use(express.urlencoded({extended:false}));

app.use("/public",serveStatic(path.join(__dirname,"public"))); //public (실제)폴더의 이름을 써준것

app.use(expressSession({
	
	secret:"my key",
	resave:true,
	saveUninitialized:true
	
}));


var errorHandler = expressErrorHandler({
	
	static : {
		"404":"./public/404.html"
	}
	
});

app.use(expressErrorHandler.httpError(404));
app.use(errorHandler);


//Express 서버 시작
http.createServer(app).listen(app.get("port"),function(){ //위에 set으로 넣어둔 port를 get으로 가져온거

	console.log("익스프레스 서버 on~~ 포트번호는:" + app.get("port"));
	
	//서버 시작할때 db로 실행해주면 된다.
	// - DB연결 함수 호출
	connectDB();
	
});
