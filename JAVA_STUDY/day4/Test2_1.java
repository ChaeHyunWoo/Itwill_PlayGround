package com.day4;

import java.util.Scanner;

public class Test2_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �Է��Ͻÿ�: ");
		int year = scan.nextInt();
		System.out.print("���� �Է��Ͻÿ�: ");
		int month = scan.nextInt();
		System.out.print("���� �Է��Ͻÿ�: ");
		int date = scan.nextInt();
		// 1. �־��� �������� 1900�� ���� 365�� ���Ѵ�.
		// 2. �������� 1900�� �� ���� 4�� ������ ������ Ƚ���̹Ƿ� �� ���� ���Ѵ�.
		int totalDays = ((year - 1900) * 365) + ((year - 1900) / 4);
		// 3. �־��� ������ �����̰� �־��� ���� 2���̳� 1���̸� ���� ������� 1�� ����.
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			if (month == 1 || month == 2) {
				totalDays--;
			}
		}

		// ���� ���� �ϱ⶧���� index 0�� �� ���� ���� �� �Ͽ� 0���� ��ü
		int[] monthDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// 4. ���� ����� �־��� ���� �ϱ����� �� ���� ���Ѵ�. ���� ��� 1�� 3���̸� 3�� ���Ѵ�.
		// �ϴ� ���������� ��� ���ϰ�
		for (int i = 1; i <= month - 1; i++) {
			totalDays += monthDays[i];
		}
		// �ش���� �ϱ����� ���Ѵ�.
		totalDays += date;
		String[] weeks = { "�Ͽ���", "������", "ȭ����", "������", "�����", "�ݿ���", "�����" };
		
		// 5. ���� �� ���� 7�� ���� �������� ������ �ȴ�.
		System.out.printf("%d�� %d�� %d���� %s�Դϴ�.", year, month, date, weeks[totalDays % 7]);
		scan.close();
	}
}