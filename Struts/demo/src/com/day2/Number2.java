package com.day2;
import java.util.*;
//2.�� ���� ������ �Է� �ް�, ū ���ڿ� ���� ���ڸ� �����ؼ� ���.(if�� �̿�)
//��) 20, 30 �Է½� -> ū ���� 30, ���� ���� 20
public class Number2 {

	public static void main(String[] args) {
		
		Scanner result = new Scanner(System.in);
		
		int num1, num2 = 0;
		
		System.out.println("���� 2���� �Է��ϻ�"); //30 20
		
		num1 = result.nextInt();//30
		num2 = result.nextInt();//20
		
		//2�� �� ���� ū�� ��
		if(num1>num2) {
			System.out.println("ū���� : " + num1);
			System.out.println("�������� : " + num2);
		}
		
		if(num1<num2) {
			System.out.println("ū���� : " + num2);
			System.out.println("�������� : " + num1);
		}
	}
}
