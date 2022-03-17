<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	var XMLHttpRequest; //객체를 전역변수로 만듬
	
	function getXMLHttpRequest() {
		
		if(window.ActiveXObject) {//IE
			
			try {//IE5.0이후
				XMLHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {//IE5.0이전
				XMLHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			}
			
		}else {// NON-IE (크롬)
			XMLHttpRequest = new XMLHttpRequest();
		
		}
		
	}
	
	function ajaxRequestGet() {
		
		var data = document.myForm.greeting.value;
		
		if(data==""){
			alert("데이터 입력해라!");
			document.myForm.greeting.focus();
			return;
		}
		
		//Get방식
		XMLHttpRequest.open("GET","ajaxGetPost_ok.jsp?greeting=" + data, true);
		XMLHttpRequest.onreadystatechange = viewMessage; //viewMessage를 콜백함수로 할 것이다.
		XMLHttpRequest.send(null); //get방식일때는 null
	}
	
	
	function ajaxRequestPost() {
		
		var data = document.myForm.greeting.value;
		
		if(data==""){
			alert("데이터 입력해라!");
			document.myForm.greeting.focus();
			return;
		}
		
		//Post방식
		XMLHttpRequest.open("POST","ajaxGetPost_ok.jsp",true);
		
		//post방식은 여기에 이 코딩을 써줘야 한다.
		XMLHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		
		XMLHttpRequest.onreadystatechange = viewMessage;
		XMLHttpRequest.send("greeting=" + data); //get방식은 null이였는데 post방식은 여기에 쓴다.
			
		
	}
	
	
	//돌아올때 콜백함수 자동실행 - 서버에서 응답이 왔을 때 실행되는 메서드
	function viewMessage() {
		
		var divE = document.getElementById("printDIV");
		
		if(XMLHttpRequest.readyState==1||
				XMLHttpRequest.readyState==2||
				XMLHttpRequest.readyState==3) {
			
			divE.innerHTML =
				"<img src='./image/processing.gif' width='50' height='50'/>"; //이미지 태그다. <img>로 써도된다,
				
		}else if(XMLHttpRequest.readyState==4) { // 4가오면 정상적으로 실행된 것
			
			divE.innerHTML = XMLHttpRequest.responseText;
		}
		
	}
	
	window.onload = function () {
		//body가 로딩될 때(창이 열릴때) getXMLHttpRequest() 호출
		getXMLHttpRequest(); 
	}

</script>

</head>
<body>

<h1>AjaxGetPost</h1>
<hr/>

<form action="" name="myForm">
<input type="text" name="greeting"/>
<input type="button" value="Get전송" onclick="ajaxRequestGet();">
<input type="button" value="Post전송" onclick="ajaxRequestPost();">
</form>

<!-- 데이터 여기에 뿌림 -->
<div id="printDIV" style="border: 1px solid blue; width: 50%"></div>

</body>
</html>