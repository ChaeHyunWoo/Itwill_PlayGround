/**
이벤트
EventEmitter : 이벤트를 주고 받음
process : 내부적으로 EventEmitter를 상속되어 있음

on : 이벤트가 전달될 객체에 이벤트 리스너 (응답)
emit(): 이벤트를 다른쪽으로 전달하는 메서드(이벤트를 호출) - (요청)

 */

// 1. event 사용하기
// exit는 내장 이벤트 (이름변경x)
// - process가 종료하면 자동으로 exit이벤트 호출

//이벤트다 함수아래 어떠한 일을 실행시켜야하기 때문
process.on("exit",function() {
	console.log("exit 이벤트 발생...");
});

setTimeout(function() {
	
	console.log("3초 후에 시스템 종료")
	//process는 내부적으로 EventEmitter를 상속되어 있음
	process.exit(); //exit 호출 / exit는 내장 객체라서 이 부분을 주석처리해도 
					// 자동으로 호출한다.
},3000);

//사용자가 만든 함수
process.on("tick", function(count) {
	console.log("tick 이벤트 발생 : " + count);
});

setTimeout(function() {
	console.log("2초 후에 tick이벤트 전달 시도");
	process.emit("tick","5"); //tick 호출 /내가만든 메서드를 호출하기전까지 실행안됌
},2000);

