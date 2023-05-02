package com.event;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListenerTest implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		
		System.out.println("���� �����Ѵ�...");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		
		System.out.println("���� �����Ѵ�...");
		
		ServletContext sc = evt.getServletContext();
		
		//el�� ������Ʈ ��𼭵� ���� �����ϴ�.(name�� ����)
		sc.setAttribute("name", "���γ�");
		
	}
	
	

}
