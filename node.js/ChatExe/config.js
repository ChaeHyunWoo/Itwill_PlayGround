
module.exports = { 
		
		serverPort:3000,
		dbUrl:"mongodb://localhost:27017/shopping",
		
		dbSchemas:[
		           {file:"./userSchema",collection:"user4",
		        	   schemaName:"UserSchema",modelName:"UserModel"}
		           
		],
		
		//라우터의 정보
		routeInfo:[
		
		          
		           
		]

		           
}