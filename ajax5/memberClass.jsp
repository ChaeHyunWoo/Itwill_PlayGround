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
<script type="text/javascript" src="<%=cp%>/data/js/member.js"></script>

<script type="text/javascript">

	function memberClass() {
		
		//1.member.js없이 실행
		var object1 = {};
		object1.id = "suzi";
		object1.name = "배수지";
		
		log("log1: " + object1.id + ", " + object1.name);
		
		
		//2.member.js없이 실행
		var object2 = new Object();
		object2.id = "inna";
		object2.name = "유인나";
		
		log("log2: " + object1.id + ", " + object1.name);
		
		//3.Member 클래스 객체
		var member = new Member("insung","정인성","서울");
		log("member1: " + member.id + ", " + member.name + ", " + member.addr);
		
		//4. setter 로 호출
		member.setValue("suzin","경수진", "옥탑방");
		log("member2: " + member.id + ", " + member.name + ", " + member.addr);
		
		//5. getter 로 호출
		var memberInfo = member.getValue();
		log("member.getValue(): " + memberInfo);
	}
	
	window.onload = function() {
		memberClass();
	}

</script>

</head>
<body>

<h1>Javascript 클래스 사용</h1>

<hr/>

<div id="console"></div>

</body>
</html>