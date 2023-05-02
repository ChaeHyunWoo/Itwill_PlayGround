package com.day4;

import java.util.Scanner;

public class Q1_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] su = new int[5];
		int i,max,min;


		System.out.print("5개의 정수를 입력하세요.");


		for(i=0;i<su.length;i++){

			su[i] = sc.nextInt();
		}

		//max와 min구할때 사용
		//값을 넣어놓고 다른 수와 비교
		max=min=su[0];

		for(i=1;i<su.length;i++){
			if(max<su[i])
				max=su[i];
			if(min>su[i])
				min=su[i];
		}
		System.out.printf("가장 작은수 : %d, 가장 큰수 %d",min,max);	
		System.out.println();	
	}
}