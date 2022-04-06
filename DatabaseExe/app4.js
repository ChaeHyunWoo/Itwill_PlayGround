//암호화
//npm install crypto --save
//crypto 모듈은 pwd + salt(key)를 합쳐서 암호화 //salt(key)는 사용자정의

//Express 기본 모듈
require("dotenv").config();
var express = require("express");
var http = require("http");
var path = require("path");
//var bodyParser = require("body-parser"); //예전에는 bodyParser를 호출해야 했지만 express에 내장이 되어 안써도 괜춘
var serveStatic = require("serve-static"); //특정 폴더를 패스로 접근 가능하게 하는것.
var expressErrorHandler = require("express-error-handler");
var expressSession = require("express-session");
var mongoose = require("mongoose");

//crypto(암호화) 모듈
var crypto = require("crypto");

//데이터베이스 객체를 위한 변수
var database; //==connection conn; 과 같음
//데이터베이스 스키마를 위한 변수
var UserSchem;
//데이터베이스 모델을 위한 변수
var UserModel;

//데이터베이스 연결
function connectDB() {

	//데이터베이스 연결 정보
	var databaseUrl = "mongodb://localhost:27017/shopping";

	//연결
	mongoose.connect(databaseUrl); //mongoose로 연결
	
	database = mongoose.connection;
	
	database.on("open",function(){//open이라는 내장이벤트 //db가 열려있는가
		
		console.log(" 데이터베이스가 연결 되었습니다: " + databaseUrl);
		
		//스키마,모델 객체
		createUserSchema();
		
		
	}); 
						//function자리에 한번에써준것.
	database.on("error",console.error.bind(console,"몽구스 밥버거 에러")); //이렇게 한줄로 써줄수도있다.
									
	database.on("disconnected",function() {
		
		console.log("DB연결이 끊겼습니다 5초후 재연결 합니다.");
		setInterval(connectDB(),5000); //디비연결이 끊기면 5초마다 다시 연결하는 함수를 실행
	});
}

