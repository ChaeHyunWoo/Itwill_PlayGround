<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	int su1 = Integer.parseInt(request.getParameter("su1"));
	int su2 = Integer.parseInt(request.getParameter("su2"));
	String oper = request.getParameter("oper");
	
	int sum = 0;
	
	if(oper.equals("hap"))
		sum = su1 + su2;
	else if(oper.equals("sub"))
		sum = su1 - su2;
	else if(oper.equals("mul"))
		sum = su1 * su2;
	else if(oper.equals("div"))
		sum = su1 / su2;
	
	//XML을 만들어서 데이터를 보낸다.
	StringBuffer sb = new StringBuffer();
	
	//넘어오는 데이터
	sb.append("<?xml version='1.0' encoding='utf-8'?>\n");//누적
	sb.append("<root>" + sum + "</root>"); //root태그에 묶인 sum값을 test1으로 보낸다
	
	//만든 XML을 클라이언트한테 돌려준다. response를 써서
	response.setContentType("text/xml;charset=utf-8");
	response.getWriter().write(sb.toString()); //sb에 있는 toString으로 바꿔서 writer를 써서 데이터를 보낸다.
											   //보낸 데이터는 콜백함수가 실행되면서 받는다.
	
%>
