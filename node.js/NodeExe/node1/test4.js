/**
노드의 자료형
Boolean,String,Undefined,null,Object
Undefined : 값을 할당하지 않은 변수(단순히 값이 없음)
null : 존재하지 않는 값(의도적으로 값이 없음)
 */

//javascript의 객체 타입

var Person = {};

Person["name"] = "배수지";
Person["age"] = 27;
Person.mobile = '010-123-1234';

console.log("이름:" + Person.name);
console.log("나이:" + Person.age);
console.log("전화:" + Person.mobile);

console.log("이름:" + Person["name"]);
console.log("나이:" + Person["age"]);
console.log("전화:" + Person["mobile"]);

//기본 함수
function add1(a,b) {
	return a + b;
}

var result = add1(10,20);
console.log(result); //30

//익명 함수
var addr2 = function(a,b) {
	return a + b;
}

var result2 = addr2(20,30);
console.log(result2); //50

//객체의 속성으로 변수 생성
var Person1 = {};

Person1["name"] = "아이유";
Person1["age"] = 25;
Person1.mobile = '010-234-5678';
Person1.add3 = function(a,b) {
	return a + b;
}

console.log(Person1.add3(30,40));

//변수에 함수 할당 후 객체의 속성으로 추가
var add4 = function(a,b) {
	return a + b;
}

Person1.add4 = add4; // = Person1["add4"] = add4;
console.log(Person1.add4(40,50)); // 90

//객체를 만들면서 동시에 속성을 초기화
var Person2 = {
	name:"유인나",
	age:"40",
	add5:function(a,b){
		return a + b;
	}
}

console.log(Person2.add5(50, 60)); //110
console.log(Person2.name); // 유인나

