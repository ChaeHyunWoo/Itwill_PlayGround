package com.day4;

import java.util.Scanner;

public class Q1_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] su = new int[5];
		int i,max,min;


		System.out.print("5���� ������ �Է��ϼ���.");


		for(i=0;i<su.length;i++){

			su[i] = sc.nextInt();
		}

		//max�� min���Ҷ� ���
		//���� �־���� �ٸ� ���� ��
		max=min=su[0];

		for(i=1;i<su.length;i++){
			if(max<su[i])
				max=su[i];
			if(min>su[i])
				min=su[i];
		}
		System.out.printf("���� ������ : %d, ���� ū�� %d",min,max);	
		System.out.println();	
	}
}