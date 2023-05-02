/**
// 1. 객체를 사용(module.export로 분리)
 */

var calc = {};

calc.add = function(a,b) {
	return a + b;
};

module.exports = calc;
