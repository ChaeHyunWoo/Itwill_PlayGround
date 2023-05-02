/*
prototype 객체 만들기
 */

function Person(name,age) {
	this.name = name;
	this.age = age;
}

Person.prototype.walk = function(speed) {
	
	if(speed>30) {
		console.log(speed + "km 속도로 뛰는중~");
		return
	}
	
	console.log(speed + "km 속도로 걷는중~");
	
}

var person1 = new Person("수지",27);
var person2 = new Person("인나",40);

console.log(person1.name + "가 걸어가고있다.");
person1.walk(10);

console.log(person2.name + "가 뛰어가고있다.");
person2.walk(50);

