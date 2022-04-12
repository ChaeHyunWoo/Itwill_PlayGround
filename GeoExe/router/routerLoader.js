

var config = require("../config");

var routerLoader = {};

routerLoader.init = function(app,router) {
	
	console.log("routerLoader 호출됨..");
	
	return initRouters(app,router);
}

function initRouters(app,router) {
	
	var infoLen = config.routeInfo.length; //3
	
	for(var i=0; i<infoLen; i++) {
		
		var curItem = config.routeInfo[i];
		
		var curModule = require(curItem.file); //user.js 읽어옴
		
		//라우팅
		if(curItem.type=="get") {
			//router.route("/process/login").get(user.login);
			router.route(curItem.path).get(curModule[curItem.method]);
			
		}else if(curItem.type=='post') {
			router.route(curItem.path).post(curModule[curItem.method]);
		}else {
			router.route(curItem.path).post(curModule[curItem.method]);
		}
		
	}
	
	console.log("라우팅 모듈 설정");
	
	
	//라우터 객체 등록
	app.use("/",router);
	
}


//외부에서 쓰기 위해 등록
module.exports = routerLoader;





