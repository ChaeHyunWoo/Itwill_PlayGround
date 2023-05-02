<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	Calendar cal = Calendar.getInstance();
	
	//오늘 날짜구하기
	int nowYear = cal.get(Calendar.YEAR);
	int nowMonth = cal.get(Calendar.MONTH) + 1; //달력은 월을 0~11월로 갖고있기에 +1를 해줘야함
	int nowDay = cal.get(Calendar.DAY_OF_MONTH); //일 구하기
	
	//클라이언트가 넘겨준 데이터
	String strYear = request.getParameter("year");//처음 실행하게되면 null / 넘어오는 데이터가 없기 때문
	String strMonth = request.getParameter("month");//처음 실행하게되면 null
	
	int year = nowYear;  
	//2022년  처음 실행할 때는 값(년,월)이 없기때문에 2022년을 찍어줘야한다.
	//두번째로 찍을 때는 위의 strYear,Month를 여기에있는 int year,month에 값을 덮어씌운다.
	int month = nowMonth; //2월
	
	if(strYear != null) { // strYear이 null이 아니면
		year = Integer.parseInt(strYear); //strYear를 숫자로 바꿔서 덮어씌워라(year에 넣어라)
	}
	
	if(strMonth != null) {
		month = Integer.parseInt(strMonth); //위와 동일
	}
	
	int preYear = year;
	int preMonth = month-1;
	
	if(preMonth<1) {
		preYear=year-1;
		preMonth=12;
	}
	
	int nextYear=year;
	int nextMonth=month+1;
	
	if(nextMonth>12) {
		nextYear=year+1;
		nextMonth=1;
	}
	
	//표시할 달력 세팅
	cal.set(year, month-1, 1);
	
	int startDay = 1;
	int endDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);//말일 구하기(calendar가 알아서 구해줌)
	
	//year년 month월 1일의 week구하기
	int week = cal.get(Calendar.DAY_OF_WEEK);//주의 수 구하기
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

body {

	font-size: 12pt;
}


td {

	font-size: 12pt;

}




</style>

</head>
<body>
<br/><br/>

<table align="center" width="210" cellpadding="2" cellspacing="1">

<tr>
	<td align="center">
	
	<a href="calendar.jsp?year=<%=nowYear %>&month+<%=nowMonth %> ">
	<img src="./image/today.png" width="35" height="25" align="left">
	</a>
	
	<a href="calendar.jsp?year=<%=preYear %>&month=<%=preMonth %>">◀</a>
	<b>&nbsp;<%=year %>년&nbsp;&nbsp;<%=month %>월</b>
	<a href="calendar.jsp?year=<%=nextYear %>&month=<%=nextMonth %>">▶</a>
	
	</td>
</tr>
</table>



<table align="center" width="210" cellpadding="2" cellspacing="1" bgcolor="#cccccc">
<tr>
	<td bgcolor="#e6e4e6" align="center"><font color="red">일</font></td>
	<td bgcolor="#e6e4e6" align="center">월</td>
	<td bgcolor="#e6e4e6" align="center">화</td>
	<td bgcolor="#e6e4e6" align="center">수</td>
	<td bgcolor="#e6e4e6" align="center">목</td>
	<td bgcolor="#e6e4e6" align="center">금</td>
	<td bgcolor="#e6e4e6" align="center"><font color="blue">토</font></td>
</tr>

<%
	int newLine=0;
	
	//내장객체(서블릿을 통해 만듬)
	out.print("<tr height='20'>");
	
	//달력 빈공간 만들기
	for(int i=1; i<week; i++) {
		
		out.print("<td bgcolor='#ffffff'>&nbsp;</td>");
		newLine++; //한줄 입력할때마다 1씩 증가
	}
	
	for(int i=startDay; i<=endDay; i++) {
		
		//글꼴색
		String fontColor = (newLine==0) ? "red" : (newLine==6) ? "blue" : "black";
		
		//오늘날짜 배경색
		String bgColor = (nowYear==year)&&
				(nowMonth==month)&&(nowDay==i)?"#e5e4e6":"#ffffff";
		
		out.print("<td align='center' bgcolor='" + bgColor + 
				"'><font color='" + fontColor + "'>" + i + "</font></td>");
		//<td align='center' bgcolor = '#ffffff'><font color='black'>10</font></td>
		
		newLine++; //한칸찍을때마다 증가
		
		if(newLine==7 && i!=endDay) {
			out.print("</tr><tr height='20'>");
			
			newLine=0; //초기화해야 빨강/파랑색이 적용
		}
		
	}
	
	//빈칸 td만들기 - td를 다 만들고 닫아줘야함
	while(newLine>0 && newLine<7) { //남은 칸 수를 흰색으로 변경
		out.print("<td bgcolor='#ffffff'>&nbsp;</td>");
		newLine++;
		
	}
	
	out.print("</tr>");

%>








</table>




</body>
</html>