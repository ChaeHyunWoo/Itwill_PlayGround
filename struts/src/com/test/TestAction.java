package com.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TestAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, 
			ActionForm form, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		String uri = request.getRequestURI();
		
		if(uri.indexOf("/test_ok.do")!=-1) {
			
			//java�� �ѱ�°ű⶧���� �����ʹ� ������ object�� �Ѱܼ� �ٿ� ĳ����
			TestForm f = (TestForm)form;
			
			request.setAttribute("vo", f);
			
			return mapping.findForward("ok"); //�� ����Ǹ� ok��� ���ڸ� ������ ���ư���
			
		}
		
		return mapping.findForward("error"); // �߸� ����Ǹ� error��� ���ڸ� ������ ���ư���
		
		
		
		
		
		
	}
	
	

}
