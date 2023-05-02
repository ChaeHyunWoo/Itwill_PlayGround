
// 로그 만들기

 /* * 외부 모듈 설치하기(npm)
**********************************************************
package.json 파일생성
npm init 실행 (기본 외부모듈 설치-기본값 엔터)

npm install 모듈이름 : 설치
npm uninstall 모듈이름 : 삭제
npm install -g npm : 모든 모듈 업데이트

npm install 모듈이름 --save : package.json 파일에 저장 => 이렇게하면 설치한 프로젝트에만 인식
npm install 모듈이름 --g(--global) : 전역 환경에 파일 저장 => 이렇게하면 모든 프로젝트에 인식된다. 이렇게 설치하면 경로는 하단
C:\Users\itwill\AppData\Roaming\npm\node_modules

npm install : package.json 파일에 기록된 모든패키지 설치

npm list : 설치된 패키지 정보
npm list -g : 전역환경에 설치된 정보
*************************************** */

//Error: Cannot find module 'winston'
//winston는 외부 모듈이라 위의 에러가 뜬다. 따로 설치를 해야 함

var winston = require("winston");//로그 처리 모듈
var winstonDaily = require("winston-daily-rotate-file");//로그 일별처리 모듈

var logger = winston.createLogger({
	
	//debug: 0-> info:1->notis:2->warning:3 -> error:4 -> crit:5->alert:6->emerg:7
	
	level:"debug",
	format: winston.format.simple(),
	transports: [
	             new (winston.transports.Console)({
	            	 colorize: true}), 
	             new (winstonDaily)({
	            	 filename: './log/server_%DATE%.log',
	            	 maxSize:"10m",
	            	 datePattern: 'YYYY-MM-DD HH-mm-ss'
	             })
	            ]
});



				var fs = require("fs");
				
				var inName = "./output.txt";
				var outName = "./output4.txt";
				
				fs.exists(outName,function(fileName){
					
					if(fileName){
						fs.unlink(outName,function(err){
							
							if(err) throw err;
							
							logger.info(outName + "삭제할거야")
						})
						return;
					}
					var inFile = fs.createReadStream(inName,{flags:"r"});
					var outFile = fs.createWriteStream(outName,{flags: "w"});
					
					inFile.pipe(outFile);
					
					logger.info("파일 복사했다.");
				});

