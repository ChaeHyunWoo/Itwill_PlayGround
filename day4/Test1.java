package com.day4;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		//�迭 ����!
		
		// ����޷� �����
		Scanner sc = new Scanner(System.in);
		
		//int [] months = new int [12]; �ϴ� ó�� �迭 ���� ���� 
		// ���� ��¥ ���� �迭�� ����
		int [] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // = 12��
		
		int y, m, nalsu, i, week = 0;
		
		do {
			System.out.print("�⵵ : "); // 2021
			y = sc.nextInt();
		} while(y<1);	// �⵵�� 1���� ������ �ȵȴ�.
		
		do {
			System.out.print("�� : "); //12��
			m = sc.nextInt();
		} while(m<1 || m>12); //���� 1���� ������ �ȵǰ� 12���� ũ�� �ȵȴ�.
		
		//���⿡ ���� 2���� �� ��
		if(y%4 == 0 && y%100 != 0 || y%400 == 0) {	//������ ���ϴ� ����
			months[1] = 29;	// �����̸� �迭 [1]�� 29�� �ٲ۴�. ������ �ƴϸ� [1]�� 28�̴�.
		}
		
		//1��1��1�Ϻ��� ����ڰ� (y-1)�� 12�� 31�ϱ����� �� �� ���ϱ�  // &&�� ���� ||�� ���ϱ�
		nalsu = (y-1)*365 + (y-1)/4-(y-1)/100 +(y-1)/400;//���� ���ϴ� ����
		
		/*int yy = (y-1)/4-(y-1)/100 +(y-1)/400;
		System.out.println(nalsu); // �� ��
		System.out.println(yy); */
		
		
		//index : 0   1   2   3   4   5   6   7   8   9   10  11
		//�迭 : {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
		//��(m) :  1   2   3   4   5   6   7   8   9  10  11  12
		
		//(m-1)�� ���ϱ����� �� ��
		for(i=0; i<m-1; i++) {
			nalsu += months[i];
		}	
		
		nalsu += 1; //y�� m��1��
		
		// ���Ǽ� ���
		week = nalsu % 7; // 3
		
		System.out.println(week);
		System.out.println("\n  ��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("------------------------------");
		
		for(i=0; i<week; i++) {										// ���� 1ĭ = 2����Ʈ	���� = 2����Ʈ
			System.out.print("    "); //���� 4ĭ why? ������ ����2ĭ ��/����2ĭ ȭ �̷��� ����µ� �Ѵ� 4����Ʈ�� �����.
		}
		
		for(i=1; i<=months[m-1]; i++) {
			System.out.printf("%4d", i); // %4d�� %d�� ���� ������ 4����Ʈ�� �����
						// �����ѱ۴��  wed fri �� ������� �ٲٸ� %4d��� %3d ���
			// �� ���� ��¥�� ��µǸ� �ٹٲ�
			week++;
				if(week%7 == 0) 	// ����� �������� �Ѿ�� �ٹٲ��ؼ� ��¥ ���
					System.out.println();
				}
		
				if(week%7 != 0) {
					System.out.println();
		}
				System.out.println("------------------------------");
	}
}