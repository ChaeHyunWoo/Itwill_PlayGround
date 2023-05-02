package com.day2;
import java.util.*;
//2.두 개의 정수를 입력 받고, 큰 숫자와 작은 숫자를 구분해서 출력.(if문 이용)
//예) 20, 30 입력시 -> 큰 숫자 30, 작은 숫자 20
public class Number2 {

	public static void main(String[] args) {
		
		Scanner result = new Scanner(System.in);
		
		int num1, num2 = 0;
		
		System.out.println("숫자 2개를 입력하삼"); //30 20
		
		num1 = result.nextInt();//30
		num2 = result.nextInt();//20
		
		//2개 중 누가 큰지 비교
		if(num1>num2) {
			System.out.println("큰숫자 : " + num1);
			System.out.println("작은숫자 : " + num2);
		}
		
		if(num1<num2) {
			System.out.println("큰숫자 : " + num2);
			System.out.println("작은숫자 : " + num1);
		}
	}
}
