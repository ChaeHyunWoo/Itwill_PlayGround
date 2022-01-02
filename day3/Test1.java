package com.day3;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		//반복문(for, while, do-while)
		
		Scanner sc = new Scanner(System.in);
		
		int dan;
		
		System.out.print("단 입력 : ");
		dan = sc.nextInt();
		
		//for문 : 최소값,최대값 or 증가값을 정확히 알면 무조건 for문
		System.out.println("for문 이용");
		for(int i=1; i<=9; i++) {
			System.out.println(dan + "*" + i + "=" +(dan*i));
		}
		
		System.out.println("----------------------------");
		
		//while문 : 값이 정확하지 않을 때 사용
		System.out.println("while문 이용");
		int j=0;
		while(j<9) {
			j++; //증감식을 안쓰면 J=1이 무한반복됨. 증감식을 println밑에 넣으면 j *0부터 나와서 증감식은 위에
			System.out.println(dan + "*" + j + "=" + (dan*j));
			
		}
		System.out.println("----------------------------");
		
		//do-while문 : 먼저 사용자한테 정보를 요구하고  요구한 정보를 보고 확인 할 때 사용한다
		System.out.println("do-while문 이용");
		int k=0;
		do {
			k++;
			System.out.println(dan + "*" + k + "=" + (dan*k));
		} while(k<9);	
	}
}