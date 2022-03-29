package com.exe.springwebview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomViewController {
	
	@RequestMapping(value = "/simpleCustomView.action")
	public ModelAndView custom() {
		
		ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("simpleCustomView"); //jsp���Ϸ� ����
		
		//������ ���� ������� Class�� �����͸� �ѱ� ���̴�.
		mav.setView(new SimpleCustomView());
		mav.addObject("message","SimpleCustomView Class �Դϴ�.");
		
		return mav;
	}

}
