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
	
	//�Խñ� �ۼ�(created)������
	public ActionForward created(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		
		return mapping.findForward("created"); 
	}
	
	//�Խñ� �ۼ��Ϸ� ��(created_ok)
	public ActionForward created_ok(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//DB ������ �����´�. �׷��� inserdate���� ȣ���� �� �ְ� �ȴ�.
		CommonDAO dao = CommonDAOImpl.getInstance();
				
		//Object�� �Ѿ���� �ٿ�ĳ����
		BoardForm f = (BoardForm)form;
				
		//boardTest_sqlMap.xml�� �ִ� board �ȿ� �ִ� maxNumȣ��
		int maxNum = dao.getIntValue("board.maxNum");
				
		f.setNum(maxNum + 1);
		f.setIpAddr(request.getRemoteAddr());
		
		//board.insertData : board���� insertDate�� ȣ�� / 
		//boardForm�� �Ű������� �޾ƿ;��ϴµ� ������ BoardForm�� f�� �־������� ���⿡ f�� ����.
		dao.insertData("board.insertData", f);
		
		
		return mapping.findForward("created_ok"); 
	}
	
	//�Խ��� ����Ʈ��ȸ ��(list)
	public ActionForward list(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		
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
		
		//�츮�� map�� ��Ƽ� �����͸� ������ ������ map�� ��������
		Map<String, Object> hMap = new HashMap<>();
		hMap.put("searchKey", searchKey);
		hMap.put("searchValue", searchValue);
		
		// �˻��� ������ ��ü ����
		//boardTest_sqlMap.xml�� �ִ� select�� id="dataCount"�� hmap �Ű������� �Բ� ����
		int dataCount = dao.getIntValue("board.dataCount", hMap);
		
		
		// ��ȭ�鿡 ǥ���� ������ ����
		int numPerPage = 5;
		int totalPage = myUtil.getPageCount(numPerPage, dataCount);

		if(currentPage>totalPage)
			currentPage = totalPage;
		
		//�����ͺ��̽����� ������ ���۰� ����ġ rnum
		int start = (currentPage-1)*numPerPage+1;
		int end = currentPage*numPerPage;
		
		hMap.put("start", start);
		hMap.put("end", end);
		//hMap���� 4���� �����Ͱ� ����(searchKey,searchValue,start,end)
		
		List<Object> lists =
				dao.getListData("board.listData", hMap);
		
		
		// ����Ʈ���� ��ġŰ ��ġ������ article �� �� ������ 
		String param = "";
		// null�� ��ã���������� ���� 2����
		if(searchValue!=null&&!searchValue.equals("")) {
			
			// �˻���������
			param = "searchKey=" + searchKey;
			param+= "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
		}
		
		// ������ �ּҸ� ��´�.	
		String listUrl = cp + "/boardTest.do?method=list";

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
		String articleUrl = cp + "/boardTest.do?method=article&pageNum=" + currentPage;
		
		
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
		
		CommonDAO dao = CommonDAOImpl.getInstance();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		// ���� ������
		if(searchValue != null) {
			
			searchValue = URLDecoder.decode(searchValue, "UTF-8");
		}else {
			searchKey = "subject";
			searchValue = "";
		}
		
		//�Խù���ȣ(�����̸Ӹ�Ű) ��ȸ�� ����
		dao.updateData("board.hitCountUpdate", num);
		
		
		// �ϳ��� ������ �о�´�
		// setAttribute("dto",dto);
		BoardForm dto = (BoardForm)dao.getReadData("board.readData", num);
		
		if(dto==null) {
			
			return mapping.findForward("list");
			
		}
		
		// ���μ� 
		// setAttribute("line",lineSu);
		int lineSu = dto.getContent().split("\n").length;
		
		dto.setContent(dto.getContent().replace("\n", "<br/>"));
		
		//������,������
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
		
		//�˻��� ������
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
		
		
		//������ �������� ����� �μ�
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
