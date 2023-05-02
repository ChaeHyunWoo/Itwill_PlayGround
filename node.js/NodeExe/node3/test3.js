

//node3부터는 web으로 넘어간다

//http 모듈로 Web-Server 만들기

var http = require("http");
var fs = require("fs"); //파일 읽어오기

//웹 서버 객체를 생성
var server = http.createServer();

var host = "localhost";
var port = 3000;

server.listen(port,host,5000,function(){
	
	console.log("웹서버가 시작되었습니다 : " + port);
	
});

//클라이언트 연결 이벤트 처리 : socket부분은 사용자 정의
server.on("connection",function(socket){//on이 나오면 이벤트_호출하지않아도 내장이벤트 실행
	
	console.log("클라이언트가 접속했습니다:" + socket.remoteAddress + ":" + socket.remotePort);
	
});

//클라이언트 요청 이벤트 처리
server.on("request",function(req,res) {
	
	console.log("클라이언트의 요청이 들어왔습니다");
	
	var fileName = "./image/angelina.png";
	
	//비동기방식으로 파일을 읽는다.
	fs.readFile(fileName,function(err,img) { //다 읽었으면 콜백함수 실행
		
		res.writeHead(200,{"Content-Type":"image/png;"});
		res.write(img);
		res.end();
		
	});
	
});

//서버 종료 이벤트 처리
server.on("close",function(){
	
	console.log("서버가 종료됩니다.");
	
});




