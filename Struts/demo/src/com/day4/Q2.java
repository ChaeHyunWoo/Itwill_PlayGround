package com.day4;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/*
2������
1~10������ ������ �߻����� �߻���Ų ������ 3�� �ȿ� �˾� ���ߴ� ����
(3�� �ȿ� �˾Ƹ����� ���ϸ� �߻��� ������ ���)
 */
public class Q2 {

	public static void main(String[] args) throws IOException {
		
			Scanner sc = new Scanner(System.in);
			Random rd = new Random();

			int[] num = new int[3];
			int a;
			char ch;

			a = rd.nextInt(10) + 1;	// 1

			while (true) {

				for (int i = 0; i < 3; i++) {

					System.out.printf("�����Է�?[%d��° ��ȸ] : ", i + 1);
					num[i] = sc.nextInt();

					if (a == num[i]) {
						System.out.println("�¾Ҿ��!");
						break;
					} else {
						System.out.println("Ʋ�Ⱦ��!");
					}

				}

				System.out.printf("������ %d�Դϴ�.", a);

				System.out.println("��� �ҷ�?[Y/y]");
				ch = (char) System.in.read();

				if (ch != 'Y' && ch != 'y') {
					System.out.println("���α׷� ����");
					break;
				}
			}

		}

	}