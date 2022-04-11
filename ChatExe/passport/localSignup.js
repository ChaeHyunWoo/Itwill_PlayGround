

var LocalStrategy = require("passport-local").Strategy;

module.exports = new LocalStrategy({

	usernameField : "email",
	passwordField : "pwd",
	
	//아래 콜백함수의 첫번째 파라미터로 req 객체를 전달함
	passReqToCallback : true
	
	},function(req,email,pwd,done) {
		
		var name = req.body.name;
		
		process.nextTick(function() { //nextTick()는 동기화 방식을 지원
			
			var database = req.app.get("database");
			
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
	
);
