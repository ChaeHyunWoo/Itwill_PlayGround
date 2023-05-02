package com.day9;
	//java에서 모든 클래스(class) + 내가만든 클래스의 부모(조상)는 오브젝트다(Object)
	// Object는 가장 큰 자료형. 오브젝트 메소드에서  equals랑 toString 메소드 기억하기

	class TestA { //내가 만든 클래스라 부모가 없어보일 수 있지만 기본적으로 조상은 Object이다.
				  // class TestA extends Object { 이렇게 써도 오류 안뜸
		private int a = 10;
		
		public void write() {
			System.out.println("a" + a);
		}
	}
	
	
public class Test2 {
	
	public static void main(String[] args) {
		
		TestA ob1 = new TestA();
		TestA ob2 = new TestA();
		
		System.out.println("ob1 == ob2:" + (ob1 == ob2)); //false가 나옴
		//why? 똑같은 클래스로 객체를 생성했지만 ob1에 들어있는 주소와 ob2에 들어있는 주소가 다르기 때문.
		
		System.out.println("ob.equals(ob2):" + ob1.equals(ob2)); // false가 나옴
		//equals는 Object의 메소드인데 TestA의 부모는 Object라서 사용가능
		
		System.out.println("ob1 : " + ob1);//주소//ob1 : com.day9.TestA@7852e922   -> @뒤에 숫자는 해쉬코드(hashcode)
		System.out.println("ob2 : " + ob2);//주소//ob2 : com.day9.TestA@4e25154f   -> @뒤에 숫자는 해쉬코드(hashcode)
		System.out.println("ob1.toString(): " + ob1.toString());//주소//ob1.toString(): com.day9.TestA@7852e922
		//toString메소드 : 안에 들어있는 것이 자료형이 무엇이든 (string형태)문자로 출력한다
		//TestA의 부모가 Objectㅇ서 toString을 사용 가능한거다.
	}	

}