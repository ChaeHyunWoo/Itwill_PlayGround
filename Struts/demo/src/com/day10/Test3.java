package com.day10;
//문제1 번
//년월을 입력받아 Calendar클래스로 만년달력을 만들기

import java.util.Calendar;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {

		Calendar now = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);

		int year, month, week; // 년 ,월, i, 주

		do {
			System.out.print("년도 : "); // 2021
			year = sc.nextInt();
		} while(year < 1);	// 년도는 1보다 작으면 안된다.

		do {
			System.out.print("월 : "); //12월
			month = sc.nextInt();
		} while(month < 1 || month > 12); //|| -> OR(또는) -> month가 1보다 작거나 12보다 크면

		now.set(year, month - 1, 1);//  now.set(연도, 월, 일) - set() : 달력 필드에 값을 입력할 때 사용
		week = now.get(Calendar.DAY_OF_WEEK); // - DAY_OF_WEEK : 요일 (일(1)~토(7))
		int lastDay = now.getActualMaximum(Calendar.DATE);

		System.out.printf("----------%d년 %d월-----------", year, month);
		System.out.println();
		System.out.println("\n  일  월  화  수  목  금  토");
		System.out.println("------------------------------");

		for(int i = 1; i < week; i++) {										// 공백 1칸 = 2바이트	문자 = 2바이트
			System.out.print("    "); //공백 4칸 why? 위에서 공백2칸 일/공백2칸 화 이렇게 찍었는데 둘다 4바이트로 맞춘다.
		}

		for(int i = 1; i <= lastDay; i++) {
			System.out.printf("%4d", i); // %4d는 %d가 들어가는 공간은 4바이트로 만든다

			// 한 주의 날짜가 출력되면 줄바꿈
			week++;					//week는 일요일부터~토요일
			if(week % 7 == 1) 	// 토요일 다음으로 넘어갈때 줄바꿈해서 날짜 출력
				System.out.println();
			//한 달 내부 일(1)부터 토(7) 7로 나눴을때 줄바꿈
		}

		if(week % 7 != 1) {	// 한달이 끝났을때 줄바꿈해줌
			System.out.println();
		}
		System.out.println("------------------------------");
		sc.close();
	}	
}