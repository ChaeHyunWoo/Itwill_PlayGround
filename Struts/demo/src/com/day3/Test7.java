package com.day3;

import java.io.IOException;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int num1, num2;
		char oper;

		System.out.print("ù��° �� : ");
		num1 = sc.nextInt();

		System.out.print("�ι�° �� : ");
		num2 = sc.nextInt();

		System.out.print("������[+, -, *, /] : ");

		oper = (char)System.in.read(); //system.in.read�� ���� ������ ��ȣ�� �ƽ�Ű �ڵ带 �о��ش�.

		switch(oper) {	// ���ڸ� �޾Ƽ� ' ' ǥ��!

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