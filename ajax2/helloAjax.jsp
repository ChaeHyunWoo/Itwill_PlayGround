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

	var XMLHttpRequest; 
	
	function ajaxRequest() {//비동기방식으로 서버와 연결해주는 객체
		
		//IE
		//XMLHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		
		//크롬
		XMLHttpRequest = new XMLHttpRequest();
		
		XMLHttpRequest.open("GET","helloAjax_ok.jsp",true);
		XMLHttpRequest.onreadystatechange = viewMessage; //콜백함수 이름을 viewMessage로 할 것이다.
		XMLHttpRequest.send(null); //get방식으로 보내니까 null
		
	}
	
	
	//돌아올때 콜백함수 자동실행 - 서버에서 응답이 왔을 때 실행되는 메서드
	function viewMessage() {
		
		//돌아오는 데이터가 텍스트이면 Text로 받는다.
		var responseText = XMLHttpRequest.responseText;
		 
		var divE = document.getElementById("printDIV");
		 
		divE.innerHTML = responseText;
		
		
	}
	
	

</script>

</head>
<body>

<h1>Hello Ajax</h1>

<input type="button" value="클릭" onclick="ajaxRequest();">

<br/><br/>
<div id="printDIV" style="border: 1px solid red; width: 50%"></div>

</body>
</html>