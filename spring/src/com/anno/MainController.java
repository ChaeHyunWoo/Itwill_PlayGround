package com.anno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller를 쓰면 extends가 필요없고 스프링한테 적당한 컨트롤러를 가져오라고 맡긴다.
//<bean name="listFormController" class="com.test.ListFormController"/> 이런식으로 @Controller를 써서 알아서 객체생성

//혼자 프로젝트를 하면 상관없지만 협업할때 프로젝트를 합치면 각자 만든 컨트롤러가 충돌할 수도 있다.
// 그래서 @Controller("bbs.mainController")식으로 써줘서 충돌방지 (패키지방식으로 이름을써준다)

@Controller("main.mainController")
@RequestMapping(value="/main.action") //이 주소를 치면 MainController이 실행된다.
public class MainController {
	
	//MainController main.Controller = new MainController();
	//MainController mainController = new MainController();
	
	
	//사용자가 /main.action을 치면 MainController 메서드가 실행되는데
	//넘어온 방식이 GET이면 이 method()를 실행시킨다. 
	@RequestMapping(method=RequestMethod.GET)
	public String method() {
		
		return "/main"; // main.jsp로 가라 "/"생략가능
	}

}
