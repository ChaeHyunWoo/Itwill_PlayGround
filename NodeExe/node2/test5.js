
//파일에 데이터 쓰기

var fs = require("fs");

fs.writeFile("./output.txt", "오늘은 금요일~~",function(err){

	if(err) {
		console.log("에러발생: " + err);
	}
	
	console.log("쓰기 완료!!");
});// sync면 동기방식

console.log("aaa");