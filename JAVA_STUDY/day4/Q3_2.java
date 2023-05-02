package com.day4;

import java.util.Random;
import java.util.Scanner;

public class Q3_2 {

	public static void main(String[] args) {

		/*
		 1~3사이의 난수를 발생시켜 가위,바위,보 게임 프로그램 작성 1:가위, 2:바위, 3:보
		 
		 예) 1:가위, 2:바위, 3:보 ?1 컴퓨터 :보 사람 :가위 당신이 이겼습니다
		  
		 1:가위, 2:바위, 3:보 ?1 컴퓨터 :바위 사람 :가위 컴퓨터가 이겼습니다
		 */

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		String[] a = { "가위", "바위", "보" };

		int c, d; // c: 컴퓨터, d: 사람

		c = rd.nextInt(3);

		System.out.print("1(가위), 2(바위) 3(보) 중 하나를 입력하세요");
		d = sc.nextInt() - 1;

		System.out.printf("컴퓨터: %s, 사람: %s %n", a[c], a[d]);

		if (c == d) {

			System.out.println("비겼습니다.");

		} else if (c + 2 == d || c - 1 == d) {

			System.out.println("컴퓨터가 이겼습니다.");

		} else {

			System.out.println("당신이 이겼습니다.");

		}

	}

}