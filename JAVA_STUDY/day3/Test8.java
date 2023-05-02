package com.day3;

import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		
		// 배열
		int[] num = new int[5]; //int num[] = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("다섯개의 변수 : "); // 5  7  9  2  3
		
		
		for(int i=0; i<num.length; i++) {
			num[i] = sc.nextInt();
		}
		
		//하단 배열을 위의 for문 2줄로 바꿈
		/*num[0] = sc.nextInt();
		num[1] = sc.nextInt();
		num[2] = sc.nextInt();
		num[3] = sc.nextInt();
		num[4] = sc.nextInt();*/
		
					//i<num.length; 아래랑 같다
		for(int i=0; i<=num.length-1; i++) {
			System.out.println("num["+ i +"]:" + num[i]);//System.out.println("num[1]:" + num[i]);
			
		}
		
		System.out.println("배열 갯수 : " + num.length);// 배열의 length는 ()괄호가 없다. 
		
		
		num[3] = 100;
		System.out.println("num[3]:" + num[3]); //num[3]를 출력
		
		int a = num[3] - 30; //배열 3에 들어있는수(100)에서 -30을 함
		System.out.println("a:" + a);
	}
}