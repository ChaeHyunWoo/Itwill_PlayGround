package com.day3;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int su;
		
		System.out.print("1~3�̳��� �� : "); // 1 2 3
		su = sc.nextInt();
		
		switch(su) {	//switch���� if������ ��ȯ �����ϴ�.	shitch( ) ��ȣ �ȿ��� 8���� �ڷ����� string ����
															    // char���� ���� ' ' �����ְ� ���ڿ��� ���� " " 
		case 3: 
			System.out.println("***");
			break;
			
		case 2:
			System.out.println("**");
			break;
		case 1:
			System.out.println("*");
			break;
			
			default:
				System.out.print("���� �Է� ���� !");
		}
	}
}