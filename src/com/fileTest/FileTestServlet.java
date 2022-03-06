package com.fileTest;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.DBConn;
import com.util.FileManager;
import com.util.MyUtil;


// 파일은 삭제 추가 밖에 없다

public class FileTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}
	
	protected void forward(HttpServletRequest req, HttpServletResponse resp,String url) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String cp = req.getContextPath();
		Connection conn = DBConn.getConnection();
		
		FileTestDAO dao = new FileTestDAO(conn);

		MyUtil myUtil = new MyUtil();
		
		String uri = req.getRequestURI();
		String url;
		
		// 파일 저장 경로
		String root = getServletContext().getRealPath("/"); // 글로벌
		String path = root + "pds" + File.separator + "saveFile";
		
		
		File f = new File(path); // 경로를 넘겨줌	
		if(!f.exists()) {
			f.mkdirs();
		}
		if(uri.indexOf("write.do")!=-1) {
			url = "/fileTest/write.jsp";
			forward(req, resp, url);
		
		} else if(uri.indexOf("write_ok.do")!=-1) {
			// 파일을 업로드 시키고 파일의 정보를 가져와서 db에 넣는다
			
			// 파일 업로드 작업
			String encType = "UTF-8";
			int maxSize = 10 * 1024 * 1024;
			
			MultipartRequest mr = 
					new MultipartRequest(req, path, maxSize, encType,
							new DefaultFileRenamePolicy());
			
			// 파일 정보 db에 저장
			// 파일 업로드가 실행이 안되면 이부분을 안해도됨
			// file/test3.jsp 내용
			if(mr.getFile("upload")!=null) {
				
				FileTestDTO  dto = new FileTestDTO();
				int maxNum = dao.getMaxNum(); // 최대값읽어옴
				
				dto.setNum(maxNum + 1);
				dto.setSubject(mr.getParameter("subject"));
				dto.setSaveFileName(mr.getFilesystemName("upload"));
				dto.setOriginalFileName(mr.getOriginalFileName("upload"));
			
				dao.insertData(dto);
			}
			// 리스트한테 넘기면 됨
			url = cp + "/file/list.do";
			resp.sendRedirect(url);
			
		} else if(uri.indexOf("list.do")!=-1) {
			
			String pageNum = req.getParameter("pageNum");
			
			int currentPage = 1;
			if(pageNum!=null) // pageNum이있으면 현재 페이지로 설정 
				currentPage = Integer.parseInt(pageNum);
			
			int dataCount = dao.getDataCount();
			int numPerPage = 5;
			int totalPage = myUtil.getPageCount(numPerPage,dataCount);
			
			int start = (currentPage-1)*numPerPage+1;//(2-1)*5+1=6(rnum)
			int end = currentPage*numPerPage; // 2 * 5 = 10(rnum)
			
			String listUrl = cp + "/file/list.do";
			
			// 전체 데이터를 가져오면 됨
			// lists는 사용자가 입력한 데이터가 나오게됨
			//List<FileTestDTO> lists = dao.getLists();

			start = (currentPage-1) * numPerPage + 1;
			end = currentPage * numPerPage;
			
			List<FileTestDTO> lists = dao.getLists(start,end); 	
			
			// article처럼 간단한 주소를 하나 만듬
			String deletePath = cp + "/file/delete.do";
			String downloadPath = cp + "/file/download.do";
			String imagePath = cp + "/pds/saveFile"; //이미지는 실제 주소를 써줘야함

			String pageIndexList =
					myUtil.pageIndexList(currentPage, totalPage, listUrl);
			
			
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("dataCount", dataCount);
			
			
			// lists는 list.jsp로 포워딩되서 넘어감
			req.setAttribute("lists", lists);
			req.setAttribute("deletePath", deletePath);
			req.setAttribute("downloadPath", downloadPath);
			req.setAttribute("imagePath", imagePath);
			
			url = "/fileTest/list.jsp";
			forward(req, resp, url);
			
			
		// 파일삭제 db삭제 둘다 해야함	
		} else if(uri.indexOf("delete.do")!=-1) {
			
			// num 넘어옴
			int num = Integer.parseInt(req.getParameter("num"));
			
			FileTestDTO dto = dao.getReadData(num); // 하나의 데이터를 넘겨줌
			
			// 파일삭제(Myutil 에 doFileDelete 에 파일이름과 path를 넘겨주면 됨
			// 파일 매니저 있는걸 실행한다.
			// String path = root + "pds" + File.separator + "saveFile";
			FileManager.doFileDelete(dto.getSaveFileName(), path);
			
			// DB삭제 
			dao.deleteData(num);
			
			// 삭제를 했으니 리다이렉트 해줘야함 
			url = cp + "/file/list.do";
			resp.sendRedirect(url);
			
		} else if(uri.indexOf("download.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			
			FileTestDTO dto = dao.getReadData(num); // 하나의 데이터를 넘겨줌
			
			//한번 검증해줌( 안써도됨 큰 의미x)
			if(dto==null)
				return;
			
			boolean flag = 
					FileManager.doFileDounload(resp, 
							dto.getSaveFileName(), dto.getOriginalFileName(), path);
			
			
			if(flag==false) {
				
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				
				out.print("<script type='text/javascript'>");
				out.print("alert('Download Error!!');");
				out.print("history.back();");
				out.print("</script>");
				
				
				
			}
			
		}
	}
}
