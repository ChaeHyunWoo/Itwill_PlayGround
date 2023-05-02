

// 객체를 생성해주지않고 리턴값을 반환
// XMLHttpRequest 객체생성
function getXMLHttpRequest() {
	
	
	if(window.XMLHttpRequest){ //Non-Microsoft browser : 마이크로 소프트사의 브라우저가 아닌경우
		
		return new XMLHttpRequest; // 이런식으로 객체 생성하는 방법
	} else if(window.ActiveXObject) { // 마이크로 소프트사의 브라우저인 경우
		
		try { 
			return new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			 
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
}

//Ajax 요청
var httpRequest = null;

// method는 get방식?post방식
function sendRequest(url,params,callback,method) {
	
	httpRequest = getXMLHttpRequest(); // return값으로 받아서 객체 생성이 된다.
	
	//method 처리 
	var httpMethod = method ? method : "GET"; // 3항연산자 method받았으면 그거쓰고 없으면 get방식
	
	// 한번더 검증
	if(httpMethod!="GET"&&httpMethod!="POST"){
		httpMethod = "GET";
	}
	
	//넘어가는 data값 처리
	var httpParams = (params==null || params=="") ? null : params; // 없으면 null 있으면 params사용 

	//url 처리
	var httpUrl = url; // _ok 주소 넣어줌
	
	if(httpMethod=="GET" && httpParams!=null) {
		httpUrl = httpUrl + "?" + httpParams; // get방식일때 ? 붙음
	}

	httpRequest.open(httpMethod,httpUrl,true); // get,어디로,비동기
	httpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded"); // post방식일때
	
	httpRequest.onreadystatechange = callback;
	httpRequest.send(httpMethod=="POST" ? httpParams : null); // post방식일때 httpParams , get방식이면 null 
	
}