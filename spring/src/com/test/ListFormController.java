package com.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//���� �⺻���� spring ��Ʈ�ѷ��̴�.
public class ListFormController implements Controller {//Controller

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		
		//test/write ���� �� �����ϱ� ��ư ������ write_ok.action ã�ư���
		return new ModelAndView("test/write");//controller ���� test/write�� ã�ư���
	}
	
	

}
