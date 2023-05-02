//session 사용
// npm install express-session --save



//Express 기본 모듈
require("dotenv").config();
var express = require("express");
var http = require("http");
var path = require("path");
var serveStatic = require("serve-static"); //특정 폴더를 패스로 접근 가능하게 하는것.
var expressErrorHandler = require("express-error-handler");
var cookieParser = require("cookie-parser");

//Session 추가
var expressSession = require("express-session");

//익스프레스 객체 생성
var app = express();

//기본 포트를 app 객체의 속성으로 설정
//express 서버 객체의 메소드(set.get.use)
app.set("port",process.env.PORT)

app.use(express.urlencoded({extended:false}));

app.use("/public",serveStatic(path.join(__dirname,"public"))); //public (실제)폴더의 이름을 써준것

app.use(cookieParser());

// 세션 설정
// secret – 쿠키를 임의로 변조하는것을 방지하기 위한 sign 값 입니다. 원하는 값을 넣으면 됩니다.
// resave – 세션을 언제나 저장할 지 (변경되지 않아도) 정하는 값입니다. 
// express-session documentation에서는 이 값을 false 로 하는것을 권장하고 필요에 따라 true로 설정합니다.
// saveUninitialized – uninitialized 세션은 새로 생겼지만 변경되지 않은 세션을 의미합니다. 
// Documentation에서 이 값을 true로 설정하는것을 권장합니다.
app.use(expressSession({
	
	secret:"my key",
	resave:true,
	saveUninitialized:true
	
}));


//라우터 객체 추가 
var router = express.Router();


// 라우팅 함수 등록
router.route("/process/login").post(function(req,res){ 
	
	console.log("/process/login 호출.."); 
	
	var id = req.body.id;
	var pwd = req.body.pwd;
	
	if(req.session.user) {
		
		console.log("이미 로그인 되어서 상품 페이지로 이동..");
		
		res.redirect("/public/product.html");
		
	} else {
		
		if(id=="suzi" && pwd=="a123") {
			
			//세션 저장
			req.session.user={
					
				id:id,
				name:"배수지",
				authorize:true
			};
			
			res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
			res.write("<h1>로그인 성공</h1>")
			res.write("<div><p>ID: " + id + "</p></div>");
			res.write("<div><p>Pwd: " + pwd + "</p></div>");
			res.write("<div><p>Name: " + req.session.user.name + "</p></div>");
			res.write("<br><br><a href='/process/product'>상품페이지</a>");
			res.end();
			
			
		}
		
	}
	
});

router.route("/process/product").get(function(req,res) { 
	
	console.log("/process/product 호출..");
	
	if(req.session.user) {
		
		console.log("로그인 되어있음.");
		res.redirect("/public/product.html");
		
	} else {
		
		console.log("로그인 먼저하세요.");
		res.redirect("/public/login3.html");
	}
	
});

router.route("/process/logout").get(function(req,res) { 
	
	console.log("/process/logout 호출...");
	
	if(req.session.user) {
		
		console.log("로그아웃 합니다");
		
		//세션 삭제
		//req.session.destroy(); // 단순 삭제
		
		req.session.destroy(function(err) {
			
			if(err) throw err;
			
			console.log("세션을 삭제하고 로그 아웃 되었습니다.");
			
			res.redirect("/public/login3.html");
			
		});
		
	}else {
		
		console.log("로그인 되어있지 않습니다.");
		
		res.redirect("/public/login3.html");
		
	}
	
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






























