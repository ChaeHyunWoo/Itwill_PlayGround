<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String msg = (String)request.getAttribute("msg"); //다운캐스팅을 해줘야 한다.

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

리다이렉트 또는 포워드한 페이지<br/>
<%=name %><%=msg %>

</body>
</html>