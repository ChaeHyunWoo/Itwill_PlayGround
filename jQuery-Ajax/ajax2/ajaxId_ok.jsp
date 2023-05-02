<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	
	//넘어오는 데이터
	String userId = request.getParameter("userId");
	
	String str = "";
	
	if(!userId.equals("")) {
		
		for(int i=0; i<5000; i++) {
			System.out.print("delay");
		}
		
		//id를 읽어 왔으면
		if(userId.startsWith("suzi")) {
			str = userId + "는 유효한 아이디 입니다.";
		}else {
			str = userId + "는 유효한 아이디가 아닙니다.";
		}
	}
	
%>


<%=str %>