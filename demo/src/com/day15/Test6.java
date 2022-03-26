package com.day15;

// ������ TTL(Time To Live)

class MyThread6 extends Thread {
	
	@Override  // runġ�� ��Ʈ�� �����̽�
	public void run() {
		
		try {
			System.out.println("������ ����...");
			
			System.out.println("�켱���� : " + getPriority());
			System.out.println("�������̸� : " + getName());
			
			//0.5�� ����
			sleep(100);
			
			//�켱���� ����
			setPriority(2);
			System.out.println("����� �켱���� : " + getPriority());
			
			System.out.println("������ ����...");
			
		} catch (Exception e) {
			
		}
	}
	
}

public class Test6 {

	public static void main(String[] args) {
		
		//main���ͼ� ���⼭���� ����!
		Thread t1 = Thread.currentThread(); // ���� ������(main)�� t1�� �־��
		Thread t2 = new MyThread6();
														
		System.out.println("���ν����� �켱���� : " + t1.getPriority()); // ��� ������� �⺻�� : 5
		System.out.println("���罺������ �̸� : " + t1.getName()); // main
		System.out.println("t2�������� �̸� : " + t2.getName()); // Thread-0
		
		System.out.println("t2.start() �޼��� ȣ�� ���� isAlive : " + t2.isAlive()); // t2�� ����ֳ� -> false ->start�� �ȳ��ͼ�
		
		t2.start();
		
		//t2�켱����
		System.out.println("t2 �켱���� : " + t2.getPriority());
		
		//t2�� �켱���� ����
		t2.setPriority(1); //�켱������ 5���� 1���� ����
		
		//�������϶��� - sleep / �������̽�(Runnable)�϶��� Thread.sleep
		try {
			
			//0.1��
			Thread.sleep(100); 
			
			//t2 ����Ȯ��
			System.out.println("t2 ����ֳ�? " + t2.isAlive());//true
			
			//1��
			Thread.sleep(1000);
			System.out.println("1�� sleep �� t2 ����ֳ�? " + t2.isAlive());//false
			
			t2.join();
			
			System.out.println("�׷��� ����ֳ�?" + t2.isAlive());//false
			
		} catch (Exception e) {
			
		}

	}

}