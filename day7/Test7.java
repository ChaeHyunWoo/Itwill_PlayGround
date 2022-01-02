package com.day7;
//static이 가장먼저 실행되고 생성자가 가장 늦게 실행된다. 인스턴스변수는 new를 만나야 실행된다,
public class Test7 {
	
	int a = 5; // 인스턴스 변수
	
	{ // 초기화 블럭 - 메소드로 호출하진 않는데 형식은 갖춰야 함.
		System.out.println("초기화 블럭 : a ->" + a); // 5
		a = 10;
		System.out.println("초기화 블럭 : a ->" + a);
	}
	
	static int b; // 클래스변수. 메모리 할당되어 있음
	
	static { // static 블럭
		b = 10;
		System.out.println("static 블럭 b : " + b);
	}
	//변수 : 변하는수
	//상수 : 항상 같은 수(만드는 순간에 반드시 초기화를 해줘야함)
	final int C;	//상수는 대문자
	
	public Test7() {
		System.out.println("생성자...");
		C = 100;
		System.out.println("C : " + C);
	}
	
	public static void main(String[] args) {
		
		Test7 ob1 = new Test7(); //객체생성. static블록이 제일 먼저 생성된다.
		Test7 ob2 = new Test7(); // 객체 2개 생성 시 static은 객체를 여러 번 만들어도 한번만 만들어진다.
		
	}
}