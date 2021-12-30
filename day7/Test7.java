package com.day7;
//static이 가장먼저 실행되고 생성자가 가장 늦게 실행된다. 인스턴스변수는 new를 만나야 실행된다,
public class Test7 {
	
	int a = 5; // 인스턴스 변수
	
	{ // 초기화 블럭
		System.out.println("초기화 블럭 : a ->" + a); // 5
		a = 10;
		System.out.println("초기화 블럭 : a ->" + a);
	}
	
	static int b;
	static { // static 블럭
		b = 10;
		System.out.println("static 블럭 b : " + b);
	}
	//변수 : 변하는수
	//상수 : 항상 같은 수(만드는 순간에 초기화를 해줘야함)
	final int C;
	
	public Test7() {
		System.out.println("생성자...");
		C = 100;
		System.out.println("C : " + C);
	}
	
	public static void main(String[] args) {
		
		Test7 ob1 = new Test7();
		Test7 ob2 = new Test7();
		
	}

}
