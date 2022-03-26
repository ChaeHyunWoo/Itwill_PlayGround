package com.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 예외를 의도적으로 발생시키는 방법 ( 자주 사용함) 중요!!!
public class Test3 {
										//2
		public static String getOper() throws Exception {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String oper = null;
			//String oper = ""; 위의 방법도 ㄱㅊ지만 보통 이방법으로 쓴다.
			
			try {
				
				System.out.print("연산자 : ");
				oper = br.readLine(); // 원래 에러뜨는데 catch문의 exception이 해결해줌
				
				if(!oper.equals("+") && !oper.equals("-") &&
						!oper.equals("*") && !oper.equals("/")) { // 양쪽이 부정이면 &&
					
					//사용자 정의 오류 -  위 문장이 아니면 오류를 발생시켜라.
					//사용자 정의를 사용하려면 이 문법을 사용하고 스로우 익셉션.
					throw new Exception("연산자 입력 오류!!"); //1. 선언 2.위 throws 익셉션이 두번째
				}
				
				
			} catch (IOException e) {
				System.out.println("입력 에러!!");
				
			}
			
			return oper; // oper를 반환
		}
		
		public static void main(String[] args) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int num1, num2, result;
			String oper;
			
			try {
				
				System.out.print("첫번째 수 : ");
				num1 = Integer.parseInt(br.readLine());
				System.out.print("두번째 수 : ");
				num2 = Integer.parseInt(br.readLine());
				
				oper = Test3.getOper();//3.오퍼에 객체생성을 할때 오류를 가져옴으로
				
				result = 0;
				
				if(oper.equals("+")) { // oper은 String이라 equals로 비교
					result = num1 + num2;
				} else if (oper.equals("-")) {
					result = num1 - num2;
				} else if (oper.equals("*")) {
					result = num1 * num2;
				} else if (oper.equals("/")) {
					result = num1 / num2;
				}
				
				System.out.printf("%d %s %d = %d\n", num1, oper, num2, result);
				
			} catch (Exception e) { //4.여기서 오류를 처리하고 스트링으로 출력한다.
				
				System.out.println(e.toString());
				
			}		
	}
}