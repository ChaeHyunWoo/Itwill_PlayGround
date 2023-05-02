
module.exports = { 
		
		serverPort:3000,
		dbUrl:"mongodb://localhost:27017/shopping",
		
		dbSchemas:[
		           {file:"./userSchema",collection:"user4",
		        	   schemaName:"UserSchema",modelName:"UserModel"},
		        	   
		           {file:"./coffeeshopSchema",collection:"startbucks", //DB이름 : startbucks
		        		   schemaName:"CoffeeShopSchema", modelName:"CoffeeShopModel"} //스키마 이름 : CoffeeShopSchema
		           
		],
		
		//라우터의 정보
		routeInfo:[       
		     {file:"./coffeeShop",path:"/process/addCoffeeShop",method:"add",type:"post"}, //주소창에 path가 올때
		     {file:"./coffeeShop",path:"/process/listCoffeeShop",method:"list",type:"post"},
		     {file:"./coffeeShop",path:"/process/nearCoffeeShop",method:"findNear",type:"post"},
		     {file:"./coffeeShop",path:"/process/withinCoffeeShop",method:"findWithin",type:"post"},
		     {file:"./coffeeShop",path:"/process/circleCoffeeShop",method:"findCircle",type:"post"},
		     {file:"./coffeeShop",path:"/process/nearCoffeeShop2",method:"findNear2",type:"post"},
		]

		           
}