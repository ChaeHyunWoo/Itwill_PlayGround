package com.day2;
//�⵵�� �Է¹ް�, �������� �ƴ����� ���.
//��) 2010 �Է½� -> 2010 => ���
//    2012 �Է½� -> 2012 => ����
import java.util.*;

public class Number4 {

	public static void main(String[] args) {
		
		Scanner result = new Scanner(System.in);
		
		int num1;
		
		System.out.println("�⵵�� �Է� : ");
		num1 = result.nextInt();
		
		String str;
		
		//str = num1%2==0?"¦��":"Ȧ��";
		
		//str = num1>0?"���":(num1<0?"����":"��");
		
		str = num1%4==0 && num1%100!=0 || num1%400==0?"����":"���";
		
		System.out.println(num1 + "=> " + str);
	}
}