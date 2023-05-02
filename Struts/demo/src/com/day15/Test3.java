package com.day15;
//현재 시스템의 날짜와 시간을 1초마다 출력하세요.
import java.util.Calendar;

class MyThread3 implements Runnable {
	
	//Runnable에는 run()메서드 하나가 정의되어 있는데, 구현 클래스는 run()을 재정의(override)해서
	//작업 스레드가 실행할 코드를 작성해야 함
	@Override
	public void run() {
		
		while(true) {								//Calendar.getInstance()
							//1$ 하나갖고 나눠써라 ..내pc현재시간을 가져와라
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
		
		
		//Runnable은 인터페이스타입이기에 구현 객체를 생성해서 대입해야함
		Thread t = new Thread(new MyThread3());
		t.start();

	}

}
