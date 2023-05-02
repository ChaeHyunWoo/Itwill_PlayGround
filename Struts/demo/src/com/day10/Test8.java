package com.day10;
//추상 클래스
//추상 클래스는 메모리의 낭비없이 클래스와 메소드를 미리 설계를 하는 것
//추상 클래스는 메소드를 재정의해서 사용
//추상 클래스에는 반드시 하나 이상의 추상 메소드가 있어야 하고, 
//일반 메소드도 만들 수 있다.
//추상 클래스는 메소드 명을 가져다가 사용하면 됨. 강제성은 띄지만 메소드명을 만드는데 노력 x
//메소드명이 동일하여 통일성

abstract class ShapeClass { //추상클래스 -  앞에는 abstract가 붙는다.
	
	abstract void draw();// 추상 메소드 - 추상클래스 안에는 추상 메소드가 1개 이상 있어야함
}


class Circle extends ShapeClass {	//추상 클래스를 상속받아서 메소드를 재정의해서 사용 

	@Override
	public void draw() {	// 
		System.out.println("원을 그린다...");
	} 
}


class  Rect extends ShapeClass {

	@Override
	public void draw() {
		System.out.println("사각형을 그린다...");
	} 
}


class Tria extends ShapeClass {

	@Override
	public void draw() {
		System.out.println("삼각형을 그린다...");
	}
}


public class Test8 {

	public static void main(String[] args) {
		
		//객체 생성
		Circle c = new Circle();
		Rect r = new Rect();
		Tria t = new Tria();
		
		c.draw();
		r.draw();
		t.draw();
		
	}

}