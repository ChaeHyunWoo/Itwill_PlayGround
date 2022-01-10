package com.excep;
//Day14에 했던 예제

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CalcExcep {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		double num1, num2, result;
		
		OperationAuthenticator auth = new OperationAuthenticator(); // 객체 생 성
		
		try {
			
			System.out.print("두 개의 수[a,b]");
			str = br.readLine(); // 입력받은 문자 읽기
			
			auth.inputFormat(str);// 갔다가 문제 없으면 다시 오고 문제가 있으면 MYException으로 감
			
			String[] temp = str.split(",");
			
			auth.number(temp[0]);
			
			//입력한게 정상이면
			num1 = Double.parseDouble(temp[0]);
			
			auth.number(temp[1]); // 1번째 자리가 정상이면 
			num2 = Double.parseDouble(temp[1]);
			
			System.out.print("연산자 : ");
			str = br.readLine();
			
			//연산자를 여러개 입력할 수 있으니
			auth.operator(str.charAt(0));// 여러개 있어도 0번째 index 1개를 보내라
			
			char ch = str.charAt(0);
			
			result = 0;
			
			if(ch == '+')
				result = num1 + num2;
			else if(ch == '-')
				result = num1 - num2;
			else if(ch == '*')
				result = num1 * num2;
			else if(ch == '/')
				result = num1 / num2;
			
			System.out.printf("%g %c %g = %g\n", num1, ch, num2, result);
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
