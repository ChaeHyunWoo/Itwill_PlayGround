
//3. 프로토타입 객체를 할당 (모듈 불러온후 new로 객체 생성후 실행)
var User = require("./user8");
var user = new User("insun","정인선");

user.printUser();