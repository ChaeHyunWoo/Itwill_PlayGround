package com.day5;

public class Test6 {	//클래스의 초기값이 NULL이다.

	public static void main(String[] args) {
	
		//객체 생성
		Rect r1 = new Rect();	//같은 패키지 안에 있어서 import안해도된다.
		r1.input();
		int area = r1.area();
		r1.length();
		int length = r1.length();
		r1.print(area, length);// 변수명은 클래스 생성 시 이름과 달라도 문제없지만 자료형은 맞춰야함
		
		Rect r2 = new Rect();
		r2.input();
		int x = r2.area();
		int y = r2.length();
		r2.print(area, length);
	}

}