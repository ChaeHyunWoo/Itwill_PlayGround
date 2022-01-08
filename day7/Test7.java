package com.day7;
// static이 가장 먼저 실행되고 생성자가 가장 늦게 실행된다.  인스턴스변수는 new를 만나야 실행된다.
public class Test7 {
	
	int a = 5; // 인스턴스 변수 (멤버or전역 변수)
	
	//객체가 생성되면 바로 실행되는 instance 블럭
	{ // 초기화 블럭 -  메서드로 호출하지는 않는데 형식은 갖춰야 함. instance. 객체를 생성해야 볼 수 있음
		System.out.println("초기화 블럭 : a ->" + a); // 5
		a = 10;
		System.out.println("초기화 블럭:a ->" + a);
	}
	
	static int b; // 클래스변수. 메모리 할당이 되어 있음 
	
	static { // static 블럭
		b = 10;
		System.out.println("static 블럭b : " + b);
	}
	
	final int C; //상수는 대문자
	
	
	public Test7() {
		System.out.println("생성자...");
		C = 100;
		System.out.println("C : " + C);
	} // 이런 경우에 가장 마지막에 생성되는 것은 생성자
	
	
	public static void main(String[] args) {
		
		Test7 ob1 = new Test7(); // 객체생성 - static 블럭이 제일 먼저 생성된다.
		Test7 ob2 = new Test7(); // 객체 2개 생성 시 static은 객체를 여러번 만들어도 한번만 만들어짐 why? 메모리를 같이쓰니까

	}

}
