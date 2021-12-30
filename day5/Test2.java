package com.day5;

public class Test2 {

	public static void main(String[] args) {
		
		//버블정렬
		
		int [] num = {37, 26, 19, 12, 7};
		
		int i, j, temp;
		
		System.out.print("Source Data:");
		for(i=0; i<num.length; i++) {
			System.out.printf("%4d", num[i]);
		}
		System.out.println();
		
		//Bubble Sort
		for(i=1; i<num.length; i++) {
			for(j=0; j<num.length-i; j++)
				
				if(num[j] > num[j+1]) {
					temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
		}
		
		System.out.print("Sorted Data:");
		for(int s : num) {
			System.out.printf("%4d", s);
		}
		System.out.println();
	}

}
