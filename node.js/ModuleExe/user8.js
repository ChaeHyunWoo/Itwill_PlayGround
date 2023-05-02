

/*

 3. 프로토타입 객체를 할당 (모듈 불러온후 new로 객체 생성후 실행)
*/

//2번

function User(id,name) {
	this.id = id;
	this.name = name;
}

User.prototype.group = {id:"suzi",name:"배수지"};

User.prototype.printUser = function() {
	console.log("아이디: " + this.id + ", 이름: " + this.name);
	console.log("아이디: " + this.group.id + ", 이름: " + this.group.name);
}

module.exports = User;