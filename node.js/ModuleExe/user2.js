


// exports에는 속성만 추가할 수 있고, 객체는 할당할 수 없다.
exports = {
		getUser:function() {
			return {id:"suzi",name:"배수지"};
		},
		// group:{id:"inna",name:"유인나"}; 객체는 할당 불가-> 사용 못함(에러)
}
