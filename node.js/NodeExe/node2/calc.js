
var Calc = function() {
	
	//test3.js에서 보낸 이벤트를 받는 부분
	this.on("stop",function() {
		console.log("Calc에 stop event 전달됨.");
	});
	
};

//상속을 가능하게하는 모듈
var util = require("util"); //extends

var eventEmitter = require("events").EventEmitter;//events라는 모듈 안에 EventEmitter가 있다.

//public class Calc extends Emitter {}
util.inherits(Calc,eventEmitter);
//Calc가 eventEmitter를 상속받은것/Calc가 eventEmitter를 상속받아야만 위에 함수 안에 on을 실행할 수 있다.

module.exports = Calc; //exports는 내보내기 => 다른곳에서 쓸 수 있게
module.exports.title = "계산기";


