package com.day3;

public class Test4 {

	public static void main(String[] args) {
		
		// 다중 for문
		
		int i, j;
		
		for(i=2; i<=9; i++) { //2단~9단
			
			
			System.out.println(i + "단");
			
			
			for(j=1; j<=9; j++) { //ex) 2단일때 1부터 9까지 9번을 돌게된다 (2*1 ~ 2*9)
				
				//System.out.println(i + "*" + j + "=" + (i*j));
				System.out.printf("%d * %d = %d %n", i, j, (i*j));
			}
			
			System.out.println("----------------");
		}
	}
}