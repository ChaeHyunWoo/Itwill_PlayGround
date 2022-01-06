package com.day12;
//Test1~3은 뭔지만 보기 자주사용안하고 Test4는 자주 사용함 - 크게 1~3은 크게 중요 x
/*
 1. 내부클래스(Inner) - 클래스 안에 클래스가 들어감
방법 :클래스안에 클래스 / 메소드안에 클래스/ 클래스를 static으로 만든다 / 무명의 클래스
*/

class Outer1 { // Outer1클래스 안에 Inner1클래스가 들어감
	
	static int a = 10;//클래스 변수
	int b = 20; // instance변수(매개변수)
	
	public class Inner1 {// Outer1클래스 안에 Inner1클래스가 들어감
		
		int c = 30;
		
		public void write() { // Inner클래스 메서드
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
	}
	
	public void print() { // Outer1 클래스 메서드
		
		Inner1 ob = new Inner1(); //객체 생성
		ob.write();
	}
}
public class Test1 {

	public static void main(String[] args) {
		
		Outer1 out = new Outer1();//Outer 객체만들기 -  외부클래스 객체가 먼저 생성되야함
		out.print();
		
		Outer1.Inner1 in = out.new Inner1();
		in.write();

	}

}