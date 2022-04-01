

//node3부터는 web으로 넘어간다

//http 모듈로 Web-Server 만들기

var http = require("http");

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
	
	res.writeHead(200,{"Content-Type":"text/html;charset=utf-8"});
	res.write("<!DOCTYPE html>");
	res.write("<html>");
	res.write("<head>");
	res.write("<title>응답 페이지</title>");
	res.write("</head>");
	res.write("<body>");
	res.write("<h1>서버에서 응답 받기 - request</h1>");
	res.write("</body>");
	res.write("</html>");
	res.end();  //html의 종료 문장 이후 반드시 써주어야 위에 적은 html을 보낸다
	
});

//서버 종료 이벤트 처리
server.on("close",function(){
	
	console.log("서버가 종료됩니다.");
	
});




