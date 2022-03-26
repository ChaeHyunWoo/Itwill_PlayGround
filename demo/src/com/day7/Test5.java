package com.day7;
/* 생성자
 만드는 이유
 1. 객체 생성 2. 변수 초기화 목적
 메모리 할당을 받을 때 사용을 하고 생성자는 class의 이름과 동일함
 리턴값이 없기 때문에 property가 필요 없다.
 생성자는 중복정의(Overloading)이 가능
 생성자 안에서 생성자를 호출 가능
 단 호출 시 제일 선두에서만 호출 가능 ( 생성자는 기본적으로 생략되어 있다.)
 */
public class Test5 {
	
	// 인스턴스변수와 초기화 메서드는 세트라고 생각. 없으면 초기값 설정할 수 없음.
	private int x; //인스턴스 변수
	
	// 기본생성자 - Overoading할거아니면 생략 / 기본 생성자 특징 : 반환값 없음
	public Test5() {
		
		this(50); // = Test5(int x); -> 오버로딩된 생성자를 호출 ( 오버로딩된 생성자를 먼저 처리한다.)
		System.out.println("기본 생성자...");
		x = 10;//생성자를 통한 변수 초기화
		System.out.println("x : " + x);
		
	}
	
	//오버로딩된 생성자 - 필요에 의해 만듬
	public Test5(int x) {
		
		System.out.println("오버로딩된 생성자...");
		this.x = x;
		System.out.println("x : " + x);
	}

	public static void main(String[] args) {
		
		Test5 ob1 = new Test5();	//객체 생성. 다시 위로 가서 실행
		Test5 ob2 = new Test5(50);
	}

}