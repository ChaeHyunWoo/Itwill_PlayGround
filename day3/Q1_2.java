package com.day3;
//1. 1�뿉�꽌 100源뚯� �닔�쓽 ���닔�쓽 �빀, 吏앹닔�쓽 �빀, �쟾泥댁쓽 �빀
//		吏앹닔�빀 : 2550
//		���닔�빀 : 2500
//		�빀 : 5050
public class Q1_2 {

	public static void main(String[] args) {
		
		int i =1;
		int sum1 = 0, sum2 = 0;	// sum1:���닔  sum2: 吏앹닔
		
		
		for(i=1; i<=100; i++) {
			
			if(i%2 == 0) {	// 吏앹닔
				sum2 += i;	
			} else {		//���닔
				sum1 += i;
			}
		}

		System.out.println("吏앹닔�빀 : " + sum2);
		System.out.println("���닔�빀 : " + sum1);
		System.out.println("�쟾泥� �빀 : " + (sum1+sum2));
	}

}
