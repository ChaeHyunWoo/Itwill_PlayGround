package com.day2;

import java.util.*;

public class Test7 {

	public static void main(String[] args) {
		
		//3개의 수를 입력 받아서 작은수에서 큰 수 순으로 출력(오름차순)
		//3개의 수? 9 5 2
		//결과 : 2 5 9
		Scanner result = new Scanner(System.in);
		int num1;
		int num2;
		int num3;
		int temp;
		
		
		System.out.println("3개의 수?");//9 5 2
		
		num1 = result.nextInt();//9
		num2 = result.nextInt();//5
		num3 = result.nextInt();//2
		
	
		//3 개의 수 비교방법 1번째
		/*if(num1>num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
			
		if(num2>num3) {
			temp = num2;
			num2 = num3;
			num3 = temp;
		}

		if(num1>num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;*/
		
		
		//3 개의 수 비교방법 2번째
		if(num1>num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		if(num1>num3) {
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
		
		if(num2>num3) {
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		
		System.out.println("1번 : " + num1 + ", 2번 : " + num2 + ", 3번 : " + num3);
		//System.out.printf("결과 : %d %d %d %n", num1, num2, num3);
			
			
	}
}	
		