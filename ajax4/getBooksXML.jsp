<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=cp%>/data/js/httpRequest.js"></script>

<script type="text/javascript">

	function getBookList() {
		
		sendRequest("books.xml",null,displayBookList,"GET");
		
	}
	
	//콜백함수
	function displayBookList() {
		
		if(httpRequest.readyState==4){
			if(httpRequest.status==200){
				
				//전달받은 xml을 dom 객체에 넣음
				var Document = httpRequest.responseXML;

				//dom 객체에서 element 추출
				var booksE = Document.documentElement;
				
				//book의 갯수 호출 
				var bookNL = booksE.getElementsByTagName("book");

				//전체데이터 읽어오기
				var html = "";
				html += "<ol>";
				
				for(var i=0;i<bookNL.length;i++){
					
					var bookE = bookNL.item(i); 
					
					var titleStr = bookE.getElementsByTagName("title").item(0).firstChild.nodeValue;
					var authorStr = bookE.getElementsByTagName("author").item(0).firstChild.nodeValue;
				
					html += "<li>"
					+ titleStr
					+"&nbsp;&nbsp;&nbsp;&nbsp;"
					+ authorStr + "</li>";
					
				}
				
				html += "</ol>";
				
				document.getElementById("bookDiv").innerHTML = html;
				
			}
		}
	}

	window.onload = function () {
		getBookList();
	}
</script>

</head>
<body>

<h1 id="list">Book List</h1>
<hr/>

<div id="bookDiv" style="display: block; margin: 0 auto;"></div>
</body>
</html>