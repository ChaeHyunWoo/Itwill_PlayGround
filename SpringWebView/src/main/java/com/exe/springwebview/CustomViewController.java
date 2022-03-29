package com.exe.springwebview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomViewController {
	
	@RequestMapping(value = "/simpleCustomView.action")
	public ModelAndView custom() {
		
		ModelAndView mav = new ModelAndView();
		
		//mav.setViewName("simpleCustomView"); //jsp파일로 보냄
		
		//이제는 위의 방법말고 Class로 데이터를 넘길 것이다.
		mav.setView(new SimpleCustomView());
		mav.addObject("message","SimpleCustomView Class 입니다.");
		
		return mav;
	}

}
