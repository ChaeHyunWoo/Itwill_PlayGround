package com.day4;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		//배열 시작!
		
		// 만년달력 만들기
		Scanner sc = new Scanner(System.in);
		
		//int [] months = new int [12]; 하단 처럼 배열 생성 가능 
		// 월별 날짜 수를 배열에 저장
		int [] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // = 12개
		
		int y, m, nalsu, i, week = 0;
		
		do {
			System.out.print("년도 : "); // 2021
			y = sc.nextInt();
		} while(y<1);	// 년도는 1보다 작으면 안된다.
		
		do {
			System.out.print("월 : "); //12월
			m = sc.nextInt();
		} while(m<1 || m>12); //월은 1보다 작으면 안되고 12보다 크면 안된다.
		
		//윤년에 따른 2월의 날 수
		if(y%4 == 0 && y%100 != 0 || y%400 == 0) {	//윤년을 구하는 공식
			months[1] = 29;	// 윤년이면 배열 [1]을 29로 바꾼다. 윤년이 아니면 [1]은 28이다.
		}
		
		//1년1월1일부터 사용자가 (y-1)년 12월 31일까지의 날 수 구하기  // &&는 빼기 ||는 더하기
		nalsu = (y-1)*365 + (y-1)/4-(y-1)/100 +(y-1)/400;//윤년 구하는 공식
		
		/*int yy = (y-1)/4-(y-1)/100 +(y-1)/400;
		System.out.println(nalsu); // 날 수
		System.out.println(yy); */
		
		
		//index : 0   1   2   3   4   5   6   7   8   9   10  11
		//배열 : {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
		//월(m) :  1   2   3   4   5   6   7   8   9  10  11  12
		
		//(m-1)월 말일까지의 날 수
		for(i=0; i<m-1; i++) {
			nalsu += months[i];
		}	
		
		nalsu += 1; //y년 m월1일
		
		// 주의수 계산
		week = nalsu % 7; // 3
		
		System.out.println(week);
		System.out.println("\n  일  월  화  수  목  금  토");
		System.out.println("------------------------------");
		
		for(i=0; i<week; i++) {										// 공백 1칸 = 2바이트	문자 = 2바이트
			System.out.print("    "); //공백 4칸 why? 위에서 공백2칸 일/공백2칸 화 이렇게 찍었는데 둘다 4바이트로 맞춘다.
		}
		
		for(i=1; i<=months[m-1]; i++) {
			System.out.printf("%4d", i); // %4d는 %d가 들어가는 공간은 4바이트로 만든다
						// 요일한글대신  wed fri 등 영어약어로 바꾸면 %4d대신 %3d 사용
			// 한 주의 날짜가 출력되면 줄바꿈
			week++;
				if(week%7 == 0) 	// 토요일 다음으로 넘어갈때 줄바꿈해서 날짜 출력
					System.out.println();
				}
		
				if(week%7 != 0) {
					System.out.println();
		}
				System.out.println("------------------------------");
	}
}