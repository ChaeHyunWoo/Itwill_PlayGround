package com.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//밑변(width)와 높이(height)를 입력받아 삼격형 넓이(a) 구하기
		//밑변? : 10
		//높이? : 10
		//넓이? : xx
		//넓이 = 밑변 * 높이 / 2
		
		
		int width, height;
		double a;
		
		
		System.out.println("밑변의 길이는?");
		width = Integer.parseInt(br.readLine());
		
		System.out.println("높이는?");
		height = Integer.parseInt(br.readLine());
		
		a = width * height/2.0;
		
		System.out.println("넓이는? " + a);
		
	}

}