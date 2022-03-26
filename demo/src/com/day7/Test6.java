package com.day7;

class RectA {
	
	private int w, h; // 인스턴스변수(전역변수)
	
	// private 변수 초기화 방법은 2가지. -> 초기화메서드 이용, 생성자 이용
	
	//기본 생성자
	public RectA() { }
	
	//Overoading된 생성자
	public RectA(int w, int h) {	//오버로딩된 생성자가 없을때는 기본 생성자 생략가능하지만 있으면 생략 못함
		
		this.w = w;
		this.h = h;
	}
	
	//초기화 메서드
	public void set(int w, int h) {
		
		this.w = w;
		this.h = h;
	}
	
	//인스턴스 메서드
	public int area() {
		return w*h;
	}
	
	public int length() {
		return (w*h)*2;
	}
	//메서드
	public void print(int a) { 
		
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		System.out.println("면적 : " + a);
	}
		
	
	//메서드 오버로딩
	public void print(int a, int l) {
		
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		System.out.println("면적 : " + a);
		System.out.println("둘레 : " + l);
			}
	}
	public class Test6 {

	public static void main(String[] args) {
		
		RectA ob1 = new RectA(); // 기본생성자 + 초기화메서드 사용 -> 기본 생성자 호출 다시 위로가서 실행
		ob1.set(10, 20);
		
		int a = ob1.area(); //반환값 200
		int l = ob1.length(); //반환값 400
		ob1.print(a);
		ob1.print(a, l);
		
		System.out.println("-----------------------------------");
		
		RectA ob2 = new RectA(100, 200); // 오버로딩된 생성자를 통해 객체 생성 시 초기화 바로 진행 ->Spring에서는 '의존성 주입'이라 함
		
		a = ob2.area();
		l = ob2.length();
		ob2.print(a);
		ob2.print(a, l);
		
	}
}