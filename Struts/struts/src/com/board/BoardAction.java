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

//DispatchAction :  if���� �޼ҵ������ ������̴�.
public class BoardAction extends DispatchAction{

	// ����� ����
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
		// 7���� �����͸� �Ѱ��ָ� ��
		dao.insertData(f);
		
		return mapping.findForward("save");
		
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAO(conn);
		
		String cp = request.getContextPath();
		MyUtil myUtil = new MyUtil();// ����¡ó��
		
		// ���� BoardServlet ������ list �κ� ������ 
		String pageNum = request.getParameter("pageNum");

		int currentPage = 1;

		if(pageNum!=null)
			currentPage = Integer.parseInt(pageNum);

		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		
		// ���ڵ��ؼ� �޴´�
		// null�� ã��
		
		// �˻�����������
		if(searchValue==null||searchValue.equals("")) {
			searchKey = "subject";
			searchValue = "";
			
		}else {
			// �˻��������� 
			if(request.getMethod().equalsIgnoreCase("GET")) {
				
				//���ڴ� ��Ų��.
				// ���� UTF-8�� ���ڵ�
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
		}
		
		// �˻��� ������ ��ü ����
		int dataCount = dao.getDataCount(searchKey, searchValue);
		
		
		// ��ȭ�鿡 ǥ���� ������ ����
		int numPerPage = 5;
		int totalPage = myUtil.getPageCount(numPerPage, dataCount);

		if(currentPage>totalPage)
			currentPage = totalPage;
		
		//�����ͺ��̽����� ������ ���۰� ����ġ rnum
		int start = (currentPage-1)*numPerPage+1;
		int end = currentPage*numPerPage;
		
		
		// �˻������� Ű�� ���� start end
		//�����ͺ��̽����� �ش��������� �����´�
		List<BoardForm> lists =
				dao.getLists(start, end, searchKey, searchValue);
		
		
		// ����Ʈ���� ��ġŰ ��ġ������ article �� �� ������ 
		String param = "";
		// null�� ��ã���������� ���� 2����
		if(searchValue!=null&&!searchValue.equals("")) {
			
			// �˻���������
			param = "searchKey=" + searchKey;
			param+= "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
		}
		
		// ������ �ּҸ� ��´�.	
		String listUrl = cp + "/board.do?method=list";

		if(!param.equals("")) {
			
			// ���̾ƴϸ� �˻��� �ߴ�.
			// myUtil �ڿ� �˻��� �ּҰ� ��������.
			// listUrl�� ?�� �����Ƿ� ���ΰ�
			listUrl += "&" + param;
		}

		String pageIndexList =
				myUtil.pageIndexList(currentPage, totalPage, listUrl);
		
		
		// ����Ʈ�� Ŭ�������� article�� �Ѿ�ºκ� 
		
		// �ۺ��� �ּҸ� �����.
		// �˻��� ���ߴٸ�
				
				
		// ������������ �Ѱ��ش� ( �ǵ��� �ü��ְ� )
		String articleUrl = cp + "/board.do?method=article&pageNum=" + currentPage;
		
		
		// �˻��� �ߴٸ� param ����
		// �ڿ� ���ϰŴϱ� &�� ���̴°��̴�.
		if(!param.equals("")) {
			
			
			// articleUrl �� ?�� �־ 	
			// ������������ �Ѱ��ش� ( �ǵ��� �ü��ְ� - Ű�� �� �˻��������� �ǵ��ƿü��ְ� )
			articleUrl += "&" + param;
		}

		//������ �������� ������ �ѱ��
		request.setAttribute("lists", lists);
		request.setAttribute("articleUrl", articleUrl);
		request.setAttribute("pageIndexList", pageIndexList);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPage", totalPage);
		
		// dataCount�� null�̾ƴҋ� pageIndexList�� ��������
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
		
		// ���� ������
		if(searchValue != null) {
			
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}
		
		//�Խù���ȣ(�����̸Ӹ�Ű) ��ȸ�� ����
		dao.updateHitCount(num);
		
		
		// �ϳ��� ������ �о�´�
		// setAttribute("dto",dto);
		BoardForm dto = dao.getReadData(num);
		
		if(dto==null) {
			
			return mapping.findForward("list");
			
		}
		
		// ���μ� 
		// setAttribute("line",lineSu);
		int lineSu = dto.getContent().split("\n").length;
		
		dto.setContent(dto.getContent().replace("\n", "<br/>"));
		
		// �ؿ� ���° �Խù����� 
		String param = "pageNum=" + pageNum;
		
		if(searchValue != null && !searchValue.equals("")) {
			
			//�˻��� �ߴٴ°�
			param += "&searchKey=" + searchKey;
			// ���ڴ� ���Ѽ� ������
			param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
			
		}
		
		// �Խù� ������ �����Ͱ� �������� ���ؼ� �����͸� �ѱ�(setAttribute)
		
		
		
		// ���� ������ �Ѿ�� ������ param�� ��������
		// param�� �̹� ���ο� ������ �����ִ�.
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
		
		// ������ư �������� �ּ�â���� �Ѿ�� ������ 
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
		
		//���� ������ �ѱ�
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
		
		
		//������ �����͸� ������
		dao.updateData(f);
		
		//�ǵ��ƿö�
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
