<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게 시 판</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/board/css/style.css"/>
<link rel="stylesheet" type="text/css" href="<%=cp%>/board/css/list.css"/>

</head>
<body>

<div id="bbsList">

	<div id="bbsList_title">
		게 시 판
	</div>
	<div id="bbsList_header">
		<div id="leftHeader">
		<form action="" method="post" name="searchForm">
			<select name="searchKey" class="selectField">
				<option value="subject">제목</option>
				<option value="name">작성자</option>
				<option value="content">내용</option>
			</select>
			<input type="text" name="searchValue" class="textField"/>
			<input type="button" value=" 검 색 " class="btn2" onclick=""/>		
		</form>				
		</div>
		<div id="rightHeader">
			<input type="button" value=" 글올리기 " class="btn2" onclick=""/>			
		</div>	
	</div>
	<div id="bbsList_list">
		<div id="title">
			<dl>
				<dt class="num">번호</dt>
				<dt class="subject">제목</dt>
				<dt class="name">작성자</dt>
				<dt class="created">작성일</dt>
				<dt class="hitCount">조회수</dt>
			</dl>
		</div>
		<div id="lists">
			<dl>
				<dd class="num">1</dd>
				<dd class="subject">게시판 리스트 만들기</dd>
				<dd class="name">배수지</dd>
				<dd class="created">2022-02-15</dd>
				<dd class="hitCount">10</dd>
			</dl>
		</div>
		<div id="footer">
			1 2 3
		</div>
		
	</div>
	
</div>

</body>
</html>