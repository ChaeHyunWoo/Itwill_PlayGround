<%@ page contentType="text/plain; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	//JSON형태 데이터는 xml도 아니고 html도 아니고 text이다 그래서 위에 text/plain;으로 써준다.
%>

{


	"count":6,
	"titles":[
		{
		"publisher":"동아",
		"headline":"[속보] 김세환 선관위 사무총장 사의 표명"
		},
		{
		"publisher":"CNN",
		"headline":"50만원짜리 삼성폰 실물공개…'가성비 갑vs충전기는?'"
		},
		{
		"publisher":"한국",
		"headline":"1억 넣으면 하루 5400원씩 매일 이자 준다는 '이것'"
		},
		{
		"publisher":"JTBC",
		"headline":"'GOS 논란 삼성 사과하라'…주총 찾은 1600명 개미들"
		},
		{
		"publisher":"KBS",
		"headline":"피해 급증 우크라…젤렌스키 대통령, 결단 내렸다"
		},
		{
		"publisher":"MBC",
		"headline":"중립국 핀란드 변화에…'푸틴, 땅치고 후회할 수도'"	
		}
	]


}