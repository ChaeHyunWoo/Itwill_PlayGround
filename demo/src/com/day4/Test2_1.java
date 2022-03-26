package com.day4;

import java.util.Scanner;

public class Test2_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("연도를 입력하시오: ");
		int year = scan.nextInt();
		System.out.print("월을 입력하시오: ");
		int month = scan.nextInt();
		System.out.print("일을 입력하시오: ");
		int date = scan.nextInt();
		// 1. 주어진 연도에서 1900을 빼서 365를 곱한다.
		// 2. 연도에서 1900을 뺀 것을 4로 나누면 윤년의 횟수이므로 이 값을 더한다.
		int totalDays = ((year - 1900) * 365) + ((year - 1900) / 4);
		// 3. 주어진 연도가 윤년이고 주어진 월이 2월이나 1월이면 위의 결과에서 1을 뺀다.
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			if (month == 1 || month == 2) {
				totalDays--;
			}
		}

		// 실제 월로 하기때문에 index 0은 쓸 일이 없을 듯 하여 0으로 대체
		int[] monthDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// 4. 위의 결과에 주어진 월과 일까지의 날 수를 더한다. 예를 들어 1월 3일이면 3을 더한다.
		// 일단 전월까지를 모두 더하고
		for (int i = 1; i <= month - 1; i++) {
			totalDays += monthDays[i];
		}
		// 해당월의 일까지를 더한다.
		totalDays += date;
		String[] weeks = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
		
		// 5. 구한 날 수에 7을 나눈 나머지가 요일이 된다.
		System.out.printf("%d년 %d월 %d일은 %s입니다.", year, month, date, weeks[totalDays % 7]);
		scan.close();
	}
}