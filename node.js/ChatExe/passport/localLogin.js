
var LocalStrategy = require("passport-local").Strategy;

module.exports = new LocalStrategy({
	
	usernameField : "email",
	passwordField : "pwd",
	
	//아래 콜백함수의 첫번째 파라미터로 req 객체를 전달함
	passReqToCallback : true
	
	}, function(req,email,pwd,done){
		
		//데이터베이스 객체
		var database = req.app.get("database");
		
		database.UserModel.findOne({"email":email},function(err,user){
			
			if(err) {return done(err);}
			
			if(!user){ //등록자가 없을때
				
				console.log("등록된 계정이 없습니다.");
				
				//검증 콜백에서 두번째 파라미터 값을 false로 해서 
				//인증 실패한것으로 처리
				return done(null,false,req.flash("loginMessage","등록된 계정이 없습니다."));
				
			}
			
			//비밀번호를 비교해서 틀릴경우
			var authenticated = 
				user.authenticate(pwd, user._doc.salt, user._doc.hashed_password);
			
			if(!authenticated){
				
				console.log("비밀번호가 일치하지 않음.");
				
				return done(null,false,req.flash("loginMessage","비밀번호가 일치하지 않음."));				
				
			}
						
			//비밀번호가 맞을경우			
			console.log("비밀번호가 일치함.");
			
			return done(null,user);			
			
		});
		
	});

















