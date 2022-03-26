package com.day7;

class Rect { //전부 인스턴스변수와 인스턴스 메서드
	
	private int w, h; //인스턴스 변수(전역변수)
	
	//인스턴스 메서드
	public void set(int w, int h) { // 인스턴스 변수와 이름이 같으면 혼란이 생겨 this를 사용한다.
		
		//우회경로 - 우회해서 초기화
		this.w = w;
		this.h = h;
	}
	
	//인스턴스 메서드 - 넓이
	public int area() { 
		return w*h;
	}
	
	
	//인스턴스 메서드 - 둘레
	public int length() {
		return (w*h)*2;
	}
	
	//인스턴스 메서드 - 출력
	public void print(int a, double l) {
		
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		System.out.println("면적 : " + a);
		System.out.println("둘레 : " + l);
	}
	
	
	/*
	메서드 중복 정의(Overloading) - 오버로딩
	하나의 클래스 안에 비슷한 역할을 하는 메소드의 이름을 통일시키는 기능으로
	메서드의 이름은 동일하지만 괄호 속의 인수의 갯수나 인수의 자료형을 다르게 주면
	각각 다른 메서드로 인식한다.
	 */
	//오버로딩된 메서드
	public void print() {
		
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
	}
	//오버로딩된 메서드
	public void print(int a) {
		
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		System.out.println("면적 : " + a);
	}
	//오버로딩된 메서드
	public void print(double l) {
		
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		System.out.println("둘레 : " + l);
	}
}


public class Test4 {

	public static void main(String[] args) {	// main함수
		
		Rect ob = new Rect(); //객체생성. 다시 위로 가서 실행
		
		ob.set(10, 20); // w에 10, h에 20을 넣어준다.
		
		int a = ob.area(); //area의 값을 int a 에 넣는다
		double l = ob.length(); // length의 값을 double l 에 넣는다.
		
		ob.print();
		ob.print(l);
		ob.print(a);
		ob.print(a, l);

	}

}
