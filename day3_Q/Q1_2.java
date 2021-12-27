package com.day3_Q;
//1. 1에서 100까지 수의 홀수의 합, 짝수의 합, 전체의 합
//		짝수합 : 2550
//		홀수합 : 2500
//		합 : 5050
public class Q1_2 {

	public static void main(String[] args) {
		
		int i =1;
		int sum1 = 0, sum2 = 0;	// sum1:홀수  sum2: 짝수
		
		
		for(i=1; i<=100; i++) {
			
			if(i%2 == 0) {	// 짝수
				sum2 += i;	
			} else {		//홀수
				sum1 += i;
			}
		}

		System.out.println("짝수합 : " + sum2);
		System.out.println("홀수합 : " + sum1);
		System.out.println("전체 합 : " + (sum1+sum2));
	}

}
