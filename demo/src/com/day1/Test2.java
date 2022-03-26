package com.day1;

public class Test2 {
	
	public static void main(String[] args) {
		
		//변수 선언
		//자료형 int : 정수(범위 : 약-21억 ~ 21억) /자료형은 8개 + String
		int a=10; // int형 변수a를 선언하고 10으로 초기화
		int b=5;
		
		int c,d; // 쓰레기 값이 들어있음
		
		System.out.println(a); //10
		System.out.println(b); //5
		//System.out.println(c); // 컴파일 오류 / 코딩 상에는 문제없는데 실행하면 뜨는 오류는 런타임 오류.
		
		c = a + b;
		System.out.println(c);//15     // syso  혹은 sout 쓰고 컨트롤+스페이스 (println)자동완성
		
		d = a - b;
		System.out.println(d);//5
		
		System.out.println(a + "+" + b + "=" + c);
		System.out.println();
		System.out.println(a + "-" + b + "=" + d);
		
		//printf의 f는 format(모양)이다.//%n은 줄바꿈 \n을 써도됨 
		System.out.printf("%d + %d = %d %n", a, b, c);
		System.out.printf("%d - %d = %d\n", a, b, d);
		
	}

}