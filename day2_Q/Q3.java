package com.day2_Q;

import java.util.Scanner;

/*
3. 4개의 정수를 입력 받고, 제일 큰 숫자와 제일 작은 숫자를 구분해서 출력.(if문 이용)
예) 20, 30, 40, 50 입력 시 -> 제일 큰 숫자 50, 제일 작은 숫자 20
 */
public class Q3 {

	public static void main(String[] args) {
		
		Scanner result = new Scanner(System.in);
		int num1, num2, num3, num4, temp;
		
		System.out.println("4���� ���� �Է��ϼ���!");
		
		num1 = result.nextInt();//50
		num2 = result.nextInt();//40
		num3 = result.nextInt();//30
		num4 = result.nextInt();//20
		
		
		//4개의 수 비교
		if(num1>num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
			
		if(num2>num3) {
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		
		if(num3>num4) {
			temp = num3;
			num3 = num4;
			num4 = temp;
		}
		
		if(num1>num3) {
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
		
		if(num2>num4) {
			temp = num2;
			num2 = num4;
			num4 = temp;
		}
		
		System.out.println("제일 큰 숫자 : " + num4 + ", 제일 작은 숫자 : " + num1);
	}

}
