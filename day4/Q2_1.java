package com.day4;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Q2_1 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int input, answer = 0, i;
		
		input = rd.nextInt(9)+1;
		
		while(true) {
			for(i=1; i<=3; i++) {
				System.out.printf("�����Է�?[%d��°��ȸ] :", i);
				input = sc.nextInt();
				
				if(input == answer) {
					System.out.println("�¾Ҿ��!");
					break;
				} else {
					System.out.println("Ʋ�Ⱦ��!");
				}
				}
			System.out.printf("������ %d�Դϴ�.", input);

			System.out.println("��� �ҷ�?[Y/y]");
			answer = (char) System.in.read();

			if (answer != 'Y' && answer != 'y') {
				System.out.println("���α׷� ����");
				break;
			}
		}

	}

}