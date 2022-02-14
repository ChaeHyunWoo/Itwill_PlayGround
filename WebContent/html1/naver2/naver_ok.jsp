<%@page import="com.naver.NaverDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();

%>

<jsp:useBean id="dto" class="com.naver.NaverDTO" scope="page"/>
<jsp:setProperty property="*" name="dto"/>

<%
Connection conn = DBConn.getConnection(); // conn에 DB연결자가 들어가있다. ScoreDAO는 conn이 필요하다.

NaverDAO dao = new NaverDAO(conn); //ScoreDAO한테 conn을 매개변수로 준다.(생성자 오버로딩)

//dao.inserData(dto); //java는 반환값을 안적어도된다. java만 유일
int result = dao.inserData(dto);

DBConn.close();

if(result!=0)
	response.sendRedirect("naverList.jsp");



%>

