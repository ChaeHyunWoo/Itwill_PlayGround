package com.day15;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

//������ �ð����� Ư�� �۾��� �ݺ��ؼ� �����Ҷ�



public class Test9 extends Thread {
	
	private int num;
	
	public Test9() {
		
		TimerTask task = new TimerTask() { // ������ Ŭ���� - �ѹ��� �����Ѵ�
			
			@Override
			public void run() {
				
				//�ݺ� ������ �۾�
				num = 1;
			}
		};
		
		Timer t = new Timer();
		Calendar c = Calendar.getInstance();
		
		//���� 0�� 0��0�ʺ��� �Ϸ翡 �ѹ��� �ݺ�
		/*
		c.add(Calendar.DATE, 1);
		c.set(Calendar.HOUR, 0); // ���� 1�ô� 13
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		t.schedule(task, c.getTime(), 1000 * 60 * 60 * 24); // �и����� * �� * �� * ��
		*/
		
		t.schedule(task, c.getTime(), 5000);
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			System.out.println(num++);
			
			try {
				sleep(1000); //1�ʸ��� num�� 1�� �������Ѽ� ����ض�
			} catch (Exception e) {
				
			}
		}
	}

	public static void main(String[] args) {
		
		//Test9 ob = new Test9();
		//ob.start();
		
		new Test9().start();
		
	}

}