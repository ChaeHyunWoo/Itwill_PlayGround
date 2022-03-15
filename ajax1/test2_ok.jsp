<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	//넘어오는 값 받는다
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
%>

<!-- 받아낸 값을 xml자체를 넘겨준다 -->

<root>
	<status>권장도서</status>
	<record id="1">
		<subject><%=subject%></subject>
		<content><%=content%></content>
	</record>
	<record id="2">
		<subject>도깨비</subject>
		<content>유인나</content>
	</record>
</root>