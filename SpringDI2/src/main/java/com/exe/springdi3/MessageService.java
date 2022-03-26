package com.exe.springdi3;

import org.springframework.context.support.GenericXmlApplicationContext;

//완충지대
public class MessageService {
	
	public void messageService() {
		
		//Web은 리스너로 통해 자동으로 xml을 읽지만 콘솔은 못읽는다. 그래서
		//BeanFactory 생성
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("app-context.xml");
		
		//Bean 객체 사용 - 자바가 객체를 생성해줄때는 OBject라서 다운캐스팅
		Message ms = (Message)context.getBean("message");
		
		ms.sayHello("배수지");
		
	}

}
