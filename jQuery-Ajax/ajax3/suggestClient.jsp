<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=cp%>/data/js/httpRequest.js"></script>

<script type="text/javascript">

	function sendKeyword() {
		
		var userKeyword = document.myForm.userKeyword.value;
		
		if(userKeyword=="") {
			hide();
			return;
		}
		
		var params = "userKeyword=" + userKeyword;
		
		sendRequest("suggestClient_ok.jsp",params,displaySuggest,"POST"); // 경로 , 데이터 , 콜백함수 , 방법
		
	}

	// 콜백함수
	function displaySuggest() {
		
		if(httpRequest.readyState==4) {
			if(httpRequest.status==200) {
				
				var resultText = httpRequest.responseText;
				//alert(resultText);
				
				var resultArray = resultText.split("|");
				
				var count = parseInt(resultArray[0]);
				//alert(count);
				
				var keywordList = null;
				
				if(count>0) {
					keywordList = resultArray[1].split(",");
					
					var html = "";
					
					// 각각의 제시어에 링크 걸기
					for(var i=0;i<keywordList.length;i++) {
						
						html += "<a href=\"javascript:select('"
								+ keywordList[i] + "');\">"
								+ keywordList[i] + "</a><br/>";
								
						//<a href="javascript:select('ajax');">ajax</a><br/> /* select 한 결과 링크가 들어가게 됨   */		
					}
					
					// 출력할 위치
					var suggestDiv = document.getElementById("suggestListDiv");
					
					suggestListDiv.innerHTML = html;
					
					show();
					
				} else { // count == 0
					hide();
				}
			} else { //status!=200
				hide();
			}
		} else { // redayState!=4 가 아닌경우 
			hide();
		}
		
	}
	// 사용자가 제시어에서 클릭한 키워드를 클릭하면 검색되어진다.
	function select(selectKeyword) {
		
		document.myForm.userKeyword.value = selectKeyword; // 키값을 주면 그걸 폼에 value값에 넣어줌
		hide(); // 창숨김
	}
	
	// suggestDiv 보이나 안보이나 
	
	// 화면보기
	function show() {
		
		var suggestDiv = document.getElementById("suggestDiv");
	
		suggestDiv.style.display = "block"; // block은 보이기 
	}
	
	// 화면 숨기기
	function hide() {
		
		var suggestDiv = document.getElementById("suggestDiv");
		
		suggestDiv.style.display = "none"; //  숨기기 
		
	}
	
	window.onload = function() {
		hide(); 
		
	}


</script>




<title>Insert title here</title>

<style type="text/css">



.suggest {

	display: none;
	position: absolute; /* 위치맞춰줌 */
	left: 11px;
	top: 141; /* 출력위치  크롬은 141 */
	
}


</style>

</head>
<body>

<h1>제시어</h1>
<br/>

<form action="" name="myForm">

<input type="text" name="userKeyword" onkeyup="sendKeyword();">
<input type="button" value="검색"/>

<div id="suggestDiv" class="suggest">
	<div id="suggestListDiv"></div>

</div>	

</form>	
	
</body>
</html>