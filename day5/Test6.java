package com.day5;

public class Test6 {	//Ŭ������ �ʱⰪ�� NULL�̴�.

	public static void main(String[] args) {
	
		//��ü ����
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
