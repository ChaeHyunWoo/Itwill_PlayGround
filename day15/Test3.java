package com.day15;
//���� �ý����� ��¥�� �ð��� 1�ʸ��� ����ϼ���.
import java.util.Calendar;

class MyThread3 implements Runnable {
	
	
	@Override
	public void run() {
		
		while(true) {
			
			System.out.printf("%1$tF %1$tT\n", Calendar.getInstance());
			//�������϶��� - sleep / �������̽�(Runnable)�϶��� Thread.sleep
			try {
				Thread.sleep(1000); //1��
			} catch (Exception e) {
				
			}
		
		}
	}
	
}
public class Test3 {

	public static void main(String[] args) {
		
		
		
		Thread t = new Thread(new MyThread3());
		t.start();

	}

}
