package com.event;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//���긴�� ����������Ŭ�� �Ӽ��̺�Ʈ
//HTTPSessionListener : ������ ���� ���� �ɶ� ����Ǵ� �������̴�.
//ServletContextListener : ������ �����ϰų� ������ �� �����ϴ� �������̴�.

public class CountManager implements HttpSessionListener {
	
	private static CountManager CountManager;
	private static int count;
	
	public CountManager() {
		CountManager = this; //�ڱ� �ڽ��� �ִ´�.
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
		
		//���Ǹ���
		HttpSession session = evt.getSession();
		session.setMaxInactiveInterval(10*60);
		
		count++;
		
		System.out.println(session.getId() + " : ���ǻ���, ");
		System.out.println("�����ڼ� : " + count);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent evt) {
		
		HttpSession session = evt.getSession();
		
		count--;
		
		System.out.println(session.getId() + " : ���ǼҸ�, ");
		System.out.println("�����ڼ� : " + count);
		
	}
	

}
