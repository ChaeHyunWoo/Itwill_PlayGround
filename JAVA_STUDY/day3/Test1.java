package com.day3;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		//�ݺ���(for, while, do-while)
		
		Scanner sc = new Scanner(System.in);
		
		int dan;
		
		System.out.print("�� �Է� : ");
		dan = sc.nextInt();
		
		//for�� : �ּҰ�,�ִ밪 or �������� ��Ȯ�� �˸� ������ for��
		System.out.println("for�� �̿�");
		for(int i=1; i<=9; i++) {
			System.out.println(dan + "*" + i + "=" +(dan*i));
		}
		
		System.out.println("----------------------------");
		
		//while�� : ���� ��Ȯ���� ���� �� ���
		System.out.println("while�� �̿�");
		int j=0;
		while(j<9) {
			j++; //�������� �Ⱦ��� J=1�� ���ѹݺ���. �������� println�ؿ� ������ j *0���� ���ͼ� �������� ����
			System.out.println(dan + "*" + j + "=" + (dan*j));
			
		}
		System.out.println("----------------------------");
		
		//do-while�� : ���� ��������� ������ �䱸�ϰ�  �䱸�� ������ ���� Ȯ�� �� �� ����Ѵ�
		System.out.println("do-while�� �̿�");
		int k=0;
		do {
			k++;
			System.out.println(dan + "*" + k + "=" + (dan*k));
		} while(k<9);	
	}
}