package com.day3;

public class Test3 {

	public static void main(String[] args) {
		
		int n, sum;
		
		
		//1���� 100������ ��
		sum = 0;
		for(n=1; n<=100; n++) {
			sum += n;
		}
		System.out.println("1���� 100������ �� : " + sum);
		
		//Ȧ���� ��
		sum = 0;
		for(n=1; n<=100; n += 2) {
			sum += n;
		}
		System.out.println("1���� 100���� Ȧ���� �� : " + sum);
		
		//¦���� ��
		sum = 0;
		for(n=0; n<=100; n+=2) {
			sum += n;
		}
		System.out.println("1���� 100���� ¦���� �� : " + sum);
		
		//3�� ����� ��
		sum = 0;
		for(n=3; n<=100; n+=3) {
			sum += n;
		}
		System.out.println("1���� 100���� 3�� ����� �� : " + sum);
	}
}