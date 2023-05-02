package com.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//계산기 만들기 : 오로지 String의 메소드만 사용하기
public class Test7 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.print("수식[3+5] : ");
		String str = br.readLine();
		
		str = str.replaceAll("\\s", ""); // 공백제거
		//System.out.println(str);
		
		//String [] oper = {"+", "-", "*", "/"};
		//for(String op : oper) {
		for(String op : new String [] {"+", "-", "*", "/"}) {
			
			int pos = str.indexOf(op); // op가 있는 자리의 index 번호를 가져와라
			
			if(pos>-1) {
				
				int num1 = Integer.parseInt(str.substring(0, pos));
				int num2 = Integer.parseInt(str.substring(pos+1));
				
				//System.out.println(num1 +":"+ num2); 중간체크
				
				int result = 0; //결과값을 담을 변수
				char oper = str.charAt(pos);
				
				switch(oper) {
				
				case '+' :
					result = num1 + num2;
					break;
				case '-' :
					result = num1 - num2;
					break;
				case '*' :
					result = num1 * num2;
					break;
				case '/' :
					result = num1 / num2;
					break;

				}
				
				//System.out.printf("%d %c %d = %d", num1, oper, num2, result);
				
				//모양을 만들어서 변수를 만들어놓고 리턴값을 받아 원하는 위치에 출력
				String sf = String.format("%d %c %d = %d", num1, oper, num2, result);
				System.out.println(sf);

			}		
		}
	}
}