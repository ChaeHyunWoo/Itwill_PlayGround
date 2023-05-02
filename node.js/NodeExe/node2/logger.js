

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


//외부에서 쓰기위해
module.exports = logger;



