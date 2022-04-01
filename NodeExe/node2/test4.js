
//FS사용하기

var fs = require("fs");

//파일을 동기식으로 읽음
//var data = fs.readFileSync("../data.json","UTF-8"); //UTF-8 소문자로써도되고, -를 빼도 된다.

//파일을 비동기식으로 읽음
fs.readFile("../data.json", "UTF-8", function(err, data) {
	console.log(data);
});

//console.log(data);

console.log("동기방식으로 읽음..");