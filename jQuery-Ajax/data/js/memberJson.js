
// 자바스크립트로 패키지를 만들수 있다.

var com = new Object(); // com이라는 이름으로 객체 하나 생성

com.util = new Object(); // com.util이 생기면서 객체 하나 생성


// 패키지만듬 
com.util.Member = function(id,name,addr) {
	this.id = id;
	this.name = name;
	this.addr = addr;
};

// 메소드를  json형식으로 
com.util.Member.prototype = { // json의 중괄호 newsTitleJson
		
		// Key     Value
		setValue: function(id,name,addr) {
			this.id = id;
			this.name = name;
			this.addr = addr;
		},
		
		// 하나의 데이터를 가져오는 setter 
		setId:function(id) {
			this.id = id;
		},
		// 전체데이터 가져오는 getter
		getValue:function() {
			
			return this.id + ":" + this.name + ":" + this.addr;
		},
		
		getId:function() {
			return this.id;
		},
		
		// 메소드로 만드는 getter
		toString:function() {
			return this.id + ":" + this.name + ":" + this.addr
		}
};
