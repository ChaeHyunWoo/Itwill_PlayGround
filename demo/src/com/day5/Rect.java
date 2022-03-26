package com.day5;

import java.util.Scanner;

public class Rect {	//클래스
	
	int w, h; // instance변수(전역변수) : 클래스 안 어디서나 사용 가능한 전역변수
	
	
	public void input() {	//input메소드
		
		Scanner sc = new Scanner(System.in);
		
		//int w,h; // 지역변수(로컬변수)
		System.out.print("가로 : "); //10
		w = sc.nextInt();
		
		System.out.print("세로 : ");//5
		h = sc.nextInt();
		
		
		//return;  void라 설정해놨기 때문에 return 생략 가능
	}
	
	
	public int area() {	//return값이 정수형
		
		int result; //지역변수 : 다른 메소드에서 인식 못함
		result = w * h;
		
		return result;
	}
	
	
	public int length() {	//return값이 정수형
		
		return (w+h) * 2;// 지역변수를 만들어서 반환해도 되지만, return옆에 바로 결과값을 넣어도 문제 없음
	}
	
	public void print(int area, int length) { // int area()랑 void print에서 a와 l를 가져옴
											  // 반환값없음.매개변수 2개 필요.메소드를 실행하고 끝남
		System.out.println("가로 :" + w);
		System.out.println("세로 :" + h);
		System.out.println("넓이 :" + area);
		System.out.println("둘레 :" + length);
	}

}