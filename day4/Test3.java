package com.day4;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		// selection sort(선택정렬)
		//int [] num = {50, 42, 37, 26, 5};		// 정해진 5개의 정수를 생성해서 정렬하는법
		
		Scanner sc = new Scanner(System.in);	//5개의 수를 사용자한테 입력받는법
		
		int i,j,temp;
		int[] num = new int [5];
		
		System.out.print("5개의 수를 입력 : ");
		
		for(i=0; i<num.length; i++) {
			num[i] = sc.nextInt();
		}
	
		System.out.print("Source Data: ");
		for(i=0; i<num.length; i++) {
			System.out.printf("%4d", num[i]);	
		}
		System.out.println();
		System.out.println("----------------------------------");
		
		//-----------------------------------------------------------------------------------
		//Selection Sort
		//선택 정렬 기본 공식 (암기 필수)!!이중for문
		
		for(i=0; i<num.length-1; i++) {
			
			for(j=i+1; j<num.length; j++) {
				//System.out.println(i + ":" + j);
				if(num[i]>num[j]) {
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
					
				}
			}
			
		}
		//------------------------------------------------------------------
		
		//확장 for문 @검색해서 찾아보기
		System.out.print("Sorted Data: ");
		for(int k : num) {					// 배열일 때만 쓰는 for문
			System.out.printf("%4d", k);	// 배열 for문에서는 자동으로 수를 가져와서 넣어준다
		}
		System.out.println();
	}

}
