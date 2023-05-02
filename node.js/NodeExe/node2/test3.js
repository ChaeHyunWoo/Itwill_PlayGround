
var Calc = require("./calc"); //calc.js를 불러온거고

var calc = new Calc(); // 객체 생성

//emit으로 호출
calc.emit("stop");

console.log(Calc.title);
