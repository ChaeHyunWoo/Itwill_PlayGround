
/*
전역객체 메서드

console 객체 (메서드 : dir, time, timeEnd)
process 객체 (메서드 : argv, env, exit)
exports 객체
 */

var result =0;
console.time("계산시간");

for(var i=1; i<=100; i++) {
	result += i;
}

console.timeEnd("계산시간");

console.log("1부터 100까지의 합 : %d", result);

console.log("현재 실행할 파일 이름 : " + __filename);
console.log("현재 실행할 파일 경로 : " + __dirname);


var Person = {name:"김세정",age:27};
console.dir(Person); //객체의 속성을 출력해줌.

										//process 객체 (메소드: argv,env,exit)
console.log("argv속성의 파라미터 갯수: " + process.argv.length);
console.dir(process.argv);

		//forEach 반복문.
process.argv.forEach(function(item,index){
	console.log(index + ":" + item);
});



