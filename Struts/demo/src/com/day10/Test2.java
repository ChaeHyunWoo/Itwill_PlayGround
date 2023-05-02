package com.day10;

import java.util.Calendar;

public class Test2 {

	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		
		int y = now.get(Calendar.YEAR); //년
		int m = now.get(Calendar.MONTH) + 1; // 월(0~11) + 1
		int d = now.get(Calendar.DATE); // 일
		int w = now.get(Calendar.DAY_OF_WEEK); // 주의 수(1~7) 1:월요일 ~ 7:일요일
		
		String[] week = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
		System.out.println(y + "-" + m + "-" + d + "-" + week[w-1]);
		
		//달의 마지막날 구하기
		int startDay = now.getActualMinimum(Calendar.DATE);
		int lastDay = now.getActualMaximum(Calendar.DATE);
		
		System.out.println(startDay + "월 마지막날:" + lastDay + "일");
		
		System.out.printf("%tF\n", now); // 2022-01-04 -> 현재 년-월-일 출력
		System.out.printf("%tT\n", now); // 11:48:38   -> 현재 시간 출력
		System.out.printf("%1$tF  %1$tT\n", now); // 위의 2줄을 1개로 합침. 1$로 합친다.
		
		// 월(0~11)  Calendar에 넣을 때는 -1해주고 꺼낼 때는 +1 해줘야함
		now.set(2021,10-1,10);
		
		y = now.get(Calendar.YEAR); //년
		m = now.get(Calendar.MONTH) + 1; // 월(0~11) + 1
		d = now.get(Calendar.DATE); // 일
		w = now.get(Calendar.DAY_OF_WEEK); // 주의 수(1~7) 1:월요일 ~ 7:일요일
		
		System.out.println(y + "-" + m + "-" + d + "-" + week[w-1]);
		
		
	}

}