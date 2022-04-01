
//내장 모듈 사용하기

//os
var os = require("os");

console.log(os.hostname()); //내 컴퓨터 이름
console.log(os.totalmem()); //메모리 정보
console.log(os.cpus()); //cpu 정보
console.log(os.networkInterfaces());
console.log("------------------------------");

//path
var path = require("path");

var dir = ["users","itwill","docs"];
var docDir = dir.join(path.sep);
console.log(docDir); // 출력 : users\itwill\docs

var curPath = path.join("/users/itwill","notepad.exe");
console.log(curPath);// \users\itwill\notepad.exe

var filePath = "c:\\users\\itwill\\notepad.exe";
var dirName = path.dirname(filePath);
var fileName = path.basename(filePath);
var extName = path.extname(filePath);

console.log(dirName); // c:\users\itwill
console.log(fileName);// notepad.exe
console.log(extName); // .exe


