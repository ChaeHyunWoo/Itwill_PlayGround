<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	//JSON는 Map방식으로 <Key, Value> 형태로 데이터가 저장된다.
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<title>Insert title here</title>

<script type="text/javascript">

// JSON : 구조화된 텍스트 데이터의 교환을 위한 자바스크립트 표현식
/* json 형식으로 값을 받는 방법이다.  */
	$(function() { //$(document).ready(function ()를 생략해서 이렇게 쓸 수 있음
	
		$("#sendButton").click(function(){
			
			var params = "userId=" + $("#userId").val() +
					"&userPwd=" + $("#userPwd").val();
			
			$.ajax({
			
				type:"POST",
				url:"test5_ok.jsp",
				data:params,
				dataType:"json", // 돌아오는 타입이 json형태
				
				
				success:function(args) { // 성공하면 args에 데이터가 들어옴
				
					var str = "";
				/* 모양을 만듬 */
					for(var i=0; i<args.length;i++) {
						
						str += "id=" + args[i].id;
						str += ",userId=" + args[i].userId;
						str += ",userPwd=" + args[i].userPwd + "<br/>";
						
					}
					
					// 반복문을 통해 어이다가 출력할것인가
					$("#resultDIV").html(str);
					
				},
				// 에러일때 
				error:function(e) {
					alert(e.responseTest);
				}
			});
		});
	});

</script>

</head>
<body>
	아이디: <input type="text" id="userId"/><br/>
	패스워드: <input type="text" id="userPwd"/><br/>
	
	<!-- button이란 태그는 submit기능을 가지고 있다.  -->
	<button id="sendButton">전송</button>
	<br/><br/>
	
	<div id="resultDIV"></div>
</body>
</html>