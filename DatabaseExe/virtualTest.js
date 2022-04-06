
var mongoose = require("mongoose");

var database;
var UserSchema;
var UserModel;

function connectDB() {
	
	var databaseUrl = "mongodb://localhost:27017/shopping";
	
	//연결
	mongoose.connect(databaseUrl);  //몽고 디비의 정보를 몽구스와 연결 
	
	database = mongoose.connection;
	
	database.on("open",function(){   
		
		console.log("데이터베이스가 연결되었습니다. "+databaseUrl);
		
		createUserSchema();
		
		insertData();
		
	});
	
	database.on("error",function(){   
		
		console.log("데이터베이스 연결 에러.");
		
	});
	
	database.on("disconnected",function(){   
		
		console.log("데이터베이스 연결 종료");
		
	}); 
	
}

connectDB();


function createUserSchema(){
	
	//스키마
	UserSchema = mongoose.Schema({
		
		id:{type:String,required:true,unique:true},
		name:{type:String},
//		age:{type:Number,'default':20},
//		created:{type:Date,'default':Date.now}
		
	});
	
	//virtual 함수 : 암호화 함수 
	UserSchema
		.virtual("info")  //가상 속성 이름
		.set(function (info) {
		
			//{"info":suzi,배수지} 콤마로 구분하여 나누기
			
			var array = info.split(",");
			
			this.id = array[0];
			this.name = array[1];
			  	  
			})
		.get(function() {
		
			return this.id + " " + this.name;
			
		})
		
		console.log("UserSchema 정의함");
			
	
	//모델 정의
	UserModel = mongoose.model("users3",UserSchema); 

	console.log("UserModel 정의함.");
	
}

function insertData() {
	
	//Model : find,save,update,remove
	
	var user = new UserModel({"info":"inna,유인나"});
	
	user.save(function(err){
		
		if(err) {throw err;}
		
		console.log("사용자 데이터 추가됨");
		
		findAll();
		
	});
	
}

function findAll() {
	
	UserModel.find({},function(err,result){ // 조건이 없는 경우 {}
		
		if(err) {throw err;}
		
		if(result){
			
			for(i=0;i<result.length;i++){
				
				console.log("id:%s, name:%s", result[i]._doc.id,result[i]._doc.name);
			}
			
		}
		
	})  
	
	
	
}










