package com.day10;

class  Test { //부모 클래스(Test)
	
	protected int a = 10, b = 20;
	
	public void write() { // 메서드  void있어서 반환값 필요없움
		
		System.out.println("Super Class write()...");
		System.out.println("a: " + a + ", b: " + b);
	}
}

class Demo extends Test { // 자식 클래스(Demo)
	
	protected int b = 30, c = 40;
	
	//부모의 메서드를 override하기
	@Override //오버라이드하면 무조건 무조건 내껄쓴다.
		public void write() { //override하는 순간 부모 write, 자식도 write를 갖고 있어 자식꺼를 먼저 쓴다.(내꺼부터 쓴다)
			System.out.println("Sub Class write()");
			System.out.println("a: " + a + ", b: " + b + ", c: " + c);
			System.out.println("super.b: " + super.b); // 20
		}
	
	public void print1() { // 메서드
		System.out.println("Sub Class print1()에서 write()호출...");
		write();
	}
	
	public void print2() { // 메서드
		System.out.println("Sub Class print1()에서 write()호출...");
		super.write(); // super를 써서 부모(Test)의 write()를 쓴다.
	}
}
public class Test5 {

	public static void main(String[] args) {
		
		Demo ob = new Demo();
		ob.write();
		ob.print1();
		ob.print2();
		
		System.out.println("ob.b : " + ob.b); //30 부모도 있고 나도 있으면 내꺼 쓴다.
		System.out.println("((Test)ob).b : " + ((Test)ob).b);
		System.out.println("=============================");
		((Test)ob).write();
	}

}
