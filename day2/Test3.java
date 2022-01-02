package com.day2;

import java.io.IOException;

public class Test3 {

	public static void main(String[] args) throws IOException {
		
		//@@자료형 char / String은 항상 "" 큰따옴표 써야함
		//String str = "hyuen woo";
		
		//@@char에서는 ''작은 따옴표를 써야하고 1바이트 or 2바이트 문자 1개만 저장 가능.(오로지 한 자만 저장 가능)
		char ch, result;
		
		System.out.println("한개의 문자?"); //a(97) 아스키 코드값
		
		ch = (char)System.in.read();//알파벳 한 자를 읽어내는 명령어 //read()의 반환값은 int라서 (char)을 써서 형변환
		// @@97이라는 숫자를 받아오는데  ch는 문자만 받을수 있어 형변환을 통해 char로 바꿔야한다.
		
		//System.out.println(ch); // a 출력
		
		//System.out.println(Integer.toString(ch));
		//@@문자a를 입력했을때 그 문자의 아스키코드값을 보고싶을 때 쓴다. 그래서 97이 출력된다.
		
		
		//97
		result = ch>=65 && ch<=90?  (char)(ch+32):  // 
				//       조건   //
			(ch>='a' && ch<='z'?(char)(ch-32):ch);
		
		System.out.println(ch + ":" + result);
	}
	//삼항 연산자
	//(피연산자1) ? (피연산자2) : (값or연산식)
	//						true
//									false
	
	
}
