
/*
 패스포트는 수백가지 인증방식(Strategy)을 제공하는데
 어떤 인증 방식을 사용할 지 Strategy를 선택
 Local Strategy, Facebook Strategy, Google Strategy..
 
 *대표적 인증 방식
  로컬 인증: 데이터베이스에 저장된 사용자 정보와 비교
  OAuth2.0 인증: 페이스북이나 카카오계정 사용
 
 *모듈 설치

사용자 인증 처리 필수 모듈
npm install passport --save  

로컬 인증 기능(사용자 입력 정보와 DB정보 비교)
npm install passport-local --save 아이디와 패스워드로 사용자 인증을 할것이다 하면은 이 local모듈을 다운로드 //옵션
ex) npm install passport-kakao -save

요청객체에 메세지를 넣어둘 수 있는 기능
다른 함수나 뷰템플릿 처리 함수에 메세지 전달
사용자에게 메세지 전달
npm install connect-flash --save 메세지를 주고 받을수 있게 해주는 모듈을 다운로드 //필수


로컬 인증기능
id(email) / pwd

로컬 인증을 할때 2개의 메서드가 있다.
-serializeUser():사용자 로그인(인증) 성공 시 호출
-deserializeUser():사용자 로그인(인증) 이후 사용자 요청 시마다 호출

 */



require("dotenv").config();
var express = require("express");
var http = require("http");
var path = require("path");
//var bodyParser = require("body-parser"); //예전에는 bodyParser를 호출해야 했지만 express에 내장이 되어 안써도 괜춘
var serveStatic = require("serve-static"); //특정 폴더를 패스로 접근 가능하게 하는것.
var expressErrorHandler = require("express-error-handler");
var expressSession = require("express-session");

//
var passport = require("passport");
var flash = require("connect-flash");


var config = require("./config"); 
var database = require("./database/database");
var routerLoader = require("./router/routerLoader");

//익스프레스 객체 생성
var app = express();

//뷰 엔진 설정
app.set("views",__dirname + "/views");
app.set("view engine","ejs"); //엔진을 ejs로 할꺼얌
console.log("뷰엔진이 ejs로 설정되었습니다.");



app.set("port",process.env.PORT||config.serverPort);

app.use(express.urlencoded({extended:false}));

app.use("/public",serveStatic(path.join(__dirname,"public"))); //public (실제)폴더의 이름을 써준것
//사용자정의

app.use(expressSession({

	secret:"my key",
	resave:true,
	saveUninitialized:true

}));

app.use(passport.initialize());
app.use(passport.session());
app.use(flash());



//라우터 객체 생성
var router = express.Router();

routerLoader.init(app,router);

//이런 구조로 만들 것이다.
/*
클라이언트 요청     웹서버		       뷰템플릿

홈화면조회	    /(get)		    홈화면(index.ejs)
로그인화면	    /login(get)	    로그인화면(login.ejs)   
로그인요청	    /login(post)	로그인처리(함수)
회원가입화면	/signup(get)	회원가입화면(signup.ejs) = created.jsp
회원가입요청	/signup(post)	회원가입처리(함수)       = created_ok.jsp
사용자프로필	/profile(get)	프로필화면(profile.ejs)
로그아웃요청	/logout(get)	로그아웃처리(함수)
*/

//홈화면
router.route("/").get(function(req,res) {
	res.render("index.ejs");
});

//로그인 화면
router.route("/login").get(function(req,res) {
	
	res.render("login.ejs", {message:req.flash("loginMessage")}); //로그인 메세지를 받는다. (하단에 loginMessage 들)
});

//로그인 요청
router.route("/login").post(passport.authenticate("local-login",{//아래 만들어둔 함수 찾아가는것 함수명과같아야함
	
	successRedirect : "/profile", //로그인 성공시
	failureRedirect : "/login", //로그인 실패시
	failureFalsh : true //실패했을때 메세지를 띄우겠다 true
}));

//회원가입 화면
router.route("/signup").get(function(req,res) {
	
	res.render("signup.ejs", {message:req.flash("signupMessage")}); //signupMessage를 받는다. (하단에 있음)
});

//회원 가입
router.route("/signup").post(passport.authenticate("local-signup",{  //196줄로 간다.
	
	successRedirect : "/profile", // 성공
	failureRedirect : "/signup", // 실패
	failureFalsh : true //실패 메세지 
	
}));

