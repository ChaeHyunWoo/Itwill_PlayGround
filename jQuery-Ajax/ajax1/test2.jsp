<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
	//여기선 js + jquery의 ajax로 데이터 보내는 방법
	// Ajax & jQuery 를 사용해서 데이터 보내는 방법
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=cp%>/data/js/jquery-3.1.1.min.js"></script>

<!-- 데이터를 보내는 곳 -->
<script type="text/javascript">

	$(function(){
		
		$("#sendButton").click(function () {
			
			var params = "subject=" + $("#subject").val() + "&content=" + $("#content").val();
			
			$.ajax({
				
				//jquery는 post방식으로 거의 보낸다
				
				type:"POST",//전송방식
				url:"test2_ok.jsp",//주소
				data:params,//전송 데이터
				dateType:"xml", //돌아오는 데이터 타입(반환값)은 xml
				//갔다가 돌아왔을 때(성공) 실행하는 함수 - (돌아올때는xml데이터가 와서 받아줘야함)
				success:function(args) {
					
					//xml에서 데이터 읽기(parsing 작업 필요)
					$(args).find("status").each(function() { //status해당태그 검색,each는 반복작업명령어 
						
						alert($(this).text());//
					});
					
					var str = "";
					//each로 반복작업명령
					$(args).find("record").each(function() {
						
						//id는 속성이라 attr로 씀
						var id = $(this).attr("id");//레코드에 있는 속성 아이디를 찾아라
						var subject = $(this).find("subject").text(); //subject의 텍스트를 찾아라
						var content = $(this).find("content").text();
						
						str += "id=" + id + 
									",subject=" + subject +
									",content=" + content + "<br/>";
						
					});
					
					$("#resultDIV").html(str);//str를 넣어라
					
					
				},
				//showRequest는 사용자 정의 
				beforeSend:showRequest, //데이터를 보내기전에 무언가를 하는 함수(보내기전에 입력여부 체크)
				//갔다가 돌아왔을 때(실패) 실행하는 함수
				error:function(e) {
					alert(e.responseText);//에러메세지 텍스트로 띄우기
				}
				
			});
			

			
		});
		
	});
	
	//가기 전에 해야하는 작업
	function showRequest() {
		
		var flag = true;
		
		if(!$("#subject").val()) {//subject에 value가 없으면
			alert("제목을 입력하세요!");
			$("#subject").focus();
			return false; //false값을 반환하면 실행하지 않는다. true가 와야 실행	
		}
		
		if(!$("#content").val()) {//subject에 value가 없으면
			alert("내용을 입력하세요!");
			$("#content").focus();
			return false; //false값을 반환하면 실행하지 않는다. true가 와야 실행	
		}
		
		return flag; //flag 안에 true값이 들어가있다 그래서 flag를 반환하면서 실행
					 //true가 return되어야만 sendButton이 클릭되었을 때 함수가 돌아간다.
		
	}
	
	

</script>

</head>
<body>

제목: <input type="text" id="subject"/><br/>
내용: <input type="text" id="content"/><br/>
<input type="button" id="sendButton" value="보내기"/><br/>

<div id="resultDIV"></div> <!-- 여기에 데이터 뿌림 -->

</body>
</html>