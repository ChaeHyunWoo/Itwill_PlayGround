<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPwd");
	
%>

아이디: <%=userId%><br/>
패스워드: <%=userPwd%><br/>