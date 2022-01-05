package com.day11;

// Interface(인터페이스) - 클래스다
// 추상클래스의 일종으로 선언만 하고, 정의(내용)가 없다.
// 변수는 final 변수만 선언 가능하다.
// 인터페이스를 구현하기위해서는 implements를 사용한다.
// 인터페이스를 구현했으면 인터페이스의 모든 메서드를 재정의(오버라이드)해야 한다.
// 인터페이스가 다른 인터페이스를 상속받을 수 있다. 그때는 extends를 사용한다.
// 클래스는 단일 상속이지만 인터페이스는 다중상속이 가능하다.

interface Fruit { //인터페이스
	
	String Won = "원";  // 인터페이스 안의 변수 - public static final이 생략되어 있음
	
	int getPrice(); // public abstract 생략되어 있음
	

	public String getName();
	// 인터페이스 안에는 일반 메소드를 만들 수 없다.
}

class FruitImpl implements Fruit {//인터페이스는 extends 대신 implements로 상속받는다.
	

	@Override
	public int getPrice() {
		return 1000;
	}

	@Override
	public String getName() {
		return "사과";
	}
	
	public String getItems() {
		return "과일";
	}

	
}

public class Test3 {

	public static void main(String[] args) {
		
		
		//Fruit ob1 = new FruitImpl();을 하면 getItems이 오류뜸 why? 부모는 자식껄 쓸수 없기에
		FruitImpl ob1 = new FruitImpl();
		
		System.out.println(ob1.getItems());
		System.out.println(ob1.getName());
		System.out.println(ob1.getPrice() + Fruit.Won);
		
		Fruit ob2 = ob1; // upcast - 자식을 부모에 넣음
		
		System.out.println(ob2.getName());
		//System.out.println(ob2.getItem()); 오류 - 부모는 자식껄 쓸 수 없다.
	}

}
