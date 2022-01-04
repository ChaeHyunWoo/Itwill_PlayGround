package com.day10;

import java.util.Calendar;
import java.util.Scanner;

//����4��
//��������� ��, ��, ���� �Է¹޾� 100(x)�� �� ��,��,��(����) ������� ����ϱ�
		/* ����
		 
		�⵵? 2016
		��? 4
		��? 20
		������? 100

		�� �� �� : 2016�� 4�� 20�� ������
		100�� �� : 2016�� 7�� 29�� �ݿ���
				*/
public class Test4 {

	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		String[] weeks = { "�Ͽ���", "������", "ȭ����", "������", "�����", "�ݿ���", "�����" };
		
		int year, month, day, whenday, week; 
		
		do {
			System.out.print("�⵵ : "); // 2021
			year = sc.nextInt();
		} while(year < 1);	// �⵵�� 1���� ������ �ȵȴ�.

		do {
			System.out.print("�� : "); //12��
			month = sc.nextInt();
		} while(month < 1 || month > 12); //|| -> OR(�Ǵ�) -> month�� 1���� �۰ų� 12���� ũ��
		
		do {
			System.out.print("�� : "); // 25��
			day = sc.nextInt();
		} while(day < 1 || day > 31);
		
		System.out.print("���� ��? : ");
		whenday = sc.nextInt();
		now.set(year, month - 1, day);//  now.set(����, ��, ��) - set() : �޷� �ʵ忡 ���� �Է��� �� ���
		week = now.get(Calendar.DAY_OF_WEEK); // - DAY_OF_WEEK : ���� (��(1)~��(7))
		
		System.out.println("���� �� : " + year + "�� " + month + "�� " + day + "�� " + weeks[week-1] + "����");
		
		now.add(Calendar.DATE, whenday); 
		year = now.get(Calendar.YEAR); //��
		month = now.get(Calendar.MONTH) + 1; // ��(0~11) + 1
		day = now.get(Calendar.DATE); // ��
		week = now.get(Calendar.DAY_OF_WEEK); // ���� ��(1~7) 1:������ ~ 7:�Ͽ���
		
		System.out.println(whenday + "�� �� : " + year + "�� " + month + "�� " + day + "�� " + weeks[week-1] + "����");

	}

}