

var mongoose = require("mongoose");

//database 객체에 db,schema,model을 추가
var database = {};

//app : express객체
//config : config.js

database.init = function(app,config) {
	
	connect(app,config); //connect라는 함수에 받은 app,config와 함께 넘겨준다.
	
}

function connect(app,config) {
	
	console.log("connect 호출됨..");
	
	//연결
	mongoose.connect(config.dbUrl);
	
	database = mongoose.connection;
	
	database.on("open",function(){
		
		console.log("데이터베이스가 연결되었습니다: " + config.dbUrl);

		// config.js에 등록된 스키마 및 모델 객체 생성(읽어온다)
		createSchema(app,config); // 함수로 호출할것임
		
	});
	
	database.on("error",console.error.bind(console,"몽구스 연결 에러..."));
	
	database.on("disconnected",function(){
		
		console.log("DB연결이 끊겼습니다 5초후 재연결 합니다");
		setInterval(connectDB(),5000);
	});
	
}


//config에 정의된 스키마 및 모델 객체 생성
function createSchema(app,config) {
	
	var schemaLen = config.dbSchemas.length;
	
	for(var i=0; i<schemaLen; i++) {
		
		var curItem = config.dbSchemas[i];
		
		//스키마 생성 : 함수를 아예 써버리고 읽어오면 변수가 함수가 된다.
		var curSchema = require(curItem.file).createSchema(mongoose); //이렇게 하면 curSchema가 스키마가 된다.
		
		//모델 생성 : 다 이렇게 변수처리 해버리는거에요
		var curModel = mongoose.model(curItem.collection, curSchema);
		
		//database 객체에 스키마와 모델을 추가한 것
		database[curItem.schemaName] = curSchema; // 이것은 config의 UserSchema이다,
		database[curItem.modelName] = curModel;   // 이것은 config의 modelName
		
	}
	
	app.set("database",database); //따옴표 변수명, 그리고 위에서 만든 2개의 데이터베이스를 넣는다. /여기엔 db+schema+model 3개가 들어가 있는 것이다.
	
}


module.exports = database; //외부에서 쓸수있게 만듬




