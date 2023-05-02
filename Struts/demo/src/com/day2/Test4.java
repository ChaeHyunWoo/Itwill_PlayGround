package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {

	public static void main(String[] args) throws IOException {
		
		//=제어문, 반복문
		//조건문(제어문) : for문, switch문
		//반복문 : while문, for문, do-while문, 
	
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		int num;
		String str = "";
		
		System.out.println("숫자 입력 : ");
		num = Integer.parseInt(br.readLine()); //예외처리해야하고 반환하는값은 문자라서 int로 형변환
		
		/*//if문 조건(단일 if문)
		if(num%2 == 0) {
			str = "짝수";
		}
		if(num%2 != 0) {  // != 0 이라써도되고 == 1이라 써도됨 
			str = "홀수";
		} */
		
		if(num %2 == 0) {
			str = "짝수";
		} else {
			str = "홀수";
		}
		
		System.out.println(num + ":" + str); //Initialize variable 변수값 초기화 하라는 오류
		
	}

}
