package com.event;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//서브릿의 라이프사이클과 속성이벤트
//HTTPSessionListener : 세션이 생성 종료 될때 실행되는 리스너이다.
//ServletContextListener : 서버가 시작하거나 중지될 때 감시하는 리스너이다.

public class CountManager implements HttpSessionListener {
	
	private static CountManager CountManager;
	private static int count;
	
	public CountManager() {
		CountManager = this; //자기 자신을 넣는다.
	}
	
	public static synchronized CountManager getInstance() 
	throws Exception{
		
		if(CountManager==null) {
			CountManager = new CountManager();
		}
		
		return CountManager;
		
	}
	
	public static int getCount() {
		return count;
	}
	
	
	@Override
	public void sessionCreated(HttpSessionEvent evt) {
		
		//세션만듬
		HttpSession session = evt.getSession();
		session.setMaxInactiveInterval(10*60);
		
		count++;
		
		System.out.println(session.getId() + " : 세션생성, ");
		System.out.println("접속자수 : " + count);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent evt) {
		
		HttpSession session = evt.getSession();
		
		count--;
		
		System.out.println(session.getId() + " : 세션소멸, ");
		System.out.println("접속자수 : " + count);
		
	}
	

}
