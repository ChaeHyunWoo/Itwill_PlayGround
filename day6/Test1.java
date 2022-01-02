package com.day6;
//하나의 파일에 2개이상의 public클래스를 만들면 오류뜸. 그래서 public 클래스는 1개만 생성 가능.
//main절이 있는 클래스에만 public가 들어가고 나머지 클래스에는 class만 정의


class SubClass { //int값 2개를 저장할 수 있는 클래스.
	
	int a, b; //instance변수(전역변수)
	
}

public class Test1 { 

	public static void main(String[] args) {
		
		SubClass ob1 = new SubClass(); // new로 객체를 생성한 전역변수는 초기값이 들어있다.
		SubClass ob2 = new SubClass();
		
		// 인스턴스변수는 반드시 메모리를 다른곳에 저장
		
		
		System.out.println("ob1.a: " + ob1.a);	//0
		System.out.println("ob1.b: " + ob1.b);	//0
		
		ob1.a = 10;
		ob1.b = 20;
		System.out.println("ob1.a: " + ob1.a);	//10
		System.out.println("ob1.b: " + ob1.b);	//20
		
		
		System.out.println("ob2.a: " + ob2.a);	//0
		System.out.println("ob2.b: " + ob2.b);	//0
		
		
		ob2.a = 100;
		ob2.b = 200;
		System.out.println("ob2.a: " + ob2.a);	//100
		System.out.println("ob2.b: " + ob2.b);	//200
		
		System.out.println("ob1.a: " + ob1.a);	//10
		System.out.println("ob1.b: " + ob1.b);	//20	
		
		// 메모리공간은 모두 각자 따로 쓴다.
	}
}