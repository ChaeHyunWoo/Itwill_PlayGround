package com.day4;
/*
1������
5���� ������ �Է¹޾� �Է¹��� ���� ����ϰ� �Է¹��� �� �߿� ���� ū ���� �������� ���
 */
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a,b,c,d,e,max=0,min=0;

		System.out.print("5���� ������ �Է��ϼ��� ?");

		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		d=sc.nextInt();
		e=sc.nextInt();

		max = min = a;

		if(a > max)
		max = a;

		if(a < min)
		min = a;

		if(b > max)
		max = b;

		if(b < min)
		min = b;

		if(c > max)
		max = c;

		if(c < min)
		min = c;

		if(d > max)
		max = d;

		if(d < min)
		min = d;
		
		if(e > max)
			max = e;

		if(e < min)
		min = e;


	System.out.println("���� ū ���� "+ max +", ���� ���� ���� "+ min);

	}

}


