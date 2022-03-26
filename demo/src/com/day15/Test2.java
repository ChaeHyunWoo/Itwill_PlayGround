package com.day15;
//Thread(스레드)- java.lang 패키지의 Runnable 인터페이스를 사용하여 스레드 만드는 방법 



//인터페이스 만들면 오버라이드 해줘야함
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
			
			//인터페이스에는 getName이 없다. 쓰레드에는 있지만
			System.out.println(name + ":" + i);
			i++;
			
			
			//스레드일때는 - sleep / 인터페이스(Runnable)일때는 Thread.sleep
			try {
				Thread.sleep(100); // 1000 = 1초
			} catch (Exception e) {
				
			}
		}
		
	}
	
}
public class Test2 {

	public static void main(String[] args) {
		
		System.out.println("main 시작...");
		
		//Runnable을 받은 스레드 객체 생성 방법
		//Runnable은 인터페이스타입이기에 구현 객체를 생성해서 대입해야함
		Thread t1 = new Thread(new MyThread2(100, "첫번째..."));
		Thread t2 = new Thread(new MyThread2(200, "두번째..."));
		
		t1.start();
		t2.start();
		
		System.out.println("main 종료...");
		//main은 진작에 끝났고 스레드가 끝나야 프로그램이 종료된다.
		
		/* 실행결과
		main 시작...
		main 종료...
		두번째...:0
		첫번째...:0
		두번째...:1
		첫번째...:1  */
			
	}

}