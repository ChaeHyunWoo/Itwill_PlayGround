package com.day3;

public class Test5 {

	public static void main(String[] args) {
		
		int i, j;
		
		
		// ���ﰢ�� ����� 
		for(i=1; i<=5; i++) {
			
			for(j=1; j<=5-i; j++) {
				System.out.print(" ");
			}
			
			for(j=1; j<=i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		//���ﰢ��
		for(i=5; i>=1; i--) {
			
			for(j=1; j<=5-i; j++) {
				System.out.print(" ");
			}
			
			for(j=1; j<=i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}