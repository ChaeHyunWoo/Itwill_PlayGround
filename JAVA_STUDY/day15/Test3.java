package com.day15;
//현재 시스템의 날짜와 시간을 1초마다 출력하세요.
import java.util.Calendar;

class MyThread3 implements Runnable {
	
	
	@Override
	public void run() {
		
		while(true) {
			
			System.out.printf("%1$tF %1$tT\n", Calendar.getInstance());
			//스레드일때는 - sleep / 인터페이스(Runnable)일때는 Thread.sleep
			try {
				Thread.sleep(1000); //1초
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
