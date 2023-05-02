package com.exe.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("test.controller")
public class TestController {
	
	/*@RequestMapping(value="/test/param.action", method = RequestMethod.GET)
	public String processGetReqest() {
		
		System.out.println("GET 방식 Request");
		
		return "paramResult"; //paramResult.jsp
	}
	
	
	@RequestMapping(value="/test/param.action", method = RequestMethod.POST)
	public String processPostRequest() {
		
		System.out.println("POST 방식 Request");
		
		return "paramResult";
	}
	*/
	
	//위의 2개를 합치면
	@RequestMapping(value="/test/param.action", 
			method = {RequestMethod.POST,RequestMethod.GET})
	public String processRequest(PersonDTO dto, String name, HttpServletRequest request) {
		
		System.out.println("GET/POST방식 Request"); 
		
		System.out.println(name);
		System.out.println(request.getParameter("phone"));
		
		System.out.println(dto);
		System.out.println("dto.getName(): " + dto.getName());
		System.out.println("dto.getPhone(): " + dto.getPhone());
		System.out.println("dto.getEmail(): " + dto.getEmail());
		
		return "paramResult";
	}
	
	@RequestMapping(value="/test/mav.action", 
			method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mavRequest(PersonDTO dto) {
		
		//ModelAndView클래스를 사용하면 자동으로 데이터 가져온다,
		//dto로 받아온 데이터를 ModelAndView 방식으로 뿌린다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",dto);
		mav.setViewName("paramResult");
			
		return mav;
	}
	
	@RequestMapping(value="/test/redirect.action", 
			method = {RequestMethod.GET,RequestMethod.POST})
	public String mavRedirectRequest() {
		
		
		//return "redirect:/";//home으로 리다이렉트
		return "redirect:/hello.action";
	}
	
	
}
