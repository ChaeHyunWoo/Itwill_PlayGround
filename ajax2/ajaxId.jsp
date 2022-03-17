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
	XMLHttpRequest = new XMLHttpRequest();// 객체 생성
	
	//하단 <input>태그에 onkeyup = requestGet();를 써서 손가락을 땔때마다 함수를 실행하도록 함
	function requestGet() {
		
		var f = document.myForm;
		
		if(!f.userId) {
			alert("아이디 입력!");
			f.userId.focus();
			return;
		}
		
		var params = "?userId=" + f.userId.value;
		
		//요청을 초기화하면서 요청 방식, 주소, 동기화 여부 지정
		XMLHttpRequest.open("GET","ajaxId_ok.jsp" + params, true);
		XMLHttpRequest.onreadystatechange = viewMessage; //viewMessage를 콜백함수로 지정
		XMLHttpRequest.send(null); //get방식이니 null
	}
	
	
	//콜백함수 : viewMessage
	function viewMessage() {
		
		if(XMLHttpRequest.readyState==4) {
			if(XMLHttpRequest.status==200) {
				//서버 응답 이상 없음
				var str = XMLHttpRequest.responseText;
				
				var divE = document.getElementById("resultDIV");
				divE.innerHTML = str;
				
			}
			
		}else {
			
			var divE = document.getElementById("resultDIV");
			divE.innerHTML = 
				"<img src='./image/loading.gif' width='15' height='15'/>";
				
				
			
		}
		
	}

</script>

</head>
<body>

<h1>Ajax ID 확인</h1>

<hr/>
<form action="" name="myForm">
<!-- onkeyup="requestGet(); :손가락을 땔때마다 함수 실행 -->
아이디: <input type="text" name="userId" onkeyup="requestGet();"/>

</form>
<br/><br/><br/><br/>

<div id="resultDIV" style="color: red; border: 1px solid #000000; width: 40%"></div>

</body>
</html>