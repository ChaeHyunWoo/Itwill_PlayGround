package com.exe.springdi3;

import org.springframework.context.support.GenericXmlApplicationContext;

//��������
public class MessageService {
	
	public void messageService() {
		
		//Web�� �����ʷ� ���� �ڵ����� xml�� ������ �ܼ��� ���д´�. �׷���
		//BeanFactory ����
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("app-context.xml");
		
		//Bean ��ü ��� - �ڹٰ� ��ü�� �������ٶ��� OBject�� �ٿ�ĳ����
		Message ms = (Message)context.getBean("message");
		
		ms.sayHello("�����");
		
	}

}
