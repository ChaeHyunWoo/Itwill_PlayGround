package com.boardTest;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.util.MyUtil;
import com.util.dao.CommonDAO;
import com.util.dao.CommonDAOImpl;

public class BoardAction extends DispatchAction {
	
	//게시글 작성(created)페이지
	public ActionForward created(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		
		return mapping.findForward("created"); 
	}
	
	//게시글 작성완료 시(created_ok)
	public ActionForward created_ok(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//DB 연결자 가져온다. 그래서 inserdate등을 호출할 수 있게 된다.
		CommonDAO dao = CommonDAOImpl.getInstance();
				
		//Object로 넘어오니 다운캐스팅
		BoardForm f = (BoardForm)form;
				
		//boardTest_sqlMap.xml에 있는 board 안에 있는 maxNum호출
		int maxNum = dao.getIntValue("board.maxNum");
				
		f.setNum(maxNum + 1);
		f.setIpAddr(request.getRemoteAddr());
		
		//board.insertData : board안의 insertDate를 호출 / 
		//boardForm을 매개변수로 받아와야하는데 위에서 BoardForm을 f에 넣어줬으니 여기에 f를 쓴다.
		dao.insertData("board.insertData", f);
		
		
		return mapping.findForward("created_ok"); 
	}
	
	//게시판 리스트조회 시(list)
	public ActionForward list(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		
		String cp = request.getContextPath();
		MyUtil myUtil = new MyUtil();// 페이징처리
		
		// 기존 BoardServlet 내용의 list 부분 가져옴 
		String pageNum = request.getParameter("pageNum");

		int currentPage = 1;

		if(pageNum!=null)
			currentPage = Integer.parseInt(pageNum);

		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		
		// 디코딩해서 받는다
		// null값 찾기
		
		// 검색을안했으면
		if(searchValue==null||searchValue.equals("")) {
			searchKey = "subject";
			searchValue = "";
			
		}else {
			// 검색을했으면 
			if(request.getMethod().equalsIgnoreCase("GET")) {
				
				//디코더 시킨다.
				// 값을 UTF-8로 인코딩
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
		}
		
		//우리는 map에 담아서 데이터를 보내기 때문에 map에 담아줘야함
		Map<String, Object> hMap = new HashMap<>();
		hMap.put("searchKey", searchKey);
		hMap.put("searchValue", searchValue);
		
		// 검색한 데이터 전체 개수
		//boardTest_sqlMap.xml에 있는 select문 id="dataCount"에 hmap 매개변수와 함께 전달
		int dataCount = dao.getIntValue("board.dataCount", hMap);
		
		
		// 한화면에 표시할 데이터 개수
		int numPerPage = 5;
		int totalPage = myUtil.getPageCount(numPerPage, dataCount);

		if(currentPage>totalPage)
			currentPage = totalPage;
		
		//데이터베이스에서 가져올 시작과 끝위치 rnum
		int start = (currentPage-1)*numPerPage+1;
		int end = currentPage*numPerPage;
		
		hMap.put("start", start);
		hMap.put("end", end);
		//hMap에는 4개의 데이터가 존재(searchKey,searchValue,start,end)
		
		List<Object> lists =
				dao.getListData("board.listData", hMap);
		
		
		// 리스트에서 설치키 설치벨류를 article 로 값 보내기 
		String param = "";
		// null을 못찾을수있으니 조건 2번줌
		if(searchValue!=null&&!searchValue.equals("")) {
			
			// 검색을했으면
			param = "searchKey=" + searchKey;
			param+= "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
		}
		
		// 가상의 주소를 담는다.	
		String listUrl = cp + "/boardTest.do?method=list";

		if(!param.equals("")) {
			
			// 널이아니면 검색을 했다.
			// myUtil 뒤에 검색된 주소가 딸려간다.
			// listUrl은 ?가 없으므로 붙인것
			listUrl += "&" + param;
		}

		String pageIndexList =
				myUtil.pageIndexList(currentPage, totalPage, listUrl);
		
		
		// 리스트를 클릭했을때 article로 넘어가는부분 
		
		// 글보기 주소를 만든다.
		// 검색을 안했다면
				
				
		// 현재페이지를 넘겨준다 ( 되돌아 올수있게 )
		String articleUrl = cp + "/boardTest.do?method=article&pageNum=" + currentPage;
		
		
		// 검색을 했다면 param 까지
		// 뒤에 붙일거니까 &를 붙이는것이다.
		if(!param.equals("")) {
			
			
			// articleUrl 은 ?가 있어서 	
			// 현재페이지를 넘겨준다 ( 되돌아 올수있게 - 키와 값 검색을했을때 되돌아올수있게 )
			articleUrl += "&" + param;
		}

		//포워딩 페이지에 데이터 넘기기
		request.setAttribute("lists", lists);
		request.setAttribute("articleUrl", articleUrl);
		request.setAttribute("pageIndexList", pageIndexList);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPage", totalPage);
		
		// dataCount는 null이아닐떄 pageIndexList를 띄우기위해
		request.setAttribute("dataCount", dataCount);
		
		
		
		return mapping.findForward("list");
		
		
	}
	
	public ActionForward article(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		// 값이 있으면
		if(searchValue != null) {
			
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}else {
			searchKey = "subject";
			searchValue = "";
		}
		
		//게시물번호(프라이머리키) 조회수 증가
		dao.updateData("board.hitCountUpdate", num);
		
		
		// 하나의 데이터 읽어온다
		// setAttribute("dto",dto);
		BoardForm dto = (BoardForm)dao.getReadData("board.readData", num);
		
		if(dto==null) {
			
			return mapping.findForward("list");
			
		}
		
		// 라인수 
		// setAttribute("line",lineSu);
		int lineSu = dto.getContent().split("\n").length;
		
		dto.setContent(dto.getContent().replace("\n", "<br/>"));
		
		//이전글,다음글
		String preUrl = "";
		String nextUrl = "";
		
		String cp = request.getContextPath();
		
		Map<String, Object> hMap = new HashMap<>();
		hMap.put("searchKey", searchKey);
		hMap.put("searchValue", searchValue);
		hMap.put("num", num);
		
		String preSubject = "";
		BoardForm preDTO =
				(BoardForm)dao.getReadData("board.preReadData", hMap);
		
		if(preDTO!= null) {
			
			preUrl = cp + "/boardTest.do?method=article&pageNum=" + pageNum;
			preUrl+= "&num=" + preDTO.getNum();
			
			preSubject = preDTO.getSubject();
			
		}
		

		String nextSubject = "";
		BoardForm nextDTO =
				(BoardForm)dao.getReadData("board.nextReadData", hMap);
		
		if(nextDTO!= null) {
			
			nextUrl = cp + "/boardTest.do?method=article&pageNum=" + pageNum;
			nextUrl+= "&num=" + nextDTO.getNum();
			
			nextSubject = nextDTO.getSubject();
			
		}
		
		String urlList = cp + "/boardTest.do?method=list&pageNum=" + pageNum;
		
		//검색을 했으면
		if(!searchValue.equals("")) {
			
			searchValue = URLEncoder.encode(searchValue, "UTF-8");
			
			urlList += "&searchKey=" + searchKey 
					+ "&searchValue=" + searchValue;
			
			if(!preUrl.equals("")) {
				
				preUrl += "&searchKey=" + searchKey 
						+ "&searchValue=" + searchValue;
				
			}
			
			if(!nextUrl.equals("")) {
				
				nextUrl += "&searchKey=" + searchKey 
						+ "&searchValue=" + searchValue;
				
			}
			
		}
		
		
		//수정과 삭제에서 사용할 인수
		String paramArticle = "num=" + num + "&pageNum=" + pageNum;
		
		request.setAttribute("dto", dto);
		request.setAttribute("preSubject", preSubject);
		request.setAttribute("preUrl", preUrl);
		request.setAttribute("nextSubject", nextSubject);
		request.setAttribute("nextUrl", nextUrl);
		request.setAttribute("linSu", lineSu);
		request.setAttribute("paramArticle", paramArticle);
		request.setAttribute("urlList", urlList);
		
		
		
		return mapping.findForward("article");
	}

}
