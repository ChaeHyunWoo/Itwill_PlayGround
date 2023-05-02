package com.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

	public void print(String r) {
		System.out.println(r);
	}
}
// ---------------------------------------------------위에 그대로 한 상태에서 만들기

class Calc extends Result {

	private int num1, num2, r; // 숫자1, 숫자2, 연산결과
	private char oper; // 연산자(문자)
	//private String result, str;

	public void input() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("수식[3+5] : ");
		String str = br.readLine();
		str = str.replaceAll("\\s", ""); // 공백제거
		for(String op : new String [] {"+", "-", "*", "/"}) {
			
			int pos = str.indexOf(op); // op가 있는 자리의 index 번호를 가져와라
			
			if(pos>-1) {
				
				int num1 = Integer.parseInt(str.substring(0, pos)); 
				int num2 = Integer.parseInt(str.substring(pos+1));
			}
		}
	}

	public String calc() {
		
		switch(oper) {
		
		case '+' :
			r = num1 + num2;
			break;
		case '-' :
			r = num1 - num2;
			break;
		case '*' :
			r = num1 * num2;
			break;
		case '/' :
			r = num1 / num2;
			break;

		}
		
		String result = String.format("%d %c %d = %d", num1, oper, num2, r);
		return result;
	}

}

public class Test8 {

	public static void main(String[] args) throws IOException {
		
		Calc ob = new Calc();
		ob.input();
		String r = ob.calc();
		ob.print(r);

	}
}