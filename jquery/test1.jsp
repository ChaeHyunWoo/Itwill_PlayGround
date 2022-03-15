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
</head>
<body>

<script type="text/javascript" src="<%=cp%>/data/js/jquery-3.1.1.min.js"></script>

<script type="text/javascript">
	
	//window안에있는 onload 객체 - (window 생략가능)
	// onload 변수에 함수를 넣은 것이다 그래서 굳이 함수 이름을 안써도된다.
	/* window.onload = function () {
		
		alert("환영.");
		
	}
	
	window.onload = function () {
		
		alert("진짜 환영");
		
	} */
	
//jquery 방법
$(document).ready(function() {
	
	alert("환영!!!");
	
});

$(document).ready(function() {
		
	alert("진짜 환영!!!");
		
});

$(function() {
	
	$(document.body).css("background","pink");
});

$(function() {
	$("<div><p>제이쿼리</p></div>").appendTo("body");
});


</script>



</body>
</html>