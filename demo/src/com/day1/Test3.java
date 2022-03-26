package com.day1;

public class Test3 {

	public static void main(String[] args) {
		
		int r = 10;
		float area, length;//실수형
		
		area = r * r * 3.14f;
		length = r * 2 * 3.14f;
		
		System.out.println(area); //원의 너비
		System.out.println(length); //원의 둘레
		
		System.out.println("반지름 : " + r + ", 면적: " + area);
		
		System.out.printf("반지름 : %d, 면적 :%.2f\n", r, area);
		//%f에서 소수점 2번째짜리까지 보고프면 %.2f를 쓴다.
		
		//-------------------------------------------
		
		// float과 int는 같은 4byte이지만 float가 더크다/java는 2진수 공부x
		int a=5;
		float b;
		
		b=a; // 암시적 형변환
		System.out.println(b);//5.0
		//반대로하면 에러 why? float이 int보다 더 크기때문 
		//큰것은 작은것에 들어갈 수 없다.
		
		a = (int)b;  //강제 형변환
		System.out.println(a);//5
		
	}

}