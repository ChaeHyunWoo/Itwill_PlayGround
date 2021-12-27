//1. 1에서 100까지 수의 홀수의 합, 짝수의 합, 전체의 합
//		짝수합 : 2550
//		홀수합 : 2500
//		합 : 5050
package com.day3_Q;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		
		int i = 1, sum1, sum2;
		
		sum1=0;
		sum2=0;
		//while문 사용
		while(i<100) {
			sum1 += i++; //홀수 합
			sum2 += i++; //짝수 합
		}
		System.out.println("짝수합 : " + sum2);
		System.out.println("홀수합 : " + sum1);
		System.out.println("전체 합 : " + (sum1+sum2));
	}

	public static class Q1_1 {

		public static void main(String[] args) {

			int i = 1, sum1, sum2;

			sum1=0;
			sum2=0;
			//do-while��
			do {
				sum1 += i++; //Ȧ��
				sum2 += i++; //¦��
			} while(i<100);

			System.out.println("¦���� �� : " + sum2);
			System.out.println("Ȧ���� �� : " + sum1);
			System.out.println("�� : " + (sum1+sum2));
		}

	}

	public static class Q1_2 {

		public static void main(String[] args) {

			int i =1;
			int sum1 = 0, sum2 = 0;	// sum1:Ȧ����  sum2:¦����


			for(i=1; i<=100; i++) {

				if(i%2 == 0) {	// ¦��
					sum2 += i;
				} else {		//Ȧ��
					sum1 += i;
				}
			}

			System.out.println("¦�� �� : " + sum2);
			System.out.println("Ȧ�� �� : " + sum1);
			System.out.println("��ü �� : " + (sum1+sum2));
		}

	}

	// 2. 1���� 100������ ���� 3�� ����� ����
	public static class Q2 {

		public static void main(String[] args) {

			int i, sum=0;

			for(i=1; i<=100; i++) {
				if(i%3 == 0) { //1����100������ �� �߿��� 3���� �������� �� �������� 0�� �ɶ����� sum�� ������Ų��.
					sum++;
				}
			}
			System.out.println("3�� ����� ����:" + sum);
		}
	}

	//  3. �μ��� �Է¹޾� ���� ������ ū�������� ��
	//  1~100 ������ �� : 5050
	public static class Q3 {

		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);

			int num1, num2, sum = 0, i = 0;

			System.out.println("ù��° �� �Է� : ");
			num1 = sc.nextInt();
			System.out.println("�ι�° �� �Է� : ");
			num2 = sc.nextInt();

			for(i=num1; i<=num2; i++) {
				sum += i;
			}
			System.out.println(sum);

		}

	}
}
