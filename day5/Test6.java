package com.day5;

public class Test6 {	//클래스의 초기값이 NULL이다.

	public static void main(String[] args) {
	
		//객체 생성
		Rect r1 = new Rect();
		r1.input();
		int area = r1.area();
		r1.length();
		int length = r1.length();
		r1.print(area, length);
		
		Rect r2 = new Rect();
		r2.input();
		int x = r2.area();
		int y = r2.length();
		r2.print(area, length);
	}

}
