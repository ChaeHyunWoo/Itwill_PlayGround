package com.day2;

import java.util.Scanner;

//3. �� ���� ������ �Է� �ް�, ���� ū ���ڿ� ���� ���� ���ڸ� �����ؼ� ���.(if�� �̿�)
//��) 20, 30, 40, 50 �Է½� -> ���� ū ���� 50, ���� ���� ���� 20
public class Number3 {

	public static void main(String[] args) {
		
		Scanner result = new Scanner(System.in);
		int num1, num2, num3, num4, temp;
		
		System.out.println("4���� ���� �Է��ϼ���!");
		
		num1 = result.nextInt();//50
		num2 = result.nextInt();//40
		num3 = result.nextInt();//30
		num4 = result.nextInt();//20
		
		
		//4���� ���� ��
		if(num1<num2) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
			
		if(num3<num4) {
			temp = num3;
			num3 = num4;
			num4 = temp;
		}
		
		if(num1<num3) {
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
		
		if(num2<num4) {
			temp = num2;
			num2 = num4;
			num4 = temp;
		}
		
		System.out.println("���� ū ���� : " + num1 + ", ���� ���� ���� : " + num4);
	}

}
