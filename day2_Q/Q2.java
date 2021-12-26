package com.day2_Q;
import java.util.*;
/*
2.  두개의 정수를 이 ㅂ력 받고, 큰 숫자와 작은 숫자를 구분해서 출력.(if문 이용)
예 ) 20, 30 입력시 -> 큰 숫자30, 작은 숫자 20
 */
public class Q2 {

	public static void main(String[] args) {
		
		Scanner result = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.println("숫자 2개를 입력하세요 "); //30 20
		
		num1 = result.nextInt();//30
		num2 = result.nextInt();//20
		
		//2개 중 누가 큰지 비교
		if(num1>num2) {
			System.out.println("큰수 : " + num1);
			System.out.println("작은 수 : " + num2);
		}
		
		if(num1<num2) {
			System.out.println("큰수 : " + num2);
			System.out.println("작은 수 : " + num1);
		}
	}

}
