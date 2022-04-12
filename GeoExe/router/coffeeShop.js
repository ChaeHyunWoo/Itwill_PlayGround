
//1.스타벅스 정보를 저장하는 함수		--밑에서 함수호출할것
var add = function(req,res){
	
	console.log("add함수 호출..");
	
	var name = req.body.name;
	var addr = req.body.addr;
	var tel = req.body.tel;
	var longitude = req.body.longitude; //경도
	var latitude = req.body.latitude; //위도
	
	var database = req.app.get("database");	
	
	if(database){
						//사용자에게 받은 데이터 들어옴 --save를 하고 난뒤!
		addCoffeeShop(database, name, addr, tel, longitude, latitude, function(err,result){ //coffeeshop으로 보내고 result로 받아도 상관x.안에내용이 들어오는거라
			
			if(err){
				res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>스타벅스 추가중 에러발생ㅠㅠ</h2>");
				res.end();
				
				return;
			}
			
			if(result){
				res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>스타벅스 추가 성공♡</h2>");
				res.end();
				
			}else{
				res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>스타벅스 추가 실패ㅜ</h2>");
				res.end();
			}			
		}); 
		
	}else{
		res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
		res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
		res.write("<h2>데이터베이스 연결 실패</h2>");
		res.end();		
	}
};

//2.스타벅스 정보를 조회하는 함수
var list = function(req,res){
	
	console.log("list함수 호출..");
	
	var database = req.app.get("database");
	
	if(database){
		
		database.CoffeeShopModel.findAll(function(err,result){
			
			if(err){
				res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>스타벅스 리스트 조회중 에러 발생ㅠㅠ</h2>");
				res.end();
				
				return;
			}
			
			if(result){
				res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>스타벅스 리스트 (o゜▽゜)o☆</h2>");
				res.write("<div><ul>");
				
				for(var i=0;i<result.length;i++){ //json방식으로 읽어온것
					
					var curName = result[i]._doc.name;
					var curAddr = result[i]._doc.addr;
					var curTel = result[i]._doc.tel;
					var curLongitude = result[i]._doc.geometry.coordinates[0]; //경도
					var curLatitude = result[i]._doc.geometry.coordinates[1]; //위도
					
					res.write("<li>#" + (i+1) + " : " + 
							curName + ", " +
							curAddr + ", " + 
							curTel + ", " +
							curLongitude + ", " +
							curLatitude + "</li>");					
				}
				
				res.write("</ul></div>");
				res.end();				
			}else{
				
				res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>스타벅스 리스트 조회 실패</h2>");
				res.end();								
			}
		});
		
	}else{
		
		res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
		res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
		res.write("<h2>데이터베이스 연결 실패</h2>");
		res.end();
	}	
};

//추가함수
var addCoffeeShop = function(database,name,addr,tel,longitude,latitude,callback){
	
	console.log("addCoffeeShop 호출..");
	
	//CoffeeShopModel 객체 생성
	var coffeeShop = new database.CoffeeShopModel( //매개변수로 들어온 애들
			{name:name,addr:addr,tel:tel,
				geometry:{
					type:"Point",
					coordinates:[longitude,latitude]
				}//값2개니
			} 
	);
	
	//save() 저장
	coffeeShop.save(function(err){
		
		if(err){
			callback(err,null);
			return;
		}
		
		console.log("스타벅스 데이터 추가 (╹ڡ╹ )")
		
		callback(null,coffeeShop);		
	});	
}


var findNear = function(req,res) {
	
	console.log("findNear 함수 호출됨");
	
	var maxDistance = 100; //10이라 쓰면 100m를 뜻함 / 100 : 1km
	
	var longitude = req.body.longitude;
	var latitude = req.body.latitude;
	
	var database = req.app.get("database");
	
	if(database) {
		
		database.CoffeeShopModel.findNear(longitude,latitude,maxDistance,function(err,result) {
			
			if(result){
				
				res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>스타벅스 리스트 (o゜▽゜)o☆</h2>");
				res.write("<div><ul>");
				
				for(var i=0;i<result.length;i++){ //jason방식으로 읽어온것
					
					var curName = result[i]._doc.name;
					var curAddr = result[i]._doc.addr;
					var curTel = result[i]._doc.tel;
					var curLongitude = result[i]._doc.geometry.coordinates[0]; //경도
					var curLatitude = result[i]._doc.geometry.coordinates[1]; //위도
					
					res.write("<li>#" + (i+1) + " : " + 
							curName + ", " +
							curAddr + ", " + 
							curTel + ", " +
							curLongitude + ", " +
							curLatitude + "</li>");					
				}
				
				res.write("</ul></div>");
				res.end();	
				
			}else{
				
				res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>스타벅스 리스트 조회 실패</h2>");
				res.end();								
			}
			
		});
		
	}else{
		
		res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
		res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
		res.write("<h2>데이터베이스 연결 실패</h2>");
		res.end();
		
	}
	
};


