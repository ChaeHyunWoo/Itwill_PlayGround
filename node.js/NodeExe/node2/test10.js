
var logger = require("./logger");
var fs = require('fs');

var inName = "./output.txt";
var outName = "./output4.txt";

fs.exists(outName,function(fileName){ //파일이있으면 
	
	if(fileName){
		
		fs.unlink(outName,function(err){
			
			if(err) throw err;
			
			logger.info(outName + "삭제됌~~");
		}); //파일이있으면 그파일을 삭제하고 에러를 콘솔에 표시
		
		return;
		
	}
	//파일이 없으면
	var inFile = fs.createReadStream(inName,{flags: "r"});
	var outFile = fs.createWriteStream(outName,{flags: "w"});
	
	inFile.pipe(outFile);

	logger.info("파일복사 완료 '- ' ~ ");
	
});