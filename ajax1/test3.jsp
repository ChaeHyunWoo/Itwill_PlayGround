<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	//여기선 jquery로 데이터 넘기는 방법
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<script type="text/javascript">

$(document).ready(function () { //ready는 DOM이 생성되면 실행
	
	$("#saveButton").click(function () {
		
		//값을 읽어낸다
		var value1 = $("#userId").val();
		var value2 = $("#userPwd").val();
		
		//post방식으로 보냄
		//test_ok.jsp, {userId:value1, userPwd:value2} 보내고,  function(args) 콜백함수
		$.post("test3_ok.jsp", {userId:value1, userPwd:value2}, function (args) {
			
			$("#resultDIV").html(args); //html형태로 args를 뿌려준다.
			
		});
		
	});
	// 지우기 버튼 눌렀을 때
	$("#clearButton").click(function () {
		$("#resultDIV").empty();
	});
	
});

</script>

</head>
<body>

아이디: <input type="text" id="userId"/><br/>
패스워드: <input type="text" id="userPwd"/><br/>

<button id="saveButton">전송</button>
<button id="clearButton">지우기</button>

<br/><br/>

<div id="resultDIV"></div> <!-- 여기에서 데이터 출력 -->

</body>
</html>