var xmlHttp;

function createXMLHttpRequest(){
	
	var xmlReq = false;
	
	if(window.XMLHttpRequest){//Non-Microsoft browser
		
		xmlReq = new XMLHttpRequest; //객체생성방법
		
	}else if(window.ActiveXObject){//Microsoft browser
		
		try {//버전 5.0이후
			xmlReq = new ActiveXObject("Msxml2.XMLHTTP");			
		} catch (e) {//버전 5.0이전
			xmlReq = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
	}
	
	return xmlReq;
	
}