package com.day5_1;

import java.util.Scanner;

public class Test2 {
	
	int a, b;
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� :");
		a = sc.nextInt();
		System.out.print("���� :");
		b = sc.nextInt();
		
	}
	
	
	public int area() {
		
		int result;
		result = (a*b)/2;
		
		return result;
	}

	
	
	public void print(int e) {
		
		System.out.println("���� :" + a);
		System.out.println("���� :" + b);
		System.out.println("���� :" + e);
	}
}