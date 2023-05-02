package com.day15;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

//정해진 시간마다 특정 작업을 반복해서 실행할때



public class Test9 extends Thread {
	
	private int num;
	
	public Test9() {
		
		TimerTask task = new TimerTask() { // 무명의 클래스 - 한번만 실행한다
			
			@Override
			public void run() {
				
				//반복 실행할 작업
				num = 1;
			}
		};
		
		Timer t = new Timer();
		Calendar c = Calendar.getInstance();
		
		//내일 0시 0분0초부터 하루에 한번씩 반복
		/*
		c.add(Calendar.DATE, 1);
		c.set(Calendar.HOUR, 0); // 오후 1시는 13
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		t.schedule(task, c.getTime(), 1000 * 60 * 60 * 24); // 밀리세컨 * 초 * 분 * 시
		*/
		
		t.schedule(task, c.getTime(), 5000);
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			System.out.println(num++);
			
			try {
				sleep(1000); //1초마다 num을 1씩 증가시켜서 출력해라
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