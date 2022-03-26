package com.day15;

//인터럽트 : 우선순위가 높은 프로그램을 먼저 실행시키고 돌아옴 - 알고만 있기 쓸일이 거의 없음

class Mythread7 extends Thread {
	
	private Thread next;
	
	public void setNext(Thread next) {
		this.next = next;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<=20; i++) {
			
			try {
				sleep(2000);//2초 쉬고 찍는다
			} catch (Exception e) {
				
			}
			
			System.out.println(getName() + ":" + i);
			
			if(next.isAlive()) { //만약에 자기자신이 살아있으면 중지시켜라
				next.interrupt(); // 현재 스레드를 막음으로써 [다음 스레드를 깨움] - 현재스레드가 살아있으면 중지시킨다
			}
		}
	}
}

public class Test7 {
	
	public static void main(String[] args) {
		
		Mythread7 t1 = new Mythread7();
		Mythread7 t2 = new Mythread7();
		Mythread7 t3 = new Mythread7();
		
		t1.setNext(t2); //t1이 죽으면 t2실행
		t2.setNext(t3); // t2를 멈추고 t3를 실행해라
		t3.setNext(t1); // t3을 멈추고 t1을 실행해라
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.interrupt();//순서대로 실행되게끔 순서를 정해줄 수 있다.
		
		try {
			
			t1.join();
			t2.join();
			t3.join();
			
		} catch (Exception e) {
			
		}
		
	}

}