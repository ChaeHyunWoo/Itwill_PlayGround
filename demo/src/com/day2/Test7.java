package com.day2;

import java.util.*;

public class Test7 {

	public static void main(String[] args) {
		
		//3���� ���� �Է� �޾Ƽ� ���������� ū �� ������ ���(��������)
		//3���� ��? 9 5 2
		//��� : 2 5 9
		Scanner result = new Scanner(System.in);
		int num1;
		int num2;
		int num3;
		int temp;
		
		
		System.out.println("3���� ��?");//9 5 2
		
		num1 = result.nextInt();//9
		num2 = result.nextInt();//5
		num3 = result.nextInt();//2
		
	
		//3 ���� �� �񱳹�� 1��°
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
		
		
		//3 ���� �� �񱳹�� 2��°
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
		
		System.out.println("1�� : " + num1 + ", 2�� : " + num2 + ", 3�� : " + num3);
		//System.out.printf("��� : %d %d %d %n", num1, num2, num3);
			
			
	}
}	
		