package com.day3;

import java.io.IOException;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int num1, num2;
		char oper;

		System.out.print("첫번째 수 : ");
		num1 = sc.nextInt();

		System.out.print("두번째 수 : ");
		num2 = sc.nextInt();

		System.out.print("연산자[+, -, *, /] : ");

		oper = (char)System.in.read(); //system.in.read가 위의 연산자 기호의 아스키 코드를 읽어준다.

		switch(oper) {

		case '+':
			System.out.printf("%d%c%d = %d %n", num1, oper, num2, (num1+num2));
			break;

		case '-':
			//System.out.print(num1-num2);
			System.out.printf("%d%c%d = %d %n", num1, oper, num2, (num1-num2));
			break;

		case '*':
			System.out.printf("%d%c%d = %d %n", num1, oper, num2, (num1*num2));
			break;							

		case '/':
			System.out.printf("%d %c %d = %d %n", num1, oper, num2, (num1/num2));
		default:								// %c = oper
		}
	}

}
