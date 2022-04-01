
//url 모듈
var url = require("url");

//parse : 주소열을 URL 객체로 변환
var curURL = url.parse("https://m.search.naver.com/search.naver?sm=mtp_hty.top&where=m&query=angelina+danilova")

//format : URL 객체를 주소 문자열로 변환
var curStr = url.format(curURL);

console.log(curStr);
console.log("---------------------------------------");
console.log(curURL);

console.log("---------------------------------------");

//요청 파라미터 구분
var queryStr = require("querystring");
var param = queryStr.parse(curURL.query);

console.log(param);
console.log("---------------------------------------");
console.log(param.query);
//stringify : 객체를 문자열로 변환해줌
console.log(queryStr.stringify(param));






