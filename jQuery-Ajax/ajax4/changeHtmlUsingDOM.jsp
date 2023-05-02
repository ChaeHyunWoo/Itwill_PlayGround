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
<title>Insert title here</title>


<!-- dom 객체를 이용하여 추가 삭제   -->
<script type="text/javascript">

	var count = 0;
	
	
	// 추가 버튼 
	function addItem() {
		
		count++;
		var newItemE = document.createElement("div"); // div요소를 객체 하나 만들겠다는 소리
		
		newItemE.setAttribute("id","item_"+ count) // 속성의 이름을 넣고 value값  -> <div id ="item_01">
	
		var html = "새로 추가된 아이템[" + count + "]&nbsp;";
		html += "<input type=\"button\" value=\"삭제\" "+
		"onclick=\"removeItem('item_" + count + "');\"/>";
		// <div id="item_00">
		//    새로 추가된 아이템[00]<input type="button" value="삭제"
		//    onclick="removeItem('item_00');/>"
		// </div>	
		
		newItemE.innerHTML = html;
		
		var itemListDiv = document.getElementById("itemList");
		itemListDiv.appendChild(newItemE); // 위에서만든 newItemE를 자식 노드 추가 
		
	}
	
	// 삭제버튼
	function removeItem(itemId) {
		var removeItem = document.getElementById(itemId); // 위에있는 'item_" + count 를 받는다.
		removeItem.parentNode.removeChild(removeItem);
		
	}
</script>

</head>
<body>

<h1>HTML DOM을 이용한 화면 변경</h1>

<input type="button" value="추가" onclick="addItem();"/>

<div id="itemList"></div>

</body>
</html>