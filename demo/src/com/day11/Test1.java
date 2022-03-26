package com.day11;

class TestA {
	public void print() {
		System.out.println("A클래스...");
	}
}
//-----------------------------------------------------
class TestB {
	public void print() {
		System.out.println("B클래스...");
	}
}
//-----------------------------------------------------

public class Test1 {

	public static void main(String[] args) {
		
		TestA a = new TestA();
		TestB b;
		//데이터 타입이 달라서 안된다. 될려면 TestB를 TestA로 바꿔줘야함
		//b=a;
		//b=(TestB)a;

	}

}
