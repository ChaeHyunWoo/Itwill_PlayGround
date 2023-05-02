package com.day15;
//���� ������ : �ٸ� �����忡 ������ �ִ� ������� �ٸ� �����尡 ����Ǹ� 
//				���󽺷��尡 ������� �ʴ��� ���μ����� ����ȴ�.

class MyThread5 implements Runnable {

	@Override
	public void run() {
		
		for(int i=1; i<=20; i++) {
			System.out.println(i);
			//1���� 20���� ��� �۾�
			//�������϶��� - sleep / �������̽�(Runnable)�϶��� Thread.sleep
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				
			}
		}
		
	}
	
}
public class Test5 {

	public static void main(String[] args) {
		
		System.out.println("main ����...");
		
		Thread t1 = new Thread(new MyThread5());
		Thread t2 = new Thread(new MyThread5());
		Thread t3 = new Thread(new MyThread5());
		
		//���� ������ : �ٸ� �����忡 ������ �ִ� ������� �ٸ� �����尡 ����Ǹ� 
		//				���󽺷��尡 ������� �ʴ��� ���μ����� ����ȴ�.
		
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);	//main�� ����Ǹ� �ٸ� �����嵵 ����ȴ� - �̰� ���� ������
		
		////////////////////////////////////////////////////////////////
		t1.start();
		t2.start();
		t3.start();
		
		//main ��� ���� �ϱ�
		try {
			Thread.sleep(1000); //main 1�� ����
		} catch (Exception e) {
			
		}
		//////////////////////////////////////////
		
		//���� �����尡 ������ ���� ��ٸ��ٰ� main ����
		try {
			t1.join(); // t1�� ���������� ��ٷ�
			t2.join();
			t3.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		////////////////////////////////////////////
		System.out.println("main ����...");
	}

}