function createUserSchema(){
	
	//스키마 정의
	UserSchema = mongoose.Schema({
		id:{type:String,required:true,unique:true}, //반드시 써야하나 required:Not null, unique:primary key 비슷한 개념 
		hashed_password:{type:String,required:true}, //암호화된password
		salt:{type:String,required:true}, //암호화 key값
		name:{type:String},
		age:{type:Number,'default':20}, //age값을 입력안하면 기본값으로 20이 들어가게
		created:{type:Date,index:{unique:false},'default':Date.now} //유일값이아닌 같은값이 들어가도됌:unique:false
																	//날짜값을 안넣으면 기본값으로 현재시간 넣어라
	});
	
	UserSchema
		.virtual("pwd")
		.set(function(pwd){ //위 변수값을 읽어오는것
			
			//this._password _를 붙여줘야함 변수로 사용한것
			this._password = pwd;
			this.salt = this.makeSalt(); //makeSalt 메소드 아래 만듬
			this.hashed_password = this.encryptPassword(pwd);//encryptPassword 메소드 아래만듬
		})
		.get(function(){
			
			return this._password; //위에 정의해준 hashed_password에 반환
		});
	
		UserSchema.method("makeSalt",function(){
			
			console.log("date : " + new Date().valueOf());//12321423423
			console.log("math : " + Math.random());//0.12321423423 실시간으로 변하는 난수값을 암호화에 사용
			
			return Math.round((new Date().valueOf() * Math.random())) + "";
		});
		
		UserSchema.method("encryptPassword",function(inputPwd,inSalt){ //패스워드와 salt값을 주어야 아래에서 합쳐짐
			
			if(inSalt){
				//inSalt와 사용자가 입력한 pwd를 sha1방식으로 암호화 한 파일을 16진수의 hex상태로 저장되는 것
				return crypto.createHmac("sha1",inSalt).update(inputPwd).digest("hex");//sha1 쉬바1로 읽고 hex는 헥사로 읽음
			
			}else{
				
				return crypto.createHmac("sha1",this.salt).update(inputPwd).digest("hex");
			}
			
		});
		
		//로그인할때 패스워드 비교
		UserSchema.method("authenticate",function(inputPwd,inSalt,hashed_password){//입력된 암호와, salt, 암호화된 패스워드
			
			if(inSalt){
				
				console.log("사용자 입력된 pwd: " + inputPwd);
				console.log("암호화된 pwd: " + this.encryptPassword(inputPwd,inSalt));
				console.log("DB에 저장되어있는 pwd: " + hashed_password);
				
				return this.encryptPassword(inputPwd,inSalt)==hashed_password;//입력값과 DB값이 일치하면true,
																			  //일치하지않으면false 값을 반환
			}else{
				
				console.log("사용자 입력된 pwd: " + inputPwd);
				console.log("암호화된 pwd: " + this.encryptPassword(inputPwd,inSalt));
				console.log("DB에 저장되어있는 pwd: " + hashed_password);
				
				return this.encryptPassword(inputPwd)==this.hashed_password; //true,false
				
			}
		});
	
	
	//스키마 객체에 메소드를 추가(방법: static(), method() 두가지)
	//로그인에 사용
	UserSchema.static("findById",function(id,callback){ //findById는 메소드이름
		return this.find({id:id}, callback);
	})
	
	//전체 데이터 사용(가져오기)
	UserSchema.static("findAll",function(callback){
		return this.find({},callback);
	});
	
	console.log("UserSchema 정의함."); //위 작업을 처리하고 콘솔창에 뜸	
	
	//Model 정의			//새로운 컬렉션(테이블)을 만들고 UserSchema를 적용
	UserModel = mongoose.model("users3",UserSchema);//users2 테이블에 UserSchema를 적용해라
	
	console.log("UserModel 정의함.");
	
}

//익스프레스 객체 생성
var app = express();

app.set("port",process.env.PORT||3000);

app.use(express.urlencoded({extended:false}));

app.use("/public",serveStatic(path.join(__dirname,"public"))); //public (실제)폴더의 이름을 써준것
//사용자정의

app.use(expressSession({

	secret:"my key",
	resave:true,
	saveUninitialized:true

}));

//작업하는 함수를 만들고 그걸 불러쓰는 라우터를 만듬.
//사용자를 인증하는 함수
var authUser = function(database,id,pwd,callback){ //위에서 만든 database

	console.log("addUser 함수 호출");

	//아이디와 비밀번호 검색 //아래function이 findById의 callback 함수
	UserModel.findById(id,function (err,result){  //모델에 findById 메소드를 정의해둔것 사용
		
		//스키마와 모델을 정의해준값에 의해 UserModel에 users가 들어있는것
		if(err){
			callback(err,null); //에러가 있으면 에러 출력후 스톱
			return;
		}

		//데이터가 있을경우
		if(result.length>0){
			
			console.log("아이디와 일치하는 사용자 찾았당 (●'◡'●) ");
			
			var user = new UserModel({id:id});
			
			var authenticated = //UserSchema.method("authenticate") 위에 스키마에 설정해준값 사용
				user.authenticate(pwd, result[0]._doc.salt,result[0]._doc.hashed_password);
			
			if(result[0]._doc.pwd==pwd){ //_doc는 문법 반드시 붙여줘야함 document (문서,컬럼)
				
				console.log("비밀번호 일치 ╰(*°▽°*)╯");
				
				callback(null,result);
			}else{
				
				console.log("비밀번호가 일치하지 않음 (┬┬﹏┬┬)");
				
				callback(null,null);
			}

		}else{

			console.log("아이디와 일치하는 데이터가 없습니다 ╮（╯＿╰）╭");
			callback(null,null); //에러도 없으니깐 null,데이터도없으니깐 null
		}
	});


}

