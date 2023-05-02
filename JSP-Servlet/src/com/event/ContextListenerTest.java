package com.event;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListenerTest implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		
		System.out.println("서버 종료한다...");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		
		System.out.println("서버 시작한다...");
		
		ServletContext sc = evt.getServletContext();
		
		//el로 프로젝트 어디서든 접근 가능하다.(name을 쓰면)
		sc.setAttribute("name", "유인나");
		
	}
	
	

}
