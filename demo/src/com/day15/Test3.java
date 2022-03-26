package com.day15;
//���� �ý����� ��¥�� �ð��� 1�ʸ��� ����ϼ���.
import java.util.Calendar;

class MyThread3 implements Runnable {
	
	//Runnable���� run()�޼��� �ϳ��� ���ǵǾ� �ִµ�, ���� Ŭ������ run()�� ������(override)�ؼ�
	//�۾� �����尡 ������ �ڵ带 �ۼ��ؾ� ��
	@Override
	public void run() {
		
		while(true) {								//Calendar.getInstance()
							//1$ �ϳ����� ������� ..��pc����ð��� �����Ͷ�
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
		
		
		//Runnable�� �������̽�Ÿ���̱⿡ ���� ��ü�� �����ؼ� �����ؾ���
		Thread t = new Thread(new MyThread3());
		t.start();

	}

}
