<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	//서버에서 연산 작업이 이루어지는지 확인하고자 콘솔창에 출력함
	for(int i=0; i<300; i++) {
		System.out.print("delay....");
	}
	
%>
Hello Ajax!!!