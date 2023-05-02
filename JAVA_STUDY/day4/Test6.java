package com.day4;

import com.day5.Rect;

public class Test6 {

	public static void main(String[] args) {
		
		Rect usa = new Rect();	// 패키지가 달라서 import 시켜야함
		
		usa.input();
		int aa = usa.area();
		int ll = usa.length();
		usa.print(aa, ll);
		
		//전역변수: 초기값 = 0
		//지역변수 초기값 = 쓰레기값 가지고 있다.
	}
}