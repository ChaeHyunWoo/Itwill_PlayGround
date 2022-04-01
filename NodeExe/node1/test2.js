/*
모듈 분리 방법(exports) 2가지

// 1. 객체를 사용(module.export로 분리)
var calc = {}; //객체 생성_js는 대소문자 신경안씀

calc.add = function(a,b) { //js는 객체에 함수를 넣을 수 있다.
	return a + b;

}

calc.mul = function(a,b) {
	return a * b;
}

//외부에서 쓰는 방법
modulc.exports = calc;
---------------------------------------
2. 속성을 사용(exports로 분리)

exports.add = function(a,b) {
	return a * b;
}
*/


var calc = {};

calc.add = function(a,b) {
	return a+b;
};

console.log("모듈 분리전:" + calc.add(10,20));


//1. 객체를 사용(module.export로 분리)
var calc1 = require('./calc1'); //import
console.log("모듈 분리후:" + calc1.add(20,30));

//2. 속성을 사용(exports로 분리)
var calc2 = require("./calc2");
console.log("모듈 분리후:" + calc2.mul(20,30));


