
//파일 복사

var fs = require("fs");

//r,w,w+(r+w),a+(r+w 누적)
var inFile = fs.createReadStream("./output.txt",{flags: "r"});
var outFile = fs.createWriteStream("./output2.txt",{flags: "w"}); //a+ 는 누적

//data는 예약어 / 변경x
inFile.on("data",function(str) {//on이 나오면 이벤트
	console.log("output.txt 읽음..");
	outFile.write(str);
});

//다 읽었으면 end가 실행된다. end랑 data는 예약어(내장되어있다) 변경x
inFile.on("end", function() {
	console.log("파일 읽기 종료..");
	outFile.end(function() {
		console.log("output2.txt 쓰기 완료...");
	})
});

