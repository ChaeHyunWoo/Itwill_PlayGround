package com.test3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MultiTestController extends MultiActionController {//�׼��� ���� �� �����ϴ� ��Ʈ�ѷ�
	
	
	public ModelAndView list(HttpServletRequest request, //�޼��� ������ �Ѿ
			HttpServletResponse response) throws Exception {
		
		request.setAttribute("message", "list ������");//���� �ϳ� ������
		
		
		return new ModelAndView("test3/testList");
				
	}
	
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setAttribute("message", "view ������");//���� �ϳ� ������
		
		
		return new ModelAndView("test3/testView");
				
	}

}
