// 파일 업로드 사용
// npm install multer --save



//Express 기본 모듈
require("dotenv").config();
var express = require("express");
var http = require("http");
var path = require("path");
var serveStatic = require("serve-static"); //특정 폴더를 패스로 접근 가능하게 하는것.
var expressErrorHandler = require("express-error-handler");
var cookieParser = require("cookie-parser");
var expressSession = require("express-session");

//파일 업로드 모듈
var multer = require("multer");



//익스프레스 객체 생성
var app = express();

//기본 포트를 app 객체의 속성으로 설정
//express 서버 객체의 메소드(set.get.use)
app.set("port",process.env.PORT)

app.use(express.urlencoded({extended:false}));

app.use("/public",serveStatic(path.join(__dirname,"public"))); //public (실제)폴더의 이름을 써준것
app.use("/upload",serveStatic(path.join(__dirname,"uploads"))); //use앞은 가상주소(upload) / 뒤에는 실제 주소 (uploads)

app.use(cookieParser());

//storage의 저장 기준 설정
var storage = multer.diskStorage({
	
	destination:function(req,file,callback) {
		
		callback(null,"uploads");
	},
	filename:function(req,file,callback) {
		
		var extension = path.extname(file.originalname);
		var basename = path.basename(file.originalname, extension);
		
		callback(null, basename + extension); // 파일이름이 abc.txt로 들어간다.
		// callback(null,file.originalname); 위와 동일하다
		// callback(null, basename + Date.now() + extension); // 파일이름 + 현재 날짜를 붙임
		//callback(null,Date.now().toString() + path.extname(file.originalname)); //현재 날짜만 붙임.
		
	}
	
});

// 위에서 만든 storage를 기준으로 upload
var upload = multer({
	
	storage:storage,
	limits:{
		files:10,
		fileSize:1024*1024*1024
	}
	
});


//라우터 객체 추가 
var router = express.Router();


// 라우팅 함수 등록
router.route("/process/file").post(upload.array("upload",2), function(req,res){ 
	
	console.log("/process/file 호출.."); 
	
	try {
		
		var files = req.files; // 파일 정보를 배열로 받음
		
		//console.log(req.files[0]); //req로 넘어온 files의 0번째 출력
		//console.log(req.files[1]);
		
		//파일 정보를 저장할 변수
		var originalName = "";
		var fileName = "";
		var mimeType = "";
		var size = 0;
		
		res.writeHead("200",{"Content-type":"text/html;charset=utf-8"});
		res.write("<h1>파일 업로드 성공</h1>");
		
		if(Array.isArray(files)) {
			
			console.log("파일 갯수 : " + files.length + "개");
			
			for(var i=0; i<files.length; i++) {
				
				originalName = files[i].originalname;
				fileName = files[i].filename;
				mimeType = files[i].mimetype;
				size = files[i].size;
				
				res.write("<hr/>");
				res.write("<div>원본파일명 : " + originalName + "</div>");
				res.write("<div>저장파일명 : " + fileName + "</div>");
				res.write("<div>MimeType : " + mimeType + "</div>");
				res.write("<div>파일크기 : " + size + "</div>");
				
			}
			
		}
		
		res.end();
		
		
	} catch (e) {
		console.dir(err.stack); // 에러가 있으면 뿌려라  == e.stack
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






























