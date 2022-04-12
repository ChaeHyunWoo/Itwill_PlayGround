

module.exports = function(router,passport) {
	
	console.log("userPassport 호출됨");
	
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
	
}
