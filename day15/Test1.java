package com.day15;
//Thread(스레드)- 클래스로 Thread를 만드는 방법

// 일반 클래스인데 이 클래스에 Thread의 기능을 넣어줄거다.
// Thread를 상속 받는다. 
class MyThread1 extends Thread { // 부모꺼는 내꺼다.(자식이 부모꺼 사용 가능)
	
	private int num;
	private String name;
	
	//생성자를 사용하여 초기화
	public MyThread1(int num, String name) {
		
		this.num = num;
		this.name = name;
	}
	
	
	//Thread는 반드시 run이 필요 - 오른쪽 누르고 소스 - 오버라이드 - run()선택
	
	@Override
	public void run() {	//(4) t1이 먼저 와서 스레드를 만듬(Thread-0)만듬. 99까지 찍고 (6) t2가 올라와서 스레드 만듬
		
		//스레드 메서드(java의 VM이 호출) - 무조건 호출하는 건아니고 start 명령어를 줘야함 star명령어는 main절에서 씀
		int i=0;
		
		while(i<num) {
			System.out.println(this.getName() + ":" + name + i); // getName : 스레드의 이름을 보여줌
			i++;
			
			
			// try catch를 써야 번갈아가면서 멀티태스팅을 함. 안쓰면 위의 주석 처럼 움직임.(t1끝나고 t2)
			// 스레드1이 0.01초 쉬는동안  스레드2가 실행된다.스레드2가 쉬는동안 스레드1 이 수행.
			try {
				sleep(100); // 0.01초 쉬어 라는 뜻 - 스레드는 sleep이 반드시 필요하다.필수!!!!!
				
			} catch (Exception e) {
				
			}
		}
		
		
	}
	
	
	
	
	
}


public class Test1 {
						//main절도 스레드다 - main스레드
	public static void main(String[] args) {
		
		System.out.println("main 시작...");// 실행순서 1
		
		MyThread1 t1 = new MyThread1(100, "첫번째 : ");// 실행순서 2
		MyThread1 t2 = new MyThread1(200, "두번째 : ");// 실행순서 2
		
		//스레드는 만들었다고 끝나는게 아니고 start를 해줘야함
		t1.start();// 실행순서3 위로 올라간다
		t2.start();// 실행순서5 위로 올라간다
		
		
		System.out.println("main 종료...");

	}

}
