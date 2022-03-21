package com.di.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ResultMain {

	public static void main(String[] args) {
		
		
		// XML ������ ��üȭ �ϱ�
		String path = "com/di/test/applicationContext.xml"; // �ܼ� ��ΰ� �� -���ڸ� path �־��ְ�
		
		//���� ��θ� ã�ư�����. res�� xml ������ ��
		Resource res = new ClassPathResource(path); //xml�� ���� ������ ��
		
		
		//��üȭ - ���� ������� ������Ѽ� ��üȭ �Ϸ� (TestService�� �ϼ��ȴ�.)
		BeanFactory factory = new XmlBeanFactory(res); // ������� 3���� �۾��� �ؼ� ��üȭ �Ϸ�
		
		//�޸��Ҵ�� ��ü �ҷ����� - (��ü�����Ǹ� �޸� �Ҵ�ȴ�)
		TestService ob = (TestService)factory.getBean("testService"); //���丮�� ��üȭ�������� �ٿ�ĳ����
		System.out.println(ob.getValue());
		
		//�������� �������� ���̱� ���ؼ� �߰��� �Ű�ü(TestService)�� �޾Ƽ� TestService�� ������ ������ ������ �ϰ� ��
		
		
		/*//TestImpl1 ob1 = new TestImpl1();//�⺻������ ��ü����
		Test ob1 = new TestImpl1();
		System.out.println(ob1.result());
		
		TestImpl2 ob2 = new TestImpl2();
		System.out.println(ob2.result());*/
//---------------------------------------------------	
		//������ �Ʒ��� �ٲ� �� �ִ�.
		/*Test ob;
		
		ob = new TestImpl1();
		System.out.println(ob.result());
		
		ob = new TestImpl2();
		System.out.println(ob.result());
		������� java ��� */
		
		
		//�������� ��ü�� ������� applicationContext.xml�� �ʿ��ϴ�
		//���̷�Ʈ�� �������� �ʰ� �߰��� ������ġ�� ���񽺶�� ����Ѵ�.

	}

}
