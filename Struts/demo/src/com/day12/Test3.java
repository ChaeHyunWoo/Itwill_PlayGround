package com.day12;

//3. 내부클래스(중첩)
//static으로 클래스 만들기


class Outer3 {
	
	static int a = 10;
	int b = 20;
	
	public static class Inner3 { //static을 써서 클래스를 만들면 객체를 생성안해도 알아서 메모리에 올라간다.
		
		int c = 30;
		
		public void write() {
			
			System.out.println(a); // static in a =10 먼저 올라가있어서 실행가능
			//System.out.println(b); // b는 new를 만나야해서 오류
			System.out.println(c); // c는 new가없어도 static클래스라서 먼저 메모리에 올라가있어 실행가능
			
			Outer3 ob = new Outer3();
			System.out.println(ob.b);
		}
		
	}
	
	public void print() {
		System.out.println(b);
	}
	
}

public class Test3 {

	public static void main(String[] args) {
		
		Outer3 out = new Outer3();
		out.print();

	}

}