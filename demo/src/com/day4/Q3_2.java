package com.day4;

import java.util.Random;
import java.util.Scanner;

public class Q3_2 {

	public static void main(String[] args) {

		/*
		 1~3������ ������ �߻����� ����,����,�� ���� ���α׷� �ۼ� 1:����, 2:����, 3:��
		 
		 ��) 1:����, 2:����, 3:�� ?1 ��ǻ�� :�� ��� :���� ����� �̰���ϴ�
		  
		 1:����, 2:����, 3:�� ?1 ��ǻ�� :���� ��� :���� ��ǻ�Ͱ� �̰���ϴ�
		 */

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		String[] a = { "����", "����", "��" };

		int c, d; // c: ��ǻ��, d: ���

		c = rd.nextInt(3);

		System.out.print("1(����), 2(����) 3(��) �� �ϳ��� �Է��ϼ���");
		d = sc.nextInt() - 1;

		System.out.printf("��ǻ��: %s, ���: %s %n", a[c], a[d]);

		if (c == d) {

			System.out.println("�����ϴ�.");

		} else if (c + 2 == d || c - 1 == d) {

			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");

		} else {

			System.out.println("����� �̰���ϴ�.");

		}

	}

}