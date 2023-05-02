
//user2.js는 에러라서 user3.js처럼 만들어줘야함
// exports에는 속성만 추가할 수 있고, 객체는 할당할 수 없다.
var user = {
		getUser:function() {
			return {id:"suzi",name:"배수지"};
		},
		group:{id:"inna",name:"유인나"} 
}

module.exports = user;