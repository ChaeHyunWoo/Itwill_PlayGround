<%@page import="java.util.Date"%>
<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%!

	String[] newsTitle = {			
		"[속보] 김세환 선관위 사무총장 사의 표명",
		"50만원짜리 삼성폰 실물공개…'가성비 갑vs충전기는?'",
		"1억 넣으면 하루 5400원씩 매일 이자 준다는 '이것'",
		"'GOS 논란 삼성 사과하라'…주총 찾은 1600명 개미들",
		"피해 급증 우크라…젤렌스키 대통령, 결단 내렸다",
		"중립국 핀란드 변화에…'푸틴, 땅치고 후회할 수도'"			
	};

%>

<result>
	<count><%=newsTitle.length%></count>
	<data>
		<%for(int i=0;i<newsTitle.length;i++) { %>
			<title><%=newsTitle[i] + "|" + new Date() %></title>
		<%} %>
	</data>
</result>
	
	
	