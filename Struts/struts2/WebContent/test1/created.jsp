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

<form action="<%=cp%>/itwill/created_ok.action" method="post">
<!-- dto를 getter/setter를 만들어줘서 name 앞에 dto.을 써줘야한다. -->
아이디 : <input type="text" name="dto.userId"/><br/>
이름 : <input type="text" name="dto.userName"/><br/>
<input type="submit" value=" 보내기 "/><br/>

</form>

</body>
</html>