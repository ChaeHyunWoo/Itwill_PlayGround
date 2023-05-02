package com.day15;

//스레드 우선 순위 지정
//  => Thread객체.setPriority(int newPRIORITY)메소드를 이용
class MyThread4 extends Thread {
	
	private String name;
	
	public MyThread4(String name) {
		
		this.name = name;
	}
	
	@Override
	public void run() {
		
		for(int i=1; i<=20; i++) {
			System.out.println(name + ":" + i);
		}
	}
	
	
}

public class Test4 {
	
	public static void main(String[] args) {
		
		MyThread4 ob1 = new MyThread4("A");
		MyThread4 ob2 = new MyThread4("B");
		MyThread4 ob3 = new MyThread4("C");
		
		// 우선순위 종류(1~10)
		System.out.println("Min: " + Thread.MIN_PRIORITY); // 1
		System.out.println("Nor: " + Thread.NORM_PRIORITY); // 5  - (기본) 스레드는 기본으로 5를 갖게된다
		System.out.println("Max: " + Thread.MAX_PRIORITY); // 10
		
		//기본 스레드의 우선순위
		System.out.println(ob1.getPriority()); // 5
		System.out.println(ob2.getPriority()); // 5
		System.out.println(ob3.getPriority()); // 5
		
		//우선순위 변경
		ob1.setPriority(Thread.MIN_PRIORITY); // 1
		//ob1.setPriority(1); ->위의 코딩 MIN대신 1 써도 된다. 아래 코딩도 가능
		ob2.setPriority(Thread.NORM_PRIORITY); // 5
		ob3.setPriority(Thread.MAX_PRIORITY); // 10
		
		ob1.start();
		ob2.start();
		ob3.start();
		
	}
}