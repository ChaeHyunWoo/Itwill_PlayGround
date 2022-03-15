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

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>

<script type="text/javascript" src="<%=cp%>/data/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=cp%>/data/js/jquery-ui.min.js"></script>

<script type="text/javascript">

	$(function() {
		
		$("#container").tabs();
		
	});

</script>

</head>
<body>

<div id="container">
	<ul>
		<li> <a href="#f1">첫번째</a></li>
		<li> <a href="#f2">두번째</a></li>
		<li> <a href="#f3">세번째</a></li>
	</ul>
	
	<div id="f1">
		나는 일등이다.
	</div>
	
	<div id="f2">
		나는 이등이다.
	</div>
	
	<div id="f3">
		나는 삼등이다.
	</div>


</div>

</body>
</html>