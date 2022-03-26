package com.day3;
//3. 두 수를 입력받아 적은 수에서 큰 수까지의 합 출력하기
//		1~100 까지의 합 : 5050
import java.util.Scanner;


public class Q3 {	//예외 발생 : 큰 수를 먼저 입력하면 오류

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1, num2, sum = 0, i;
		
		System.out.println("첫번째 수 입력  : ");
		num1 = sc.nextInt();
		System.out.println("두번째 수 입력 : ");
		num2 = sc.nextInt();
		
		for(i=num1; i<=num2; i++) {
			sum += i;
		}
		System.out.println(sum);

	}

}