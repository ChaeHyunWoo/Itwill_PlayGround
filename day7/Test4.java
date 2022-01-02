package com.day7;

class Rect { //전부 instance변수와 instance 메소드
	
	private int w, h;// 전역변수, 인스턴스 변수
	
	public void set(int w, int h) { // 전역변수와 매개변수의 이름이 같으면 혼란이 생겨 this를 사용
									// 우회해서 초기화.
		this.w = w;
		this.h = h;
	}
	
	
	public int area() {	//넓이	//인스턴스 메소드
		return w*h;
	}
	
	
	public int length() {	//둘레
		return (w+h)*2;
	}
	
	
	public void print(int a, double l) {
		
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		System.out.println("면적 : " + a);
		System.out.println("둘레 : " + l);
	}
	// 메소드 중복 정의(Overloading)
	// 하나의 클래스 안에서 비슷한 역할을하는 메소드의 이름을 
	// 통일시키는 기능으로 메소드의 이름은 동일하지만
	//괄호 속의 인수의 갯수나 인수의 자료형을 다르게 주면
	// 각각 다른 메소드로 인식을 한다.
	public void print() {
		
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
	}
	
	public void print(int a) {
		
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		System.out.println("면적 : " + a);
	}
	
	public void print(double l) {
		
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		System.out.println("둘레 : " + l);
		
	}
	
}



public class Test4 {
	
	public static void main(String[] args) {
		
		Rect ob = new Rect();
		
		ob.set(10, 20);
		
		int a = ob.area();
		double l = ob.length();
		
		ob.print();
		ob.print(l);
		ob.print(a);
		ob.print(a, l);
	}
}