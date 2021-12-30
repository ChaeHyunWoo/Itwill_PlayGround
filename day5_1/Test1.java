package com.day5_1;

import java.util.Scanner;

public class Test1 {
	
	int r;
	float f = 3.14f;
	String s;
	
	public void output() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("반지름 :");
		r = sc.nextInt();
	}
	
	public int sum() {
		
		int result;
		result = (int) (r*r*f);
		
		return result;
	}
	
	public void print(int a) {
		
		System.out.println("원의 넓이:" + a);
	}
}
