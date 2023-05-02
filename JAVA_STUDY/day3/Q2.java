package com.day3;
//2. 1에서 100까지의 수 중에 3의 배수의 갯수 출력하기
public class Q2 {

	public static void main(String[] args) {
		
		int i, sum=0;
		
		for(i=1; i<=100; i++) {
			if(i%3 == 0) { // 3으로 나누었을 때 나머지가 0인 수
				sum++;     //3의 배수가 나올 때마다 sum을 1씩 증가
			}
		}
		System.out.println("3의 배수의 개수 :" + sum);
	}
}