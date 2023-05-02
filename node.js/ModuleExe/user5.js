
// module.exports가 사용되면 exports는 무시됨
module.exports = {
		getUser:function() {
			return {id:"suzi",name:"배수지"};
		},
		group:{id:"inna",name:"유인나"} 
}

exports.group = {id:"insun",name:"정인선"}; //여긴 외부에서 가져다 쓸 수 없음