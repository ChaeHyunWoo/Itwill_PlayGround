
//파이프(pipe) 사용하기

var fs = require("fs");

var inName = "./output.txt";
var outName = "./output3.txt";

fs.exists(outName,function(fileName) { //메서드 예외처리할 때는 throws
	
	if(fileName) {
		
		fs.unlink(outName,function(err) {
			
			if(err) throw err; //메서드안에서 예외처리할때는 throw
			
			console.log(outName + "삭제함..");
			
		});
		
		return;
	}
	
	var inFile = fs.createReadStream(inName, {flags: "r"});
	var outFile = fs.createWriteStream(outName, {flags: "w"});
	
	inFile.pipe(outFile);
	
	console.log("파일복사 성공!!");
	
});