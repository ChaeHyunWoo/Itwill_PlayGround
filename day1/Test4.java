package com.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//     /패키지/클래스
public class Test4 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//? Scanner클래스랑 비슷해서 집가서 찾아보기 
		
		//System.in : 키보드로 입력한 1byte의 문자
		//InputStreamReader : System.in로 읽은 1byte를 문자(2byte)로 변경
		//BufferedReader : 메모리상에 저장 공간 생성 (위에서는 저장공간 이름을 br로 선언했음)
		//언제부터 읽냐 엔터(Enter)까지 읽음 
		
		
		
		int r;
		//double r;
		double area, length;
		
		System.out.println("반지름?"); 
		
		r = Integer.parseInt(br.readLine());
		//r = Double.parseDouble(br.readLine());
		
		//Integer.parseInt 숫자(정수)로바꾼다/ 바꾼 후 r에 넣는다
		area = r * r * 3.14; // 위에서 area를 double로 선언해서 오류 안뜸
		length = r * 2 * 3.14;
		
		System.out.println("반지름 : " + r);
		System.out.println("넓이 : " + area);
		System.out.println("둘레 : " + length);
	
	}
}