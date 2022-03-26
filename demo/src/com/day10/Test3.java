package com.day10;
//����1 ��
//����� �Է¹޾� CalendarŬ������ ����޷��� �����

import java.util.Calendar;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {

		Calendar now = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);

		int year, month, week; // �� ,��, i, ��

		do {
			System.out.print("�⵵ : "); // 2021
			year = sc.nextInt();
		} while(year < 1);	// �⵵�� 1���� ������ �ȵȴ�.

		do {
			System.out.print("�� : "); //12��
			month = sc.nextInt();
		} while(month < 1 || month > 12); //|| -> OR(�Ǵ�) -> month�� 1���� �۰ų� 12���� ũ��

		now.set(year, month - 1, 1);//  now.set(����, ��, ��) - set() : �޷� �ʵ忡 ���� �Է��� �� ���
		week = now.get(Calendar.DAY_OF_WEEK); // - DAY_OF_WEEK : ���� (��(1)~��(7))
		int lastDay = now.getActualMaximum(Calendar.DATE);

		System.out.printf("----------%d�� %d��-----------", year, month);
		System.out.println();
		System.out.println("\n  ��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("------------------------------");

		for(int i = 1; i < week; i++) {										// ���� 1ĭ = 2����Ʈ	���� = 2����Ʈ
			System.out.print("    "); //���� 4ĭ why? ������ ����2ĭ ��/����2ĭ ȭ �̷��� ����µ� �Ѵ� 4����Ʈ�� �����.
		}

		for(int i = 1; i <= lastDay; i++) {
			System.out.printf("%4d", i); // %4d�� %d�� ���� ������ 4����Ʈ�� �����

			// �� ���� ��¥�� ��µǸ� �ٹٲ�
			week++;					//week�� �Ͽ��Ϻ���~�����
			if(week % 7 == 1) 	// ����� �������� �Ѿ�� �ٹٲ��ؼ� ��¥ ���
				System.out.println();
			//�� �� ���� ��(1)���� ��(7) 7�� �������� �ٹٲ�
		}

		if(week % 7 != 1) {	// �Ѵ��� �������� �ٹٲ�����
			System.out.println();
		}
		System.out.println("------------------------------");
		sc.close();
	}	
}