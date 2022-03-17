
//자바스크립트 객체

//Member 클래스 / Member클래스에 인스턴스변수 id, name,addr 만듬
// -생성자를 통해 변수 초기화
Member = function(id,name,addr) {
	this.id = id;
	this.name = name;
	this.addr = addr;
};

//메서드(함수) 정의--setter
// - setValue라는 메서드를 통해 변수 초기화
Member.prototype.setValue = function(id,name,addr) {
	this.id = id;
	this.name = name;
	this.addr = addr;
}

//메서드(함수) 정의--getter
//- getValue라는 메서드를 통해 변수 초기화
Member.prototype.getValue = function() {
	return "[" + this.id + "]" + this.name + "(" + this.addr + ")";
}