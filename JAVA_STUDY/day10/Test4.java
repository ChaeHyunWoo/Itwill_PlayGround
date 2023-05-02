package com.day10;

import java.util.Calendar;
import java.util.Scanner;

//문제4번
//사용자한테 년, 월, 일을 입력받아 100(x)일 후 년,월,일(요일) 모양으로 출력하기
		/* 예시
		 
		년도? 2016
		월? 4
		일? 20
		몇일후? 100

		만 난 날 : 2016년 4월 20일 수요일
		100일 후 : 2016년 7월 29일 금요일
				*/
public class Test4 {

	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		String[] weeks = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
		
		int year, month, day, whenday, week; 
		
		do {
			System.out.print("년도 : "); // 2021
			year = sc.nextInt();
		} while(year < 1);	// 년도는 1보다 작으면 안된다.

		do {
			System.out.print("월 : "); //12월
			month = sc.nextInt();
		} while(month < 1 || month > 12); //|| -> OR(또는) -> month가 1보다 작거나 12보다 크면
		
		do {
			System.out.print("일 : "); // 25일
			day = sc.nextInt();
		} while(day < 1 || day > 31);
		
		System.out.print("몇일 후? : ");
		whenday = sc.nextInt();
		now.set(year, month - 1, day);//  now.set(연도, 월, 일) - set() : 달력 필드에 값을 입력할 때 사용
		week = now.get(Calendar.DAY_OF_WEEK); // - DAY_OF_WEEK : 요일 (일(1)~토(7))
		
		System.out.println("만난 날 : " + year + "년 " + month + "월 " + day + "일 " + weeks[week-1] + "요일");
		
		now.add(Calendar.DATE, whenday); 
		year = now.get(Calendar.YEAR); //년
		month = now.get(Calendar.MONTH) + 1; // 월(0~11) + 1
		day = now.get(Calendar.DATE); // 일
		week = now.get(Calendar.DAY_OF_WEEK); // 주의 수(1~7) 1:월요일 ~ 7:일요일
		
		System.out.println(whenday + "일 후 : " + year + "년 " + month + "월 " + day + "일 " + weeks[week-1] + "요일");

	}

}