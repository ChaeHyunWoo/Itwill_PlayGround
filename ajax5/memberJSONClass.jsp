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

<script type="text/javascript" src="<%=cp%>/data/js/log.js"></script>
<script type="text/javascript" src="<%=cp%>/data/js/memberJson.js"></script>

<script type="text/javascript">

	function memberClass() {
		
		//1.
		var member = new com.util.Member("suzi","수지","서울");
		log("member1: " + member.id + ", " + member.name + ", " + member.addr);
		
		//2.
		member.setValue("inna","인나","부산");
		log("member2: " + member.id + ", " + member.name + ", " + member.addr);
		
		//3.
		var memberInfo = member.getValue();
		log("member.getValue(): " + memberInfo);
		
		//4.
		member.setId("insung");
		log("member.toString(): " + member.toString());//member의 toString으로 읽어낸다
		
		//5.
		var id = member.getId();
		log("member.getId(): " + id);
		
	}
	
	window.onload = function() {
		memberClass();
	}

</script>

</head>
<body>
<h1>Javascript 클래스 사용[JSON]</h1>

<hr/>

<div id="console"></div>
</body>
</html>