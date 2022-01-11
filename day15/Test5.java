package com.day15;
//데몬 스레드 : 다른 스레드에 도움을 주는 스레드로 다른 스레드가 종료되면 
//				데몬스레드가 종료되지 않더라도 프로세스가 종료된다.

class MyThread5 implements Runnable {

	@Override
	public void run() {
		
		for(int i=1; i<=20; i++) {
			System.out.println(i);
			//1부터 20까지 찍는 작업
			//스레드일때는 - sleep / 인터페이스(Runnable)일때는 Thread.sleep
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				
			}
		}
		
	}
	
}
public class Test5 {

	public static void main(String[] args) {
		
		System.out.println("main 시작...");
		
		Thread t1 = new Thread(new MyThread5());
		Thread t2 = new Thread(new MyThread5());
		Thread t3 = new Thread(new MyThread5());
		
		//데몬 스레드 : 다른 스레드에 도움을 주는 스레드로 다른 스레드가 종료되면 
		//				데몬스레드가 종료되지 않더라도 프로세스가 종료된다.
		
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);	//main이 종료되면 다른 스레드도 종료된다 - 이게 데몬 스레드
		
		////////////////////////////////////////////////////////////////
		t1.start();
		t2.start();
		t3.start();
		
		//main 잠깐 쉬게 하기
		try {
			Thread.sleep(1000); //main 1초 쉬기
		} catch (Exception e) {
			
		}
		//////////////////////////////////////////
		
		//위에 스레드가 끝날때 까지 기다리다가 main 종료
		try {
			t1.join(); // t1이 끝날때까지 기다려
			t2.join();
			t3.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		////////////////////////////////////////////
		System.out.println("main 종료...");
	}

}
