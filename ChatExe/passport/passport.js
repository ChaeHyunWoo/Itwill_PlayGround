
var localLogin = require("./localLogin");
var localSignup = require("./localSignup");


module.exports = function(app,passport) {
	
	console.log("passport.js 호출됨");
	
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
//	        만든 세션정보가 파라미터로 넘어옴
	passport.deserializeUser(function(user,done) {
		
		console.log("deserializeUser 호출됨.");
		
		done(null,user);
	});
	
	//인증방식 설정
	passport.use("local-login",localLogin);
	passport.use("local-signup",localSignup);
	
}