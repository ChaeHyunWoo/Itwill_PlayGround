package com.day5;

public class Test5 {

	public static void main(String[] args) {
		
		int [][] a = {{5,3,6}, {2,7,8}, {5,1,7}};
		int [][] b = {{6,9,3}, {1,5,9}, {2,7,9}};
		int [][] sum = new int [3][3];
		
		int i, j;
		
		for(i=0; i<a.length; i++) {
			for(j=0; j<b.length; j++) {
				
				sum[i][j] = a[i][j] + b[i][j];
				
				System.out.printf("%4d", sum[i][j]);
			}
			System.out.println();
		}

		System.out.println();
	}
}
// ¹è¿­ ³¡