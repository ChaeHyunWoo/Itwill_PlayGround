package com.day3;

public class Test3 {

	public static void main(String[] args) {
		
		int n, sum;
		
		
		//1부터 100까지의 합
		sum = 0;
		for(n=1; n<=100; n++) {
			sum += n;
		}
		System.out.println("1부터 100까지의 합 : " + sum);
		
		//홀수의 합
		sum = 0;
		for(n=1; n<=100; n += 2) {
			sum += n;
		}
		System.out.println("1부터 100까지의 홀수의 합 : " + sum);
		
		//짝수의 합
		sum = 0;
		for(n=0; n<=100; n+=2) {
			sum += n;
		}
		System.out.println("1부터 100까지의 홀수의 합 : " + sum);
		
		//3의 배수의 합
		sum = 0;
		for(n=3; n<=100; n+=3) {
			sum += n;
		}
		System.out.println("1부터 100까지의 3의 배수의 합 : " + sum);
	}

}