//프로파일
router.route("/profile").get(function(req,res) {
	
	//인증 실패인 경우
	if(!req.user) {
		console.log("사용자 인증이 안된 상태");
		
		//인증이 안됬으니 메인 페이지로 가야 한다.
		res.redirect("/");
		return;
	}
	
	//인증 성공일 경우
	console.log("사용자 인증된 상태");
	
	if(Array.isArray(req.user)) { //배열 안에 데이터가 있으면
		res.render("profile.ejs",{user:req.user[0]._doc}); // 넘어갈 때 user의 0번째 doc를 몽땅 가져간다.
	}else {
		res.render("profile.ejs",{user:req.user}); //혹시몰라서 한번 더 써줌
	}
	
});

//로그아웃
router.route("./logout").get(function(req,res) {
	
	req.logout(); //logout 함수 호출
	res.redirect("/"); //리다이렉트로 홈화면으로 넘어감
});

// *********************************************************************

// 로그인
//- Passport Strategy 설정
var LocalStrategy = require("passport-local").Strategy;

//패스포트 로그인
//use(이름,인증방식객체) - 이름은 함수 구분 용도
//done() 메서드는 예약어(내장 메서드) - 이름변경x
passport.use("local-login", new LocalStrategy({
	
	usernameField : "email",
	passwordField : "pwd",
	
	//아래 콜백함수의 첫번째 파라미터로 req 객체를 전달함
	passReqToCallback : true
	
	}, function(req,email,pwd,done) {
		
		//데이터베이스 객체
		var database = app.get("database");
		
		database.UserModel.findOne({"email":email}, function(err,user) { //이메일을 잘 찾았으면 함수 실행
			
			if(err) {return done(err);}
			
			if(!user) { // 등록자가 없을 때
				
				console.log("등록된 계정이 없습니다.");
				
				//검증 콜백에서 2번째 파라미터 값을 false로 해서
				//인증 실패한 것으로 처리
				return done(null,false,req.flash("loginMessage","등록된 계정이 없습니다."));
				
			}
			
			// 비밀번호를 비교해서 틀릴 경우
			var authenticated = 
				user.authenticate(pwd, user._doc.salt, user._doc.hashed_password);
			
			if(!authenticated) {
				
				console.log("비밀번호가 일치하지 않음.");
				
				return done(null,false,req.flash("loginMessage","비밀번호가 일치하지 않음."));
			}
			
			// 비밀번호를 비교해서 맞을 경우
			console.log("비밀번호가 일치함.");
			
			return done(null,user); //user를 보낸다. user 안에 email이 있음
		});
		
	}));


// 패스포트(passport) 회원가입
passport.use("local-signup", new LocalStrategy({

	usernameField : "email",
	passwordField : "pwd",
	
	//아래 콜백함수의 첫번째 파라미터로 req 객체를 전달함
	passReqToCallback : true
	
	},function(req,email,pwd,done) {
		
		var name = req.body.name;
		
		process.nextTick(function() { //nextTick()는 동기화 방식을 지원
			
			var database = app.get("database");
			
			database.UserModel.findOne({"email":email},function(err,user){
				
				if(err) {return done(err);}
				
				//이미 회원가입이 되어 있는 경우
				if(user) {
					
					console.log("회원가입이 되어 있습니다.");
					
					return done(null,false,req.flash("signupMessage","이미 회원가입이 되어 있다."));
					
				} else {
					
					var user = new database.UserModel({"email":email,"pwd":pwd,"name":name});
					
					user.save(function(err) {
						
						if(err) {throw err;}
						
						console.log("사용자 데이터 추가함.");
						
						return done(null,user);
						
					}); //end if
				} //end findOne
				
			});// end nextTick
			
		}); // end function
		
	}
	
));



// 사용자 인증 성공시 호출
// 사용자 정보를 이용해서 세션을 만듬
passport.serializeUser(function(user,done) {
	
	console.log("serializeUser 호출됨.");
	
	//이 인증 콜백함수에서 넘겨주는 user 객체의 정보로 
	//session을 생성
	done(null,user);
});

// 사용자 인증 후 사용자 요청시마다 호출
// user : 사용자 인증 성공시 serializeUser 함수를 이용해서 
//        만든 세션정보가 파라미터로 넘어옴
passport.deserializeUser(function(user,done) {
	
	console.log("deserializeUser 호출됨.");
	
	done(null,user);
});



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






























