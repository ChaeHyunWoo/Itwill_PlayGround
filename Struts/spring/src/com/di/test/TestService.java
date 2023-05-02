package com.di.test;

// applicationContext -> TestService(���濪��) -> TestImpl1, TestImpl2 ����
public class TestService {  
	
	//Dependency Injection(������ ����) 
	//XML���� TestService Ŭ������ �߰� �ٸ� ���ҷ� ���  
	//�������� �ּҷ� �Ѵ� 
	private Test test;  // �ʱ�ȭ ���� 
	
	//�⺻ ������ / 3.������Ƽ(�޼ҵ�)�� ������ ������ ���� 
	public TestService() {
		
	}
	
	//������ - �����ڷ� test �ʱ�ȭ
	//Dependency Injection (DI : ������ ����)
	public TestService(Test test) {
		this.test = test;
		
	}
	
	//3.������Ƽ(�޼ҵ�)�� ���� ������ ���� 
	public void setTest(Test test) {  //setter  (�޼���� void, ������Ƽ�� �޼���)
		this.test = test; 
	}
	

	public String getValue() {
		return test.result(); // Test�� ���� �޼��带 �ҷ��� �� 
	}
}