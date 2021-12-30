package com.day7;

//생성자
//만드는 이유
// 1. 객체생성, 2. 변수 초기화 목적
//메모리 할당을 받을 때 사용을 하고 생성자는 class의 이름과 동일
//리턴값이 없기 때문에 property가 필요 없다.
//생성자는 중복정의(overloading)가 가능하다.
//생성자 안에서 생성자를 호출할 수 있다.
//단 호출 시 제일 선두에서만 호출 가능하다.// 생성자는 기본적으로 생략되어 있다.
public class Test5 {
	
	private int x;
	
	public Test5() {// 기본 생성자 // 생성자는 기본적으로 생략되어 있다.
		
		this(50); // = Test5(int x)
		System.out.println("기본 생성자...");
		x = 10;
		System.out.println("x : " + x);
	}
	
	public Test5(int x) {
		
		System.out.println("오버로딩된 생성자...");
		this.x = x;
		System.out.println("x : " + x);
	}
	
	public static void main(String[] args) {
		
		Test5 ob1 = new Test5();
		Test5 ob2 = new Test5(50);
		
	}

}
