package com.day2;

import java.util.*;
//1.������ �Է� �޾Ƽ� ¦��, Ȧ���� �����ؼ� ���.
//��) 3 �Է½� -> 3 => Ȧ��
//��) 4 �Է½� -> 4 => ¦��
public class Number1 {

	public static void main(String[] args) {
		
		Scanner number = new Scanner(System.in);
		
		int num = 0;
		
		System.out.print("������ �Է��ϼ��� : ");
		
		num = number.nextInt();

		if(num%2 == 0) {
			System.out.println(num +" => ¦��");
		}
		if(num%2 != 0) {  
			System.out.println(num +" => Ȧ��");
			
			number.close();
		}
	}
}
