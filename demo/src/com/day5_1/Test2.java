package com.day5_1;

import java.util.Scanner;

public class Test2 {
	
	int a, b;
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로 :");
		a = sc.nextInt();
		System.out.print("세로 :");
		b = sc.nextInt();
		
	}
	
	
	public int area() {
		
		int result;
		result = (a*b)/2;
		
		return result;
	}

	
	
	public void print(int e) {
		
		System.out.println("가로 :" + a);
		System.out.println("세로 :" + b);
		System.out.println("넓이 :" + e);
	}
}