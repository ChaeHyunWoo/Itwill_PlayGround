package com.day3;

public class Test5_1 {

	public static void main(String[] args) {
		
		int i, j;
		
		//*찍기 모래시계 모양
		for(i=5; i>=1; i--) {
			
			for(j=1; j<=5-i; j++) {
				System.out.print(" ");
			}
			
			for(j=1; j<=i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(i=2; i<=5; i++) {
			
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