
/*
GeoSpatial Schema Definition
 
Geometry
	'type': {type: String, enum: ["Point", "MultiPoint", "LineString",
	"MultiLineString", "Polygon", "MultiPolygon"] },
	coordinates: []
  
Point
	'type': {type: String, 'default': "Point"},
	coordinates: [{type: "Number"}]
  
MultiPoint
	'type': {type: String, default: "MultiPoint"},
	coordinates: [{type: "Array"}]
  
MultiLineString
	'type': {type: String, default: "MultiLineString"},
	coordinates: [{type: "Array"}]
 
Polygon
	'type': {type: String, default: "Polygon"},
	coordinates: [{type: "Array"}]
 
MultiPolygon
	'type': {type: String, default: "MultiPolygon"},
	coordinates: [{type: "Array"}]
  
GeometryCollection
	'type': {type: String, default: "GeometryCollection"},
	geometries: [Geometry]
  
Feature
	id: {type: "String"},
	'type': {type: String, default: "Feature"},
	geometry: Geometry,
	properties: {type: "Object"}
  
FeatureCollection
	'type': {type: String, default: "FeatureCollection"},
	features: [Feature] 

 */

var Schema = {}; //객체 생성

Schema.createSchema = function(mongoose) {
	
	//스키마 정의
	var CoffeeShopSchema = mongoose.Schema({
		
		name:{type:String,index:"hashed"},
		addr:{type:String},
		tel:{type:String},
		geometry:{
			type:{type:String,"default":"point"},//위치정보유형
			coordinates:[{type:"Number"}]//위도,경도를 저장
		},
		created:{type:Date,"default":Date.now}
		
	});
	
	//geometry에 인덱싱(공간 인덱싱)을 만들면 속도가 빨라짐
	//위치좌표는 2d sphere타입
	CoffeeShopSchema.index({geometry:"2dsphere"});
	
	//스키마에 함수 추가(static)형식
	//함수(메서드) 종류 : findAll, findNear, findWithin, findCircle
	
	
	//모든 스타벅스 조회
	CoffeeShopSchema.static("findAll",function(callback){
		
		console.log("findAll 호출됨");
		
		return this.find({},callback); //콜백함수 호출
	});
	
	//가장 가까운 스타벅스 조회
	// - 가까운 정보를 위도(longitude)와 경도(latitude)로 찾기에 매개변수 추가 / maxDistance : 기준점으로부터 최대거리
	// - limit() : 조회한 결과 갯수 제한/ ex : (괄호)에1을 쓰면 1개를 보여줌
	CoffeeShopSchema.static("findNear",function(longitude,latitude,maxDistance,callback) {
		
		console.log("findNear 호출됨");
		
		//find().where(속성이름).near(조회조건)
		this.find().where("geometry")
		.near({center:{type:"Point", //point방식으로 
			coordinates:[parseFloat(longitude),parseFloat(latitude)]},//위도와 경도를 기준으로 찾고
			maxDistance:maxDistance }).limit(1).exec(callback); //1개를 찾은 후 callback함수 실행		
	});
	
	//일정 범위내 스타벅스 조회
	CoffeeShopSchema.static("findWithin",function(topleft_longitude,topleft_latitude,bottomright_longtitude,
			bottomright_latitude,callback) {
		
		console.log("findWithin 호출됨");
		
		this.find().where("geometry")
		.within({box:[[parseFloat(topleft_longitude),parseFloat(topleft_latitude)],
		              [parseFloat(bottomright_longtitude),parseFloat(bottomright_latitude)]]}).exec(callback);
	});
	
	
	//반경 내의 스타벅스 조회
	CoffeeShopSchema.static("findCircle",
			function(center_longitude,center_latitude,radius,callback) {
		
		// change radian :  1/6371 = lkm
		this.find().where("geometry")
		.within({center:[parseFloat(center_longitude),parseFloat(center_latitude)],
			radius:parseFloat(radius/6371000),
			unique:true,spherical:true}).exec(callback);
	});
	
	
	console.log("CoffeShopSchema 정의함");
	
	return CoffeeShopSchema;
	
}


module.exports = Schema;




