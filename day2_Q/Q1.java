package com.day2_Q;

import java.util.*;
/*
1. 정수를 입력 받아서 짝수, 홀수를 구별해서 출력
예) 3입력시 -> 3 -> 홀수
예) 4입력시 -> 4 -> 짝수
 */
public class Q1 {

	public static void main(String[] args) {
		
		Scanner number = new Scanner(System.in);
		
		int num;
		
		System.out.println("정수를 입력하세요 : ");
		
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
