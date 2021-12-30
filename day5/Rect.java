package com.day5;

import java.util.Scanner;

public class Rect {	//클래스
	
	int w, h; // instance변수(전역변수)
	
	
	public void input() {	//input메소드
		
		Scanner sc = new Scanner(System.in);
		
		//int w,h; // 지역변수(로컬변수)
		System.out.print("가로 : "); //10
		w = sc.nextInt();
		
		System.out.print("세로 : ");//5
		h = sc.nextInt();
		
		
		return; //생략
	}
	
	
	public int area() {
		
		int result; //지역변수
		result = w * h;
		
		return result;
	}
	
	
	public int length() {
		
		return (w+h) * 2;
	}
	
	public void print(int area, int length) { // int area()랑 void print에서 a와 l를 가져옴
		
		System.out.println("가로 :" + w);
		System.out.println("세로 :" + h);
		System.out.println("넓이 :" + area);
		System.out.println("둘레 :" + length);
	}

}
