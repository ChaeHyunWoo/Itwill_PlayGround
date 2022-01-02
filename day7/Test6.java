package com.day7;

class RectA {//같은 패키지 내에 동일한 이름의 클래스 x
	
	//기본 생성자
	private int w, h;
	
	public RectA() {
		
		
	}
	
	//오버로딩 된 생성자
	public RectA(int w, int h) {	//오버로딩 된 생성자가 없을때는 기본 생성자는 생략가능한데
		this.w = w;					//오버로딩 된 생성자를 사용하면 기본 생성자 생략 못함
		this.h = h;
		
	}
	
	
	public void set(int w, int h) { 
		this.w = w;
		this.h = h;
	}
	
	
	public int area() {
		return w*h;//void가 없는 건 무조건 반환값을 받아야되어서 return해야되어요
				   //void가 있는 건 return값이 생략된거에요
	}

	
	
	
	public int length() {
		return (w+h)*2;
	}
	
	
	public void print(int a) { //메소드
		
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		System.out.println("면적 : " + a);
	}
		
	
	//메소드 오버로딩
	public void print(int a, int l) {
		
		System.out.println("가로 : " + w);
		System.out.println("세로 : " + h);
		System.out.println("면적 : " + a);
		System.out.println("둘레 : " + l);
	}
	
}
public class Test6 {

	public static void main(String[] args) {
		
		RectA ob1 = new RectA(); // 기본 생성자 호출
		ob1.set(10, 20);
		
		int a = ob1.area(); //반환값
		int l = ob1.length();
		ob1.print(a);
		ob1.print(a, l);
		
		System.out.println("-----------------------------------");
		
		RectA ob2 = new RectA(100, 200); // 오버로딩된 생성자를 통해 객체 생성 시 초기화 바로 진행
		a = ob2.area();
		l = ob2.length();
		ob2.print(a);
		ob2.print(a, l);
		
		
	}

}