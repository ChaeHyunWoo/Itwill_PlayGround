package com.board;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.join.CustomInfo;
import com.util.DBConn;
import com.util.MyUtil;

public class BoardServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	//포워드 메서드 만들어서 호출해서 쓰기
	protected void forward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
		
		//포워딩될 페이지 지정 - 주소대신 String url을 써주면 우리는 forward를 호출할때 url을 써주면 된다.
		RequestDispatcher rd = 
				req.getRequestDispatcher(url);
		
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAO(conn);
		
		//애를 제외한 모든 객체는 공통으로 하는하는 객체이다
		MyUtil myUtil = new MyUtil(); //애는 페이징 처리 클래스이다.
		
		String cp = req.getContextPath(); // cp는 -> /study 이다
		String uri = req.getRequestURI(); // -> /study/sboard/sboard/created.do (uri는 전체 주소)
		
		String url;
		
		//uri에 created.do가 있으면 if문을 실행해라
		if(uri.indexOf("created.do")!=-1) {
			
			//로그아웃상태에서 게시판 글올리기를 하면 로그인 화면으로 보내버린다.
			//로그인 상태이면 글올리기로 넘어간다.
			HttpSession session = req.getSession();
			
			CustomInfo info = (CustomInfo)session.getAttribute("customInfo");
			
			if(info == null) {
				
				url = "/member/login.jsp";
				forward(req, resp, url);
				
				return; //info가 null일때 아래 코드를 실행시키면 안되니 return을 쓴다.
			}
			
			url = "/bbs/created.jsp";//이 주소를 직접 찾아간다.
			forward(req, resp, url);
			
		}else if(uri.indexOf("created_ok.do")!=-1) {
			
			BoardDTO dto = new BoardDTO();
			
			int maxNum = dao.getMaxNum();
			
			dto.setNum(maxNum + 1);
			//넘어오는건 post방식으로 넘어오니 getParameter로 받는다.
			// why? -> 서블릿에서는 action을 사용 못하니까 
			dto.setSubject(req.getParameter("subject"));
			dto.setName(req.getParameter("name"));
			dto.setEmail(req.getParameter("email"));
			dto.setPwd(req.getParameter("pwd"));
			dto.setContent(req.getParameter("content"));
			dto.setIpAddr(req.getRemoteAddr());
			
			dao.insertData(dto);
			
			url = cp + "/sboard/list.do";
			resp.sendRedirect(url);
		
		//만약에 created_ok.do가 있으면 	
		}else if(uri.indexOf("list.do")!=-1) {
			
			String pageNum = req.getParameter("pageNum");
			
			int currentPage = 1;
			
			if(pageNum!=null)
				currentPage = Integer.parseInt(pageNum);
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue==null) {
				searchKey = "subject";
				searchValue = "";
			}else {
				if(req.getMethod().equalsIgnoreCase("GET")) {
					searchValue = URLDecoder.decode(searchValue, "UTF-8");
				}
			}
			
			int dataCount = dao.getDataCount(searchKey, searchValue);
			
			int numPerPage = 5;
			int totalPage = myUtil.getPageCount(numPerPage, dataCount);
			
			if(currentPage>totalPage)
				currentPage = totalPage;
			
			int start = (currentPage-1)*numPerPage+1;
			int end = currentPage*numPerPage;
			
			//이제 데이터를 가져온다
			List<BoardDTO> lists = 
					dao.getLists(start, end, searchKey, searchValue);
			
			//페이징 처리 작업
			String param = "";
			if(searchValue!=null&&!searchValue.equals("")) {
				param = "searchKey=" + searchKey;
				param+= "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
			}
			
			String listUrl = cp + "/sboard/list.do";
			
			if(!param.equals("")) {
				listUrl += "?" + param;
			}
			
			String pageIndexList = 
					myUtil.pageIndexList(currentPage, totalPage, listUrl);
			
			String articleUrl = cp + "/sboard/article.do?pageNum=" + currentPage;
			
			if(!param.equals("")) {
				articleUrl += "&" + param;
			}
			
			//포워딩 페이지에 데이터 넘기기
			req.setAttribute("lists", lists);
			req.setAttribute("articleUrl", articleUrl);
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("dataCount", dataCount);
			
			
			
			url = "/bbs/list.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("article.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue != null) {
				
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
			
			dao.updateHitCount(num);
			
			BoardDTO dto = dao.getReadData(num);
			
			if(dto==null) {
				url = cp + "/sboard/list.do";
				resp.sendRedirect(url);
			}
			
			int lineSu = dto.getContent().split("\n").length;
			
			dto.setContent(dto.getContent().replace("\n", "<br/>"));
			
			String param = "pageNum=" + pageNum;
			if(searchValue != null && !searchValue.equals("")) {
				
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
				
			}
			
			req.setAttribute("dto", dto);
			req.setAttribute("params", param);
			req.setAttribute("linSu", lineSu);
			req.setAttribute("pageNum", pageNum);
			
			url = "/bbs/article.jsp";
			forward(req, resp, url);
			
			
		}else if(uri.indexOf("updated.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue != null) {
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
			
			BoardDTO dto = dao.getReadData(num);
			
			if(dto==null) {
				url = cp + "sboard/list.do";
				resp.sendRedirect(url);
			}
			
			String param = "pageNum=" + pageNum;
			
			if(searchValue != null&& !searchValue.equals("")) {
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
			}
			
			//이제 데이터 넘김
			req.setAttribute("dto", dto);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("params", param);
			req.setAttribute("searchKey", searchKey);
			req.setAttribute("searchValue", searchValue);
			
			url = "/bbs/updated.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("updated_ok.do")!=-1) {
			
			String pageNum = req.getParameter("pageNum");
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			BoardDTO dto = new BoardDTO();
			
			dto.setNum(Integer.parseInt(req.getParameter("num")));
			dto.setSubject(req.getParameter("subject"));
			dto.setName(req.getParameter("name"));
			dto.setEmail(req.getParameter("email"));
			dto.setPwd(req.getParameter("pwd"));
			dto.setContent(req.getParameter("content"));
			
			//수정된 데이터를 보낸다
			dao.updateData(dto);
			
			//되돌아올때
			String param = "pageNum=" + pageNum;
			
			if(searchValue != null&& !searchValue.equals("")) {
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
			}
			
			//업데이트 시켰으니 리다이렉트 해야함
			url = cp + "/sboard/list.do?" + param;
			resp.sendRedirect(url);
			
		}else if(uri.indexOf("deleted_ok.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			dao.deleteData(num);
			
			String param = "pageNum=" + pageNum;
			
			if(searchValue != null&& !searchValue.equals("")) {
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
			}
			
			url = cp + "/sboard/list.do?" + param;
			resp.sendRedirect(url);
			
		}
		
				
		
	}
	
	
}