package com.day10;

//final의 3가지 특징(특성) - 원본 코딩을 손실을 없게할 때 사용
//인스턴수변수에 final을 붙이면 단 한번만 초기화가 가능하다.
//메소드에 final을 붙이면 Override가 불가능하다
//클래스에 final을 붙이면 상속이 불가능하다.
//-------------------------------------------------------------------------------------------
//final class TestA  - 클래스에 final을 붙이면 상속 불가능(클래스에 final을 주는 경우는 거의 없다.)
class TestA {
	
	public static final double PI;	// 초기화를 안하면 오류뜸
	
	static {
		PI = 3.14; //한번 초기화하면 값을 바꿀 수 없다.
	}
	
	public double area; //instance변수
	
	public final void write(String title) {//메소드에 final을 주면 자식이 부모 메소드를 쓸수는 있어도 override를 할 수 없다.
		System.out.println(title + ":" + area);
	}
}

public class Test7 extends TestA { //부모꺼는 내꺼다.
	
	//@Override		//메소드에 final을 주면 자식이 부모 메소드를 쓸 수 없다.
	//public void write(String title) {
	//}
	
	public void circleArea(int r) {
		area = (double)r*r*PI;
	}

	public static void main(String[] args) {
		
		Test7 ob = new Test7();
		ob.circleArea(10);
		ob.write("원");
	
	}

}
