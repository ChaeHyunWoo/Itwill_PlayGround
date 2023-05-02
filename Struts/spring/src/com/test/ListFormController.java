package com.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//가장 기본적인 spring 컨트롤러이다.
public class ListFormController implements Controller {//Controller

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		
		//test/write 에서 값 전송하기 버튼 누르면 write_ok.action 찾아가라
		return new ModelAndView("test/write");//controller 역할 test/write로 찾아가라
	}
	
	

}
