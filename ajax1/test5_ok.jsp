<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	
	String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPwd");
	
	
	String result = "";
	
	for(int i=1;i<=3;i++){ // 데이터는 여러개다를 표현
		
		result += "{\"id\":\"" + i;  // \" 앞과 id뒤 \" 짝  \" 는 " 이됨 
		result += "\",\"userId\":\"" + userId;
		result += "\",\"userPwd\":\"" + userPwd + "\"},";
		
		
		// json형태의 데이터 
		// [
		//  key : value
		// {"id:"1","userId":"suzi","userPwd":"123"}, 똑같은 데이터를 여러개
		// {"id:"1","userId":"suzi","userPwd":"123"}, 똑같은 데이터를 여러개
		// {"id:"1","userId":"suzi","userPwd":"123"},  똑같은 데이터를 여러개
		// ]
	}
	
	
	result = result.substring(0,result.length()-1); // 마지막 , 를 뺌
	result = "[" + result + "]"; // 대괄호가 묶인 데이터가 나옴
	
	out.print(result); 
%>
