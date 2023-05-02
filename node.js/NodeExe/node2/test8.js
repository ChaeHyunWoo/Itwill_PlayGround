
//폴더 생성, 삭제

var fs = require("fs");

fs.mkdir("./doc",function(err) {
	
	if(err) throw err;
	
	console.log("doc폴더 생성..");
	
});

//폴더 삭제
fs.rmdir("./doc",function(err) {
	
	if(err) throw err;
	
	console.log("doc폴더 삭제..");
});
