package com.day15;

// 스레드 TTL(Time To Live)

class MyThread6 extends Thread {
	
	@Override  // run치고 컨트롤 스페이스
	public void run() {
		
		try {
			System.out.println("스레드 시작...");
			
			System.out.println("우선순위 : " + getPriority());
			System.out.println("스레드이름 : " + getName());
			
			//0.5초 쉬기
			sleep(100);
			
			//우선순위 변경
			setPriority(2);
			System.out.println("변경된 우선순위 : " + getPriority());
			
			System.out.println("스레드 종료...");
			
		} catch (Exception e) {
			
		}
	}
	
}

public class Test6 {

	public static void main(String[] args) {
		
		//main들어와서 여기서부터 시작!
		Thread t1 = Thread.currentThread(); // 현재 스레드(main)을 t1에 넣어라
		Thread t2 = new MyThread6();
														
		System.out.println("메인스레드 우선순위 : " + t1.getPriority()); // 모든 스레드는 기본값 : 5
		System.out.println("현재스레드의 이름 : " + t1.getName()); // main
		System.out.println("t2스레드의 이름 : " + t2.getName()); // Thread-0
		
		System.out.println("t2.start() 메서드 호출 전의 isAlive : " + t2.isAlive()); // t2가 살아있냐 -> false ->start가 안나와서
		
		t2.start();
		
		//t2우선순위
		System.out.println("t2 우선순위 : " + t2.getPriority());
		
		//t2의 우선순위 변경
		t2.setPriority(1); //우선순위를 5에서 1으로 변경
		
		//스레드일때는 - sleep / 인터페이스(Runnable)일때는 Thread.sleep
		try {
			
			//0.1초
			Thread.sleep(100); 
			
			//t2 종료확인
			System.out.println("t2 살아있냐? " + t2.isAlive());//true
			
			//1초
			Thread.sleep(1000);
			System.out.println("1초 sleep 후 t2 살아있냐? " + t2.isAlive());//false
			
			t2.join();
			
			System.out.println("그래도 살아있냐?" + t2.isAlive());//false
			
		} catch (Exception e) {
			
		}

	}

}