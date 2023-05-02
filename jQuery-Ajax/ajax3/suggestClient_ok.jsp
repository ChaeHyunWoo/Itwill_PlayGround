<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>


<%!

	String[] keywords = {
			
			
			// db에서 데이터를 읽어왔다 하고
			"ajax","Ajax","Ajax 실전 프로그래밍","AJA","AZERA","자수","자전거","자라","자바","자바 프로그래밍","자바 서버 페이지","자바 스터디 ","astra","abort","자바 서비스",
			"자바캔","ABC마트","Apple"
			
	};
	
	// 비교작업해서 일치하는값을 반환값으로 주게됨
	public List<String> search(String userKeyword) {
		
		if(userKeyword==null || userKeyword.equals("")) {
			return null; // 클래스의 초기값은 null
			// return Collections.EMPTY_LIST; 컬렉션리스트 비어있다.
		}
		// 소문자를 대문자로 만들고싶으면
		
		// userKeyword = userKeyword.toUpperCase();//대문자로바꿔서 넣음 그럼 대문자로 비교
		
		List<String> lists = new ArrayList<String>();
		
		// 위 배열 길이만큼 
		for(int i=0; i<keywords.length; i++) {
			
			// 키워드와 위치하면
			if(keywords[i].startsWith(userKeyword)) {
				lists.add(keywords[i]); // 하나하나 넣음 
			}
		}
		
		return lists;
	}


%>

<%
	
	String userKeyword = request.getParameter("userKeyword");

	List<String> keywordList =  search(userKeyword); // List에 담는다 일치하는 단어가 있는지 함수를 만든다.
	
	out.print(keywordList.size()); // 3 : ajax , abc , ... 식으로 나옴  
	out.print("|");
	
	// 리스트에 있으니까 iterator
	
	Iterator<String> it = keywordList.iterator();
	
	while(it.hasNext()) {
		String value = (String)it.next();
		
		out.print(value);
		
		if(keywordList.size()-1 > 0){
			out.print(","); // ,로 구분된 데이터를 만듬 
		}
	}
%>