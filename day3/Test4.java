package com.day3;

public class Test4 {

	public static void main(String[] args) {
		
		// ���� for��
		
		int i, j;
		
		for(i=2; i<=9; i++) { //2��~9��
			
			
			System.out.println(i + "��");
			
			
			for(j=1; j<=9; j++) { //ex) 2���϶� 1���� 9���� 9���� ���Եȴ� (2*1 ~ 2*9)
				
				//System.out.println(i + "*" + j + "=" + (i*j));
				System.out.printf("%d * %d = %d %n", i, j, (i*j));
			}
			
			System.out.println("----------------");
		}
	}
}