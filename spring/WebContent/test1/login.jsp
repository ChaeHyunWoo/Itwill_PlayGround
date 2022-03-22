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

<form action="<%=cp%>/test1/login.action" method="post">

아이디: <input type="text" name="userId"/><br/>
패스워드: <input type="password" name="userPwd"/><br/>
로그인 타입:
<!-- LoginController.java의 referenceData 데이터를 가져온다. -->
<select name="loginType">
	<c:forEach var="type" items="${loginType }">
		<option value="${type }">${type }</option>
	</c:forEach>
</select>
<br/>
<!-- LoginController.java에서 onSubmit을 사용하기 때문에 type을 submit으로 한다. -->
<input type="submit" value="로그인"/>

</form>

</body>
</html>