<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	//test1,test1_ok는 js로 데이터를 받는방법.
	
	//데이터를 받는방법은 js / js + jquery / jquery 3가지 방법이 있음
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=cp%>/data/js/ajaxUtil.js"></script>

<script type="text/javascript">

	function sendIt() {
		
		//var xmlHttp = new XMLHTTPRequest();
		
		xmlHttp = createXMLHttpRequest(); //시작할때 0번
		
		var query = "";
		var su1 = document.getElementById("su1").value;
		var su2 = document.getElementById("su2").value;
		var oper = document.getElementById("oper").value; //3개의 값을 받고
		
		//get 방식 데이터 전송 - 주소를 만들어주고
		query = "test1_ok.jsp?su1=" + su1 + "&su2=" + su2 + "&oper=" + oper;
		
		//이름은 사용자 정의
		xmlHttp.onreadystatechange = callback;//갔다가 돌아오면서 자동으로 실행된다.
		
		xmlHttp.open("GET",query,true);// 1번   /get방식으로 query를 보내고 true를 준다 / post방식일때는 false
												//get방식으로 보낼것인데 쿼리를 위 주소로 보내고 true(비동기방식)값 줌
		xmlHttp.send(null); // 2번 비동기 방식으로 보낸다.
		
		//3번은 서버에서 실행되고 될때마다 3번을 보내주고 다 되면 4번을 보내준다
		
	}
	//데이터를 처리해서 받는데가 콜백
	//콜백함수 : 서버에 던져서 돌아오면 무조건 멧드를 받아야됨.문법적으로 콜백함수라고함
	function callback() {
		
		if(xmlHttp.readyState==4){ //서버 작업이 완료되면 4
			if(xmlHttp.status==200) { //작업이 정상적으로 됬으면 200 아니면 404
				
				printData();
				
			}
		}
		
	}
	
	function printData() {
		//넘어오는 xml "root"를 읽어내서 result에 담는다.
		var result = xmlHttp.responseXML.getElementsByTagName("root")[0];
		//돌려주는 데이터가 xml이다.xml받을 준비를 해놓음
		
		//resultDIV에 뿌릴려면 객체화 시켜야한다
		var out = document.getElementById("resultDIV");
		
		out.innerHTML ="";
		out.style.display =""; //이미 한번 실행이 됬다면 null로 초기화(실행할때마다 초기화)
		
		var value = result.firstChild.nodeValue; //root 안의 첫번째 차일드의 값 sum을 잃어서 value에 넣음
		
		out.innerHTML = value; //value 값을 HTML화 시켜서 출력한다.
		
	}



</script>

</head>
<body>

<input type="text" id="su1"/>
<select id="oper">
	<option  value="hap">더하기</option>
	<option  value="sub">빼기</option>
	<option  value="mul">곱하기</option>
	<option  value="div">나누기</option>
</select>
<input type="text" id="su2"/>
<input type="button" value=" = " onclick="sendIt();"/>

<div id="resultDIV" style="display: none;"></div> <!-- 여기에 데이터 뿌림 -->

</body>
</html>