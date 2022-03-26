package com.day2;

import java.util.*;
//1.정수를 입력 받아서 짝수, 홀수를 구별해서 출력.
//예) 3 입력시 -> 3 => 홀수
//예) 4 입력시 -> 4 => 짝수
public class Number1 {

	public static void main(String[] args) {
		
		Scanner number = new Scanner(System.in);
		
		int num = 0;
		
		System.out.print("정수를 입력하세용 : ");
		
		num = number.nextInt();

		if(num%2 == 0) {
			System.out.println(num +" => 짝수");
		}
		if(num%2 != 0) {  
			System.out.println(num +" => 홀수");
			
			number.close();
		}
	}
}
