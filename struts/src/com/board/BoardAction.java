package com.board;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.util.DBConn;
import com.util.MyUtil;

//DispatchAction :  if문을 메소드단위로 만들것이다.
public class BoardAction extends DispatchAction{

	// 사용자 정의
	public ActionForward write(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		
		return mapping.findForward("created");
		
	}
	
	public ActionForward write_ok(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAO(conn);
		
		BoardForm f = (BoardForm)form;
		
		f.setNum(dao.getMaxNum() + 1);
		f.setIpAddr(request.getRemoteAddr());
		// 7개의 데이터를 넘겨주면 됨
		dao.insertData(f);
		
		return mapping.findForward("save");
		
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAO(conn);
		
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
		
		// 검색한 데이터 전체 개수
		int dataCount = dao.getDataCount(searchKey, searchValue);
		
		
		// 한화면에 표시할 데이터 개수
		int numPerPage = 5;
		int totalPage = myUtil.getPageCount(numPerPage, dataCount);

		if(currentPage>totalPage)
			currentPage = totalPage;
		
		//데이터베이스에서 가져올 시작과 끝위치 rnum
		int start = (currentPage-1)*numPerPage+1;
		int end = currentPage*numPerPage;
		
		
		// 검색했으면 키값 벨류 start end
		//데이터베이스에서 해당페이지를 가져온다
		List<BoardForm> lists =
				dao.getLists(start, end, searchKey, searchValue);
		
		
		// 리스트에서 설치키 설치벨류를 article 로 값 보내기 
		String param = "";
		// null을 못찾을수있으니 조건 2번줌
		if(searchValue!=null&&!searchValue.equals("")) {
			
			// 검색을했으면
			param = "searchKey=" + searchKey;
			param+= "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
		}
		
		// 가상의 주소를 담는다.	
		String listUrl = cp + "/board.do?method=list";

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
		String articleUrl = cp + "/board.do?method=article&pageNum=" + currentPage;
		
		
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
		
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAO(conn);
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		// 값이 있으면
		if(searchValue != null) {
			
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}
		
		//게시물번호(프라이머리키) 조회수 증가
		dao.updateHitCount(num);
		
		
		// 하나의 데이터 읽어온다
		// setAttribute("dto",dto);
		BoardForm dto = dao.getReadData(num);
		
		if(dto==null) {
			
			return mapping.findForward("list");
			
		}
		
		// 라인수 
		// setAttribute("line",lineSu);
		int lineSu = dto.getContent().split("\n").length;
		
		dto.setContent(dto.getContent().replace("\n", "<br/>"));
		
		// 밑에 몇번째 게시물인지 
		String param = "pageNum=" + pageNum;
		
		if(searchValue != null && !searchValue.equals("")) {
			
			//검색을 했다는거
			param += "&searchKey=" + searchKey;
			// 인코더 시켜서 보낸다
			param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
			
		}
		
		// 게시물 누르면 데이터가 보여지게 위해서 데이터를 넘김(setAttribute)
		
		
		
		// 값을 가지고 넘어가는 변수는 param을 쓸수없다
		// param은 이미 내부에 변수를 쓰고있다.
		request.setAttribute("dto", dto);
		request.setAttribute("params", param);
		request.setAttribute("linSu", lineSu);
		request.setAttribute("pageNum", pageNum);
		
		return mapping.findForward("article");
	}
	
	
	public ActionForward updated(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAO(conn);
		
		// 수정버튼 눌렀을때 주소창으로 넘어가는 데이터 
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue != null) {
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}
		
		BoardForm dto = dao.getReadData(num);
		
		if(dto==null) {
			
			return mapping.findForward("list");
			
		}
		
		String param = "pageNum=" + pageNum;
		
		if(searchValue != null&& !searchValue.equals("")) {
			param += "&searchKey=" + searchKey;
			param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
		}
		
		//이제 데이터 넘김
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("params", param);
		request.setAttribute("searchKey", searchKey);
		request.setAttribute("searchValue", searchValue);
		
		return mapping.findForward("updated");
	}
	
	
	public ActionForward updated_ok(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAO(conn);
		
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		BoardForm f = (BoardForm)form;
		
		f.setNum(Integer.parseInt(request.getParameter("num")));
		
		
		//수정된 데이터를 보낸다
		dao.updateData(f);
		
		//되돌아올때
		String param = "&pageNum=" + pageNum;
		
		if(searchValue != null&& !searchValue.equals("")) {
			param += "&searchKey=" + searchKey;
			param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
		}
		
		request.setAttribute("params", param);
		request.setAttribute("pageNum", pageNum);
		
		//return mapping.findForward("updated_ok");
		
		ActionForward af = new ActionForward();
		af.setRedirect(true);
		af.setPath("/board.do?method=list" + param);
		
		return af;
		
	}
	
	
	public ActionForward deleted(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAO(conn);
		
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		dao.deleteData(num);
		
		String param = "&pageNum=" + pageNum;
		
		if(searchValue != null&& !searchValue.equals("")) {
			param += "&searchKey=" + searchKey;
			param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
		}
		
		ActionForward af = new ActionForward();
		af.setRedirect(true);
		af.setPath("/board.do?method=list" + param);
		
		return af;
		
	}
	
	

}
