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
<title>답 변 형 게 시 판(Struts2)</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/board/css/style.css"/>
<link rel="stylesheet" type="text/css" href="<%=cp%>/board/css/created.css"/>

<script type="text/javascript" src="<%=cp%>/board/js/util.js"></script>
<script type="text/javascript">

	function sendIt(){
		
		var f = document.myForm;
		
		str = f.subject.value;
		str = str.trim();
		if(!str){
			alert("\n제목을 입력하세요.");
			f.subject.focus();
			return;
		}
		f.subject.value = str;
		
		str = f.name.value;
		str = str.trim();
		if(!str){
			alert("\n이름을 입력하세요.");
			f.name.focus();
			return;
		}		
		
	/* 	if(!isValidKorean(str)){
			alert("\n이름을 정확히 입력하세요.");
			f.name.focus()
			return;
		}		 */
		f.name.value = str;
		
		if(f.email.value){
			if(!isValidEmail(f.email.value)){
				alert("\n정상적인 E-Mail을 입력하세요.");
				f.email.focus();
				return;
			}
		}
		
		str = f.content.value;
		str = str.trim();
		if(!str){
			alert("\n내용을 입력하세요.");
			f.content.focus();
			return;
		}
		f.content.value = str;
		
		str = f.pwd.value;
		str = str.trim();
		if(!str){
			alert("\n패스워드를 입력하세요.");
			f.pwd.focus();
			return;
		}
		f.pwd.value = str;
		
		/*  입력  수정  댓글 */
		/* request.setAttribute("mode", "create"); */
		/* 주소를 분리해놨다.  */
		if(f.mode.value=="create") {
			f.action = "<%=cp%>/bbs/created.action";
		}else if(f.mode.value=="update") {
			f.action = "<%=cp%>/bbs/updated.action";
		}else if(f.mode.value=="reply") {
			f.action = "<%=cp%>/bbs/reply.action";
		}

		f.submit();
		
	}

</script>


</head>
<body>

<div id="bbs">
	<div id="bbs_title">
		답 변 형 게 시 판(Struts2)
	</div>
	
	<form action="" method="post" name="myForm">
	<div id="bbsCreated">
		
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>
				<dd>
				<input type="text" name="subject" value="${dto.subject }" size="60" 
				maxlength="100" class="boxTF"/>
				</dd>
			</dl>		
		</div>
		
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>
				<input type="text" name="name" value="${dto.name }" size="35" 
				maxlength="20" class="boxTF"/>
				</dd>
			</dl>		
		</div>
		
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>E-Mail</dt>
				<dd>
				<input type="text" name="email" value="${dto.email }" size="35" 
				maxlength="50" class="boxTF"/>
				</dd>
			</dl>		
		</div>
		
		<div id="bbsCreated_content">
			<dl>
				<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
				<dd>
				<textarea rows="12" cols="63" name="content"
				class="boxTA">${dto.content }</textarea>
				</dd>
			</dl>
		</div>
		
		<div class="bbsCreated_noLine">
			<dl>
				<dt>패스워드</dt>
				<dd>
				<input type="password" name="pwd" value="${dto.pwd }" size="35" 
				maxlength="7" class="boxTF"/>
				&nbsp;(게시물 수정 및 삭제시 필요!!)
				</dd>
			</dl>		
		</div>	
	
	</div>
	
	<div id="bbsCreated_footer">
	
		<!-- 수정으로 쓸곳 , 수정하기 위해서 필요한것이다. -->
		<input type="hidden" name="boardNum" value="${dto.boardNum }"/>
		
		<!-- 변수에 담아서 보내주무르 dto.pageNum에서 pageNum으로 바꾼다. 
		req.setAttribute( -->
		<input type="hidden" name="pageNum" value="${pageNum }"/>
		
		<!-- 댓글달때 필요하므로 써놓음 -->
		<input type="hidden" name="groupNum" value="${dto.groupNum }"/>
		<input type="hidden" name="orderNo" value="${dto.orderNo }"/>
		<input type="hidden" name="depth" value="${dto.depth }"/>
		
		<!-- parent에는 부모의 boardNum이 들어간다.  -->
		<input type="hidden" name="parent" value="${dto.boardNum }"/>
		
		<!--  입력용인지 수정용인지 댓글용인지 -->
		<input type="hidden" name="mode" value="${mode }"/>
		
		
		<c:if test="${mode=='create' }">
		<input type="button" value=" 등록하기 " class="btn2" onclick="sendIt();"/>
		<input type="reset" value=" 다시입력 " class="btn2" 
		onclick="document.myForm.subject.focus();"/>
		<!-- 넘어갈때 pageNum도 넘어갈수있게 한다.  -->
		<input type="button" value=" 작성취소 " class="btn2"
		 onclick="javascript:location.href='<%=cp%>/bbs/list.action?pageNum=${pageNum }';"/>
		</c:if>
		 
		<c:if test="${mode=='update' }">
		<input type="button" value=" 수정하기 " class="btn2" onclick="sendIt();"/>
		<!-- 넘어갈때 pageNum도 넘어갈수있게 한다.  -->
		<input type="button" value=" 수정취소 " class="btn2"
		 onclick="javascript:location.href='<%=cp%>/bbs/list.action?pageNum=${pageNum }';"/>
		</c:if>
		 
		<c:if test="${mode=='reply' }">
		<input type="button" value=" 답변등록하기 " class="btn2" onclick="sendIt();"/>
		<input type="reset" value=" 다시입력 " class="btn2" 
		onclick="document.myForm.subject.focus();"/>
		<!-- 넘어갈때 pageNum도 넘어갈수있게 한다.  -->
		<input type="button" value=" 작성취소 " class="btn2"
		 onclick="javascript:location.href='<%=cp%>/bbs/list.action?pageNum=${pageNum }';"/>
		</c:if>
		 
	</div>
	</form>
</div>
</body>
</html>





