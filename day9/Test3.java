package com.day9;

//String
//String은 Class(클래스)이다. (자료형이 아님)
//String클래스를 자료형처럼 사용하는 이유는 저장할 데이터는 방대하고 사용 빈도는 높기 때문이다.

//String 데이터는 equalse로 비교해야 정확한 값이 나옴
//String은 불변의 법칙(메모리에 값이 저장되면 수정or삭제 못함) 새로운 곳에 만듬
public class Test3 {

	public static void main(String[] args) {
		
		String ob1 = "Seoul";	// 자료형처럼 생성
		String ob2 = "Seoul";
		String ob3 = new String ("Seoul"); //클래스 생성 정석
		
		System.out.println("ob1 == ob2 : " + (ob1 == ob2)); //true | why? String은 문자가 100%같으면 새로 만들지 않고, 주소를 공유한다.
		System.out.println("ob1 == ob3 : " + (ob1 == ob3)); //false | new가 들어가는 순간 무조건 만들어야함.
															// 내용이 같더라도 주소가 달라서 false
		System.out.println("ob1.equals(ob3) : " + ob1.equals(ob3)); //true 
		
		ob2 = "korea";
		System.out.println("ob1 == ob2 : " + (ob1 == ob2)); // false
		
		ob2 = "use";
		System.out.println("ob1 == ob2 : " + (ob1 == ob2)); // false
		
		ob2 = "Seoul";
		System.out.println("ob1 == ob2 : " + (ob1 == ob2)); // true
		
		System.out.println(ob2); // hashcode ( x) 
		//String 클래스는 자료형 흉내를 최대한 내기 위해 hascode 주소값이 안나오고 주소로 찾아가 있는 데이터를 출력해줌
		System.out.println(ob2.toString()); // Seoul

	}
}