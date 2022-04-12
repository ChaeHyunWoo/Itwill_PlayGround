

var moment = require("moment");

//로그인 라우터
var login = function(req,res) {
	
	console.log("/process/login 호출..");
	
	var id = req.body.id;
	var pwd = req.body.pwd;
	
	
	var database = req.app.get("database");
	
	if(database){
	
		authUser(database, id, pwd, function(err,result){
			
			if(err) {throw err;}
			
			if(result){
				
				var userName = result[0].name;
				
				var context = {userId:id,userName:userName};

				//req.app.render("login.ejs",context,function(err,html){//뷰엔진을 꺼냈다. ejs
				req.app.render("login_Success.jade",context,function(err,html){//jade
					
					if(err){
						
						res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
						res.write("<h1>뷰 렌더링 하는데.. 에러났어.</h1>")
						res.write("<br/><br/><a href='/public1/login.html'>다시 로그인</a>");
						res.end();

						
						return;
						
					}
					
					res.end(html);
					
				});
						
				
			}else{
				
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h1>로그인 실패</h1>")				
				res.write("<div>아이디 또는 패스워드를 확인하세요</div>");
				res.write("<br/><br/><a href='/public1/login.html'>다시 로그인</a>");
				res.end();
			}	
		});
		
	}else{
		
		res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
		res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
		res.write("<h1>데이터베이스 연결 실패</h1>")				
		res.write("<div>데이터베이스를 연결하지 못했습니다.</div>");		
		res.end();		
	}	
	
};

//회원가입 라우터
var addUsers = function(req,res) {
	
	console.log("/process/addUser 호출..");
	
	var database = req.app.get("database");
	
	var id = req.body.id;
	var pwd = req.body.pwd;
	var name = req.body.name;
	
	if(database){
		
		addUser(database, id, pwd, name, function(err,result){
			
			if(err) {throw err;}
			
			if(result){
				
				var context = {title:"사용자 추가 성공(View-ejs)"};
				
				req.app.render("addUser.ejs", context, function(err,html) {
					
					if(err){
						
						res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
						res.write("<h1>뷰 렌더링 하는데.. 에러났어.</h1>")
						res.write("<br/><br/><a href='/public1/login.html'>다시 로그인</a>");
						res.end();

						return;		
					}
					
					res.end(html);
					
				});
				
			}else{		
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h1>사용자 추가 실패</h1>")
				res.write("<br/><br/><a href='/public1/login.html'>다시 로그인</a>");
				res.end();			
			}
		});
		
		
	}else{
		
		res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
		res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
		res.write("<h1>데이터베이스 연결 실패</h1>")				
		res.write("<div>데이터베이스를 연결하지 못했습니다.</div>");		
		res.end();
		
	}
	
}

//리스트 라우터
var listUser = function(req,res) {
	
	console.log("/process/listUser 호출됨")
	
	var database = req.app.get("database");
	
	// db에서 데이터 가져옴
	
	if(database) { // 데이터베이스 객체가 있으면 연결해서 데이터 가져옴
		
		/*UserSchema.static("findAll",function(callback){
			return this.find({}, callback);
		})*/
		
		// 함수 호출하면됨 
		database.UserModel.findAll(function(err,result){  // 모든데이터 가져오는 메소드 static("findAll",  -> find{} 넘겨주는값이 필요없음 function(err,result) 로 처리 
			
			
			if(err) { // 에러가 발생하면 
				
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>사용자 리스트 조회중 에러 발생</h2>")
				res.write("<br/><br/><a href='/public1/login.html'>다시 로그인</a>");
				res.end();
				
				return; // 밑에 실행하지 않게 return 꼭 써줌 
			}
			
			if(result){ // 정상적으로 데이터를 가지고 왔을때
				
				var context = {result:result, moment:moment}; 
				
				//req.app.render("listUserResp.ejs",context,function(err,html) { 이건 ejs
				req.app.render("listUserResp_Success.jade",context,function(err,html) {
					
					if(err){
						
						res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
						res.write("<h1>뷰 렌더링 하는데.. 에러났어.</h1>")
						res.end();

						return;
						
					}
					
					res.end(html);
					
				});
				
			} else {
				// 데이터가 없을 경우 
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>사용자 조회 실패</h2>")	
				res.write("<br/><br/><a href='/public1/login.html'>다시 로그인</a>");
				res.end();
			}
		})  	
	}	
	
}


//사용자를 인증하는 함수
var authUser = function(database,id,pwd,callback){
	
	console.log("authUser 함수 호출..");
			
	
	
	//id가 function(id,callback) 에서 find({id:id}로 찾아 오게되면서 결과가 callback함수가 에러면 err 잘나오면result 로 들어감
	// 즉 , 콜백함수는 id를 찾았을경우 실행된결과를 받음
	
	//아이디와 비밀번호 검색
	database.UserModel.findById(id, function(err,result){ 		

		// 에러가 있으면 이걸 실행 
		if(err) {
			callback(err,null);
			return;
		}
		
		//데이터가 있을경우
		if(result.length>0){	
			console.log("아이디와 일치하는 사용자 찾음")
			// 무조건 배열로 넘어옴
			
			// ._doc = 도큐먼트 DB 값을 비교
			
			
			// 암호화된 데이터 비교
			var user = new database.UserModel({id:id});
			
			var authenticated = 
									
				user.authenticate(pwd,result[0]._doc.salt,result[0]._doc.hashed_password); // 위에 메소드 UserSchema.method("authenticate",function(inputPwd,inSalt,hashed_password) 호출
											// pwd , salt키 = db암호화된 비교작업
			
			// authenticated 에는 true 아니면 fasle 가 들어가게됨
			
		
		} if(authenticated){ // 사용자가 입력한 pwd가 일치하나 ?  	
				console.log("비밀번호 일치함")
				callback(null,result); // 에러는 없으니 null ,데이터 있으니 result 는 넣어줌 	
			
		} else {
			console.log("비밀번호가 일치하지 않음");
			callback(null,null); // 에러없고 결과가 없으니 null , null
			
			}
						
		/*} else {
			
			console.log("아이디와 일치하는 데이터가 없습니다.");
			callback(null,null); // 에러없고 결과가 없으니 null , null
		
			
		}*/
		
	}); //여기까진 라우터
	
}
//---------------------------------
//사용자를 추가하는 함수
var addUser = function(database,id,pwd,name,callback){
	
	console.log("addUser 함수 호출..");
	
	var users = new database.UserModel({"id":id, "pwd":pwd, "name":name});
	
	users.save(function(err,result){
		
		if(err){
			callback(err,null);
			return;
		}
		
		if(result){
			
			console.log("사용자 추가..");
			
		}else{
			console.log("사용자 추가 실패..");
		}
		callback(null,result);			
	});
	
};


//위의 함수들을 외부에서 사용하기 위해
//module.exports.init = init; //이걸 호출하는 순간 DB,스키마 등이 넘어오는 것
module.exports.login = login;
module.exports.addUser = addUsers;
module.exports.listUser = listUser;