var findNear2 = function(req,res) {
	
	console.log("findNear2 함수 호출됨");
	
	var maxDistance = 100; //10이라 쓰면 100m를 뜻함 / 100 : 1km
	
	var longitude = req.body.longitude;
	var latitude = req.body.latitude;
	
	var database = req.app.get("database");
	
	if(database) {
		
		database.CoffeeShopModel.findNear(longitude,latitude,maxDistance,function(err,result) {
			
			if(result){ //데이터가 있으면
								
				if(result.length>0) {
					
					res.render("findNear.ejs",{result:result[0]._doc,
						longitude:longitude,latitude:latitude});
					
				}else {
					
					res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
					res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
					res.write("<h2>스타벅스 리스트 조회 실패</h2>");
					res.end();	
					
				}
				
				
			}else{
				
				res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>스타벅스 리스트 조회 실패</h2>");
				res.end();								
			}
			
		});
		
	}else{
		
		res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
		res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
		res.write("<h2>데이터베이스 연결 실패</h2>");
		res.end();
		
	}
	
};


var findWithin = function(req,res) {
	
	console.log("findWithin 함수 호출됨");
		
	var topLeftlongitude = req.body.topleft_longitude;
	var topLeftlatitude = req.body.topleft_latitude;
	
	var bottomRightlongitude = req.body.bottomright_longitude;
	var bottomRightlatitude = req.body.bottomright_latitude;
	
	
	var database = req.app.get("database");
	
	if(database) {
		
		database.CoffeeShopModel.findWithin(topLeftlongitude,topLeftlatitude,bottomRightlongitude,
				bottomRightlatitude,function(err,result) {
			
			if(result){
				
				res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>스타벅스 리스트 (o゜▽゜)o☆</h2>");
				res.write("<div><ul>");
				
				for(var i=0;i<result.length;i++){ //jason방식으로 읽어온것
					
					var curName = result[i]._doc.name;
					var curAddr = result[i]._doc.addr;
					var curTel = result[i]._doc.tel;
					var curLongitude = result[i]._doc.geometry.coordinates[0]; //경도
					var curLatitude = result[i]._doc.geometry.coordinates[1]; //위도
					
					res.write("<li>#" + (i+1) + " : " + 
							curName + ", " +
							curAddr + ", " + 
							curTel + ", " +
							curLongitude + ", " +
							curLatitude + "</li>");					
				}
				
				res.write("</ul></div>");
				res.end();	
				
			}else{
				
				res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>스타벅스 리스트 조회 실패</h2>");
				res.end();								
			}
			
		});
		
	}else{
		
		res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
		res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
		res.write("<h2>데이터베이스 연결 실패</h2>");
		res.end();
		
	}
	
};

var findCircle = function(req,res) {
	
	console.log("findCircle 함수 호출됨");
	
	var centerlongitude = req.body.center_longitude;
	var centerlatitude = req.body.center_latitude;
	var radius = req.body.radius;
	
	var database = req.app.get("database");
	
	if(database) {
		
		database.CoffeeShopModel.findCircle(centerlongitude,centerlatitude,radius,function(err,result) {
			
			if(result){
				
				res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>스타벅스 리스트 (o゜▽゜)o☆</h2>");
				res.write("<div><ul>");
				
				for(var i=0;i<result.length;i++){ //jason방식으로 읽어온것
					
					var curName = result[i]._doc.name;
					var curAddr = result[i]._doc.addr;
					var curTel = result[i]._doc.tel;
					var curLongitude = result[i]._doc.geometry.coordinates[0]; //경도
					var curLatitude = result[i]._doc.geometry.coordinates[1]; //위도
					
					res.write("<li>#" + (i+1) + " : " + 
							curName + ", " +
							curAddr + ", " + 
							curTel + ", " +
							curLongitude + ", " +
							curLatitude + "</li>");					
				}
				
				res.write("</ul></div>");
				res.end();	
				
			}else{
				
				res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
				res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
				res.write("<h2>스타벅스 리스트 조회 실패</h2>");
				res.end();								
			}
			
		});
		
	}else{
		
		res.writeHead("200",{"Content-Type":"text/html;charset=utf-8"});
		res.write("<meta name='viewport' content='width=device-width,height=device-height,initial-scale=1'>");
		res.write("<h2>데이터베이스 연결 실패</h2>");
		res.end();
		
	}
	
};


module.exports.add = add;
module.exports.list = list;
module.exports.findNear = findNear;
module.exports.findNear2 = findNear2;
module.exports.findWithin = findWithin;
module.exports.findCircle = findCircle;


