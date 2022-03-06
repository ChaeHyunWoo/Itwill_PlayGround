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


// ������ ���� �߰� �ۿ� ����

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
		
		// ���� ���� ���
		String root = getServletContext().getRealPath("/"); // �۷ι�
		String path = root + "pds" + File.separator + "saveFile";
		
		
		File f = new File(path); // ��θ� �Ѱ���	
		if(!f.exists()) {
			f.mkdirs();
		}
		if(uri.indexOf("write.do")!=-1) {
			url = "/fileTest/write.jsp";
			forward(req, resp, url);
		
		} else if(uri.indexOf("write_ok.do")!=-1) {
			// ������ ���ε� ��Ű�� ������ ������ �����ͼ� db�� �ִ´�
			
			// ���� ���ε� �۾�
			String encType = "UTF-8";
			int maxSize = 10 * 1024 * 1024;
			
			MultipartRequest mr = 
					new MultipartRequest(req, path, maxSize, encType,
							new DefaultFileRenamePolicy());
			
			// ���� ���� db�� ����
			// ���� ���ε尡 ������ �ȵǸ� �̺κ��� ���ص���
			// file/test3.jsp ����
			if(mr.getFile("upload")!=null) {
				
				FileTestDTO  dto = new FileTestDTO();
				int maxNum = dao.getMaxNum(); // �ִ밪�о��
				
				dto.setNum(maxNum + 1);
				dto.setSubject(mr.getParameter("subject"));
				dto.setSaveFileName(mr.getFilesystemName("upload"));
				dto.setOriginalFileName(mr.getOriginalFileName("upload"));
			
				dao.insertData(dto);
			}
			// ����Ʈ���� �ѱ�� ��
			url = cp + "/file/list.do";
			resp.sendRedirect(url);
			
		} else if(uri.indexOf("list.do")!=-1) {
			
			String pageNum = req.getParameter("pageNum");
			
			int currentPage = 1;
			if(pageNum!=null) // pageNum�������� ���� �������� ���� 
				currentPage = Integer.parseInt(pageNum);
			
			int dataCount = dao.getDataCount();
			int numPerPage = 5;
			int totalPage = myUtil.getPageCount(numPerPage,dataCount);
			
			int start = (currentPage-1)*numPerPage+1;//(2-1)*5+1=6(rnum)
			int end = currentPage*numPerPage; // 2 * 5 = 10(rnum)
			
			String listUrl = cp + "/file/list.do";
			
			// ��ü �����͸� �������� ��
			// lists�� ����ڰ� �Է��� �����Ͱ� �����Ե�
			//List<FileTestDTO> lists = dao.getLists();

			start = (currentPage-1) * numPerPage + 1;
			end = currentPage * numPerPage;
			
			List<FileTestDTO> lists = dao.getLists(start,end); 	
			
			// articleó�� ������ �ּҸ� �ϳ� ����
			String deletePath = cp + "/file/delete.do";
			String downloadPath = cp + "/file/download.do";
			String imagePath = cp + "/pds/saveFile"; //�̹����� ���� �ּҸ� �������

			String pageIndexList =
					myUtil.pageIndexList(currentPage, totalPage, listUrl);
			
			
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("dataCount", dataCount);
			
			
			// lists�� list.jsp�� �������Ǽ� �Ѿ
			req.setAttribute("lists", lists);
			req.setAttribute("deletePath", deletePath);
			req.setAttribute("downloadPath", downloadPath);
			req.setAttribute("imagePath", imagePath);
			
			url = "/fileTest/list.jsp";
			forward(req, resp, url);
			
			
		// ���ϻ��� db���� �Ѵ� �ؾ���	
		} else if(uri.indexOf("delete.do")!=-1) {
			
			// num �Ѿ��
			int num = Integer.parseInt(req.getParameter("num"));
			
			FileTestDTO dto = dao.getReadData(num); // �ϳ��� �����͸� �Ѱ���
			
			// ���ϻ���(Myutil �� doFileDelete �� �����̸��� path�� �Ѱ��ָ� ��
			// ���� �Ŵ��� �ִ°� �����Ѵ�.
			// String path = root + "pds" + File.separator + "saveFile";
			FileManager.doFileDelete(dto.getSaveFileName(), path);
			
			// DB���� 
			dao.deleteData(num);
			
			// ������ ������ �����̷�Ʈ ������� 
			url = cp + "/file/list.do";
			resp.sendRedirect(url);
			
		} else if(uri.indexOf("download.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			
			FileTestDTO dto = dao.getReadData(num); // �ϳ��� �����͸� �Ѱ���
			
			//�ѹ� ��������( �Ƚᵵ�� ū �ǹ�x)
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
