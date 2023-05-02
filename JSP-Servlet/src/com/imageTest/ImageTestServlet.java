package com.imageTest;

import java.io.File;
import java.io.IOException;
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

public class ImageTestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void forward(HttpServletRequest req, HttpServletResponse resp,
			String url) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Connection conn = DBConn.getConnection();
		ImageTestDAO dao = new ImageTestDAO(conn);
		// 페이징
		MyUtil myUtil = new MyUtil();
		String cp = req.getContextPath();
		String uri = req.getRequestURI();
		String url;
		// 파일 업로드 위치 지정
		String root = getServletContext().getRealPath("/");
		String path = root + File.separator + "pds" + File.separator
				+ "imageFile";
		File f = new File(path);

		if (!f.exists()) {
			f.mkdirs();
		}

		if (uri.indexOf("write.do") != -1) {
			url = "/imageTest/write.jsp";
			forward(req, resp, url);

		} else if (uri.indexOf("write_ok.do") != -1) {

			String encType = "UTF-8";
			
			int maxSize = 10 * 1024 * 1024;
			// 파일 업로드
			MultipartRequest mr = new MultipartRequest(req, path, maxSize,
					encType, new DefaultFileRenamePolicy());

			// DB에 파일정보 입력
			// 업로드한 파일로부터 정보 추출
			if (mr.getFile("uploadFile") != null) {// null이 아니면 파일이 제대로 업로드된것
				ImageTestDTO dto = new ImageTestDTO();
				int maxNum = dao.getMaxNum();
				dto.setNum(maxNum + 1);
				dto.setSubject(mr.getParameter("subject"));
				dto.setSaveFileName(mr.getFilesystemName("uploadFile"));
				dao.insertData(dto);
			}

			// list.do 페이지로 리다이렉트
			url = cp + "/image/list.do";
			resp.sendRedirect(url);

		} else if (uri.indexOf("list.do") != -1) {

			String pageNum = req.getParameter("pageNum");
			int currentPage = 1; // 처음 띄우는 리스트 페이지

			if (pageNum != null) {
				currentPage = Integer.parseInt(pageNum);
			}

			int dataCount = dao.getDataCount();
			int numPerPage = 9;
			int totalPage = myUtil.getPageCount(numPerPage, dataCount);

			if (currentPage > totalPage)
				currentPage = totalPage;

			int start = (currentPage - 1) * numPerPage + 1;
			int end = currentPage * numPerPage;

			String listUrl = cp + "/image/list.do";
			List<ImageTestDTO> lists = dao.getList(start, end);
			String pageIndexList = myUtil.pageIndexList(currentPage, totalPage,
					listUrl);

			// 삭제경로
			String deletePath = cp + "/image/delete.do";
			// 이미지파일경로
			String imagePath = cp + "/pds/imageFile";
			req.setAttribute("imagePath", imagePath);
			
			int totalArticle = dao.getDataCount();

			// 파일정보 테이블을 리스트로 전달
			req.setAttribute("lists", lists);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("currentPage", currentPage);
			req.setAttribute("deletePath", deletePath);
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("totalArticle", totalArticle);
			req.setAttribute("totalPage", totalPage);
			
			// list.jsp 페이지로 포워드
			url = "/imageTest/list.jsp";
			forward(req, resp, url);

		} else if (uri.indexOf("delete.do") != -1) {

			int num = Integer.parseInt(req.getParameter("num"));
			int pageNum = Integer.parseInt(req.getParameter("pageNum"));
			//int currentPage = Integer.parseInt(req.getParameter("currentPage"));
			
			ImageTestDTO dto = dao.getReadData(num);

			// 물리적 파일 삭제
			FileManager.doFileDelete(dto.getSaveFileName(), path);

			// 테이블 정보 삭제
			dao.deleteData(num);

			// 삭제 진행 후 리스트 페이지로 리다이렉트
			url = cp + "/image/list.do?pageNum=" + pageNum;
			resp.sendRedirect(url);
		}
	}
}