//사용자를 추가하는 함수
var addUser = function(database,id,pwd,name,callback){

	console.log("addUser 함수 호출");

	var users = new UserModel({"id":id,"pwd":pwd,"name":name});

	users.save(function(err,result){

		if(err){
			callback(err,null);
			return;
		}

		if(result){

			console.log("사용자 추가~");
			

		}else{

			console.log("사용자 추가 실패 ㅠ-ㅠ");
		}

		callback(null,result);
	});

};

//-----------------------------------------------------------------------------
//라우터 객체 생성
var router = express.Router();

//로그인 라우터
router.route("/process/login").post(function(req,res){

	console.log("/process/login 호출");

	var id = req.body.id;
	var pwd = req.body.pwd;

	if(database){
		//callback함수가 되는것
		authUser(database, id, pwd, function(err,result){ //위 사용자 인증 함수로 올라감

			if(err) throw err;

			if(result){ //데이터가 있으면

				var userName = result[0].name;//위에서 데이터를 배열로 받기로 했슴

				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h1>로그인 성 공 ~ ~</h1>");
				res.write("<div>아이디: " + id + "</div>");
				res.write("<div>이름: " + userName + "</div>");
				res.write("<br><br><a href='/public/login.html'>다시 로그인</a>");
				res.end();

			}else{

				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h1>로그인 실 패 ㅠ-ㅠ</h1>");
				res.write("<div>아이디또는 패스워드를 확인하세요</div>");
				res.write("<br><br><a href='/public/login.html'>다시 로그인</a>");
				res.end();

			}

		});


	}else{

		res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
		res.write("<h1>DB연결 실 패 ㅠ-ㅠ</h1>");
		res.write("<div>DB를 연결하지 못했습니다</div>");
		res.end();

	}
});

router.route("/process/addUser").post(function(req,res){

	console.log("/process/addUser 호출");

	var id = req.body.id;
	var pwd = req.body.pwd;
	var name = req.body.name;

	if(database){

		addUser(database,id,pwd,name, function(err,result){ //함수속 매개변수는 사용자 정의

			if(err) throw err;

			if(result){

				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h1>사용자 추가 성공</h1>");
				res.end();


			}else{

				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h1>사용자 추가 실패</h1>");
				res.end();

			}

		});

	}else{

		res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
		res.write("<h1>DB연결 실 패 ㅠ-ㅠ</h1>");
		res.write("<div>DB를 연결하지 못했습니다</div>");
		res.end();

	}

});

//사용자 리스트 라우터
router.route("/process/listUser").post(function(req,res){//listUser.html에 action값과 같아야함 거기서 post로 보내주눈거
	
	console.log("/process/listUser 호출");
	
	if(database){
		
		UserModel.findAll(function(err,result){
			
			if(err){ //에러 발생 했을때
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h2>사용자 리스트 조회중 에러 발생 Σ(っ °Д °;)っ </h2>");
				res.end();
				
				return;
			}
			
			if(result){ //정상적으로 데이터를 가져왔을때
				
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h2>사용자 리스트 ( •̀ ω •́ )✧ </h2>");
				res.write("<div><ul>");
				
				for(var i=0;i<result.length;i++){//result의 값이 없을때 까지
					
					var id = result[i]._doc.id;
					var name = result[i]._doc.name;
					var age = result[i]._doc.age;
					
					res.write("<li>#" + (i+1) + ":" + id + ", " + name + ", " + age + "</li>")
							//i의 시작은 0부터 일렬번호 붙여주기 위해
				}
				
				res.write("</ul></div>");
				res.write("<br><br><a href='/public/listUser.html'>리스트</a>");
				res.end();
				
			}else{
				res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
				res.write("<h2>사용자 리스트 조회 실패</h2>");
				res.end();
			}
			
			
		});
		
	}
	
});

//라우터 객체 등록
app.use("/",router);

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
	connectDB(); 

});






























