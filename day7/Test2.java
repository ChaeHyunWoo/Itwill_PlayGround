package com.day7;

//1. static는 new를 사용하지 않아도 알아서 메모리로 올라간다.
//2. static는 객체가 100개가 생성되도 메모리 공간을 1개만 생성된다.

//Test2 클래스
public class Test2 {
	
	public static int a = 10; // 클래스변수 : static이 있는 변수
	
	//클래스변수 또는 클래스 메서드는 클래스가 로딩되는 순간 메모리 할당이 이루어지고,
	// [클래스이름.객체]를 통해 접근할 수 있다.
	// 즉, new를 통해 메모리 할당을 받지 않아도 사용 가능.
	
	private int b = 20; // 인스턴스변수(멤버변수,전역변수)
	// 인스턴스 변수 또는 인스턴스메서드는 new를 통해 메모리를 할당받아야만
	// 사용가능하고 다른 메서드에서는 접근 가능하지만 클래스 메서드에서는 접근 불가능
	
	// 인스턴스 메서드
	public void write() {
		
		System.out.println("class 변수 a : " + a);
		System.out.println("instance 변수 b : " + b);
	}
	
	// 클래스 메서드 - static이 붙으면 인스턴스메서드에서 클래스 메서드가 된다.
	public static void print() {
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("class 변수 a : " + a);//10
		System.out.println("class 변수 a : " + Test2.a); // 10 클래스 변수
		System.out.println("------------------------");
		//write();
		print(); // 10
		Test2.print(); // 10 클래스 메서드
		
		Test2 ob1 = new Test2(); // 객체생성. 다시 위로 가서 실행
		
		System.out.println("class변수 a : " + ob1.a); // 10
		System.out.println("instance변수 b : " + ob1.b); //20
		System.out.println("------------------------");
		
		//ob1.print();
		ob1.write();
		System.out.println("------------------------");
		
		Test2 ob2 = new Test2(); // 객체생성. 다시 위로 가서 실행
		ob2.a = 100;
		ob2.b = 200;
		ob2.write();
		System.out.println("------------------------");
		
		Test2 ob3 = new Test2(); // 객체생성. 다시 위로 가서 실행
		ob3.a = 1000;
		ob3.b = 2000;
		ob3.write();
		System.out.println("------------------------");
		
		ob1.write();
		ob2.write();
		ob3.write();
	}
}
/*
위에부터 아래로 내려오면서 읽어내는데 static는 생성과 동시에 메모리에 올라가서 실행 / static이 없는애들은
new를 만나야(객체생성) 실행되서 일단 패스하면서 쭉 내려가서 new를 만나서 객체 생성을 해준다. 그리고
다시 위로가서 static이 없는 애들을 실행해줌. static이 있는 애들은 이미 실행했으니 패스한다.
*/