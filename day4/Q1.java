package com.day4;
/*
1번문제
5개의 정수를 입력받아 입력받은 수를 출력하고 입력받은 수 중에 가장 큰 수와 적은수를 출력
 */
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a,b,c,d,e,max=0,min=0;

		System.out.print("5개의 정수를 입력하세요 ?");

		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		d=sc.nextInt();
		e=sc.nextInt();

		max = min = a;

		if(a > max)
		max = a;

		if(a < min)
		min = a;

		if(b > max)
		max = b;

		if(b < min)
		min = b;

		if(c > max)
		max = c;

		if(c < min)
		min = c;

		if(d > max)
		max = d;

		if(d < min)
		min = d;
		
		if(e > max)
			max = e;

		if(e < min)
		min = e;


	System.out.println("제일 큰 숫자 "+ max +", 제일 작은 숫자 "+ min);

	}

}


