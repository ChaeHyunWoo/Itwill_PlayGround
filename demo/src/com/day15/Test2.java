package com.day15;
//Thread(������)- java.lang ��Ű���� Runnable �������̽��� ����Ͽ� ������ ����� ��� 



//�������̽� ����� �������̵� �������
class MyThread2 implements Runnable {
	
	private int num;
	private String name;
	
	public MyThread2(int num, String name) {
		
		this.num = num;
		this.name = name;
	}

	@Override
	public void run() {
		
		int i=0;
		
		while(i<num) {
			
			//�������̽����� getName�� ����. �����忡�� ������
			System.out.println(name + ":" + i);
			i++;
			
			
			//�������϶��� - sleep / �������̽�(Runnable)�϶��� Thread.sleep
			try {
				Thread.sleep(100); // 1000 = 1��
			} catch (Exception e) {
				
			}
		}
		
	}
	
}
public class Test2 {

	public static void main(String[] args) {
		
		System.out.println("main ����...");
		
		//Runnable�� ���� ������ ��ü ���� ���
		//Runnable�� �������̽�Ÿ���̱⿡ ���� ��ü�� �����ؼ� �����ؾ���
		Thread t1 = new Thread(new MyThread2(100, "ù��°..."));
		Thread t2 = new Thread(new MyThread2(200, "�ι�°..."));
		
		t1.start();
		t2.start();
		
		System.out.println("main ����...");
		//main�� ���ۿ� ������ �����尡 ������ ���α׷��� ����ȴ�.
		
		/* ������
		main ����...
		main ����...
		�ι�°...:0
		ù��°...:0
		�ι�°...:1
		ù��°...:1  */
			
	}

}