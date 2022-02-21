<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Servlet 게시판 목록</title>

</head>
<body>

<h1>JSP 첫페이지 - 현우</h1>

1. <a href="<%=cp%>/score/list.jsp">JSP 성적처리</a><br/>
2. <a href="<%=cp%>/board/list.jsp">JSP 게시판</a><br/>
3. <a href="<%=cp%>/guest/guest.jsp">JSP 방명록</a><br/>
4. <a href="<%=cp%>/sboard/list.do">Servlet 게시판</a><br/>
5. <a href="<%=cp%>/jumsu/list.do">Servlet 성적처리</a><br/>

</body>
</html>