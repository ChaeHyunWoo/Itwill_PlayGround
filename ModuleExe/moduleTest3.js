

// 이런 에러
var user = require("./user3");

function showId() {
	return user.getUser().id + ", " + user.group.id;
}

function showName() {
	return user.getUser().name + ", " + user.group.name;
}

console.log("아이디: " + showId());
console.log("이름: " + showName());
