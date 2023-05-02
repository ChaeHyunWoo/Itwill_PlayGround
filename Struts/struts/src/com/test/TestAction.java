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
			
			//java가 넘기는거기때문에 데이터는 무조건 object로 넘겨서 다운 캐스팅
			TestForm f = (TestForm)form;
			
			request.setAttribute("vo", f);
			
			return mapping.findForward("ok"); //잘 실행되면 ok라는 문자를 가지고 돌아가라
			
		}
		
		return mapping.findForward("error"); // 잘못 실행되면 error라는 문자를 가지고 돌아가라
		
		
		
		
		
		
	}
	
	

}
