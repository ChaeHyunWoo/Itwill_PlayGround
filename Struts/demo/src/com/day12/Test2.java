package com.day12;

// 2. 내부클래스(Local)
// 메소드 안에 클래스

class Outer2 { // Outer2클래스
	
	static int a = 10; 
	int b = 20;
	
	public void write() { // write메소드
		
		int c = 30;	//지역변수
		final int d = 40;
		
		class Inner2 {  // 메소드 안에 있는 Inner2클래스
				
			public void print() {
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				System.out.println(d);
			}
			
		}
		
		Inner2 ob = new Inner2(); // 메소드 안에서만 객체생성 가능
		ob.print();
	}
}
public class Test2 {
	//메소드 안에있는 클래스는 메소드 안에서만 객체생성이 가능하다.
	public static void main(String[] args) {
		
		Outer2 out = new Outer2();
		out.write();

	}

}
