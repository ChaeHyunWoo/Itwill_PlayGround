<%@ page contentType="text/html; charset=UTF-8"%>
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


	String[] newsPublisher = {
			
		"중앙","CNN","한국","JTBC","KBS","MBC"	
	};

	
%>
<!-- 일반 형태의 데이터를 JSON형태로 만든다 -->
{
	"count":<%=newsTitle.length %>,
	"titles":[
	<%
		for(int i=0; i<newsTitle.length;i++) {
			
			out.print("{");
			out.print("headline:\"" + newsTitle[i] + "\"");
			out.print(",");
			out.print("publisher:\"" + newsPublisher[i] + "\"");
			out.print("}");
			
			if(i!=(newsTitle.length-1)) {
				out.print(",");
			}
			
		}
	
	
	
	%>
	]
}