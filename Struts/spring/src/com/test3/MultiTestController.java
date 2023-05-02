package com.test3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MultiTestController extends MultiActionController {//액션을 여러 개 수행하는 컨트롤러
	
	
	public ModelAndView list(HttpServletRequest request, //메서드 단위로 넘어감
			HttpServletResponse response) throws Exception {
		
		request.setAttribute("message", "list 페이지");//문자 하나 넣은것
		
		
		return new ModelAndView("test3/testList");
				
	}
	
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setAttribute("message", "view 페이지");//문자 하나 넣은것
		
		
		return new ModelAndView("test3/testView");
				
	}

}
