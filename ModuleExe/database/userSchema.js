var crypto = require("crypto");

//app1.js에 있는 스키를 따로 분리해서 userSchema.js 파일로 만들었다.
//- 여기엔 스키마 분리

// 자바에서 따지면 Schema 라는 객체 
var Schema = {};

Schema.createSchema = function(mongoose){
	
	UserSchema = mongoose.Schema({
		id:{type:String,required:true,unique:true}, // 아이디에 들어가는 값은 문자고 required 반드시 필요하고 , 유의값 - > 프라이머리키가 됨
		hashed_password:{type:String,required:true}, // 암호화된 패스워드 이다. 그러므로 hashed_pwd로 바꿈
		// 암호화 + salt , salt키를 저장해야함 안하면 High문자를 저장하면 a123를 넣으면 high라는애를 가지고 와서 붙여서 암호화를 해야하는데 암호화된게 hashed_pwd로 들어가는데
		salt:{type:String,required:true},// 다음에도 123를 붙이는데 앞에 salt키가 있어야되므로 항상 보관되어 있어야 한다. 암호화시킬때 임의로 붙이는 키값이다 . 반드시 필요하므로 required : true
		name:{type:String},
		age:{type:Number,'default':20},
		created:{type:Date,index:{unique:false},'default':Date.now} // unique:false 똑같은값이 들어가도 상관없다 , 날짜를 안넣으면 오늘날짜
	
	});	
	UserSchema
		.virtual("pwd") // 암호는 뭘로 만들건가 password로 만듬 , password값으로 넣겠다
		.set(function(pwd){
			
			this._password = pwd; // 패스워드를 넣을것이다. _password 변수이다. 바꾸면 안됨
			this.salt = this.makeSalt(); // 아래에서 만든 salt키값을 _salt에 넣을것이다.
			
			this.hashed_password = this.encryptPassword(pwd); // 암호화를 시키는 메소드이다 밑에 만들것임
			
	})
	
	.get(function(){
		
		return this._password; // 패스워드 반환값 이 값을 hashed_password:{type:String,required:true} 에 넣는다
	})
	
	
	// 스키마 객체에 메소드를 추가 : method() 방법
	UserSchema.method("makeSalt",function(){ // 메소드를 만들면서 makeSalt를 호출함
		
	//	return "hi"; // hi붙이고싶다 hi라는 문자가 this.makeSalt()에서 호출되는데 salt에 hi가 들어감
					 // db에 salt:{type:String,required:true} 들어감 
					 // hi 123 A , hi 456 B , hi 787 C
					 // 암호화할때 hi만 붙이게되면 패스워드를 암호화하는 방식이 너무 단순
					 // A라는 사람이 로그인할때 hi라고 하지않고 abc123
					 // B라는 사람이 접속하면 123456
					 // c라는 사람이 접속하면 265189
					 // 그 사람만의 고유 salt를 만드는 것이다.
				    // id pw salt
					// A 123 abc = XXX 암호화된 결과물
					// B 456 129
					// C 789 369
			// 즉 독자적인 salt키를 갖게 된다.
			// pw + salt 를  암호화된 pwd와 비교하게 된다 . 
			// 실제패스워드를 저장하지않고 암호화된 패스워드 저장함
			// 각자의 salt키도 저장해야 한다.
		
		// 지금은 시시각각 변하는 난수값을 넣어서 알아내기 쉽지 않다
		console.log("date : " + new Date().valueOf()); // 초에따라 일련숫자 12341242 나옴
		console.log("math : " + Math.random()); // 0.1234214242 매번바뀜
		return Math.round((new Date().valueOf() * Math.random())) + ""; // 랜덤함수를 그순간에 만들어서 뒤에 + 붙여서 문자가됨 그러면 패스워드랑 붙을수있다. String값이됨
		
	}) 		
	
	// 암호화 작업을 하는 곳
	UserSchema.method("encryptPassword",function(inputPwd,inSalt){ // 암호화를 시키려면 입력되는 패스워드 inputPwd 를 넣음
													// 암호화 하려면 salt가 필요하므로 inSalt
													// 그러면 들어가는 패스워드와 salt 가 합쳐져서 암호화가 된다.
		
		// 이미 암호화가 되어있으면 로그인이 되어있으면 123 입력하면
		// 얘를 암호화 해서 기존에 저장되어있는 암호화된 데이터를 같냐 해서 비교작업을 해줘야 하다.
		
		if(inSalt) { // inSalt가 있으면
			// 암호화 작업
			return crypto.createHmac("sha1",inSalt) // sha1 암호화 용어인데 쉬바라고 읽는다. 1은 암호화하는 등급이다. 암호화하는 모듈로써 모든곳에서 다쓴다
				.update(inputPwd).digest("hex"); // hex 헥사라고 읽음 								
		} else {
			// 안주게 되면  this 자체적으로  salt키를가지고 있으면 그걸써라
			return crypto.createHmac("sha1",this.salt) // sha1 암호화 용어인데 쉬바라고 읽는다. 1은 암호화하는 등급이다. 암호화하는 모듈로써 모든곳에서 다쓴다
			.update(inputPwd).digest("hex");
			
		}
		
	}) 
	
	
	// 123를 암호화해서 암호화된 데이터를 비교해야되는 메소드를 만들어야한다.
	// 로그인할때 암호화된 PWD비교
	UserSchema.method("authenticate",function(inputPwd,inSalt,hashed_password){ // 사용자가 입력할 패스워드가 필요 
		// inputPwd + insalt 가 들어오면 123high 해서 암호화한다.
		// 암호화된 데이터가 db에 저장되어있는 암호화된 데이터를 읽어내야 한다
		// 두개를 비교하는데 inputPwd , insalt 와 db에서 꺼내온 암호화된 패스워드 hashed_password가 필요하다
		
		
		if(inSalt) { // 설트키 가 있으면
			
			console.log("사용자 입력 pwd: " + inputPwd); // abc 
			console.log("암호화된 pwd: " + this.encryptPassword(inputPwd,inSalt)); // 암호화된 패스워드를 보여줄것이다. abc가 xxxxxxx
			console.log("DB에 저장되어 있는 pwd: " + hashed_password);// db에 저장되어있는 암호화된 패스워드  abc가 db에저장된 암호화된 데이터
			
			// a 123 + salt 와 db에서 읽어온것과 일치하면 true 반환
			return this.encryptPassword(inputPwd,inSalt)==hashed_password;  // 암호화된 시킨것과 db에 저장된것과 일치하나? true , false
			
			
			
		} else {  // 설트키 가 없으면 패스워드만 감
				  // 위에서 부르면 function 에 inSalt가 없으면 this.Salt 로 감
			
			console.log("사용자 입력 pwd: " + inputPwd); // abc 
			console.log("암호화된 pwd: " + this.encryptPassword(inputPwd,inSalt)); // 암호화된 패스워드를 보여줄것이다. abc가 xxxxxxx
			console.log("DB에 저장되어 있는 pwd: " + hashed_password);// db에 저장되어있는 암호화된 패스워드  abc가 db에저장된 암호화된 데이터
			
			return this.encryptPassword(inputPwd)==this.hashed_password;
		}

		
	}); 
	
	//스키마 객체에 메소드를 추가(방법: static(), method() )
	
	//로그인에서 사용
	// findById는 메소드의 이름 뒤에 콜백함수 
	
	// static를 써서 메소드 
	UserSchema.static("findById",function(id,callback){ // 아이디를 가지고 select 했을때 들어갔을때 무조건 작업이 끝났을때 결과가 콜백으로 간다.
		return this.find({id:id},callback); // id를 찾아라 찾던안찾던 callback함수 실행해라
	})
	
	
	
	// 전체 데이터 사용
	UserSchema.static("findAll",function(callback){ // findAll 메소드를 
		return this.find({}, callback); // 전체데이터는 조건이 없어서 {} 몽땅가져옴 
	})
	
	console.log("UserSchema 정의함.");
		
		return UserSchema;
	}
	
	
module.exports = Schema; // 외부에서 이 파일을 엑세스 할수있다.	