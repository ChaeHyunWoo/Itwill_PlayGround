package com.day14;

import java.util.Scanner;

/* 예외 처리( try - catch 문)
Exception
*/
public class Test2 {

	public static void main(String[] args) {
		
		int num1, num2, result;
		String oper;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("두 개의 수 : ");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			
			System.out.print("연산자 : ");
			oper = sc.next();
			
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
			 //try에서 에러가 발생하면 catch문이 오류를 잡아내고 Exception이 오류처리한 결과를  매개변수 e한테 반환해줌
			
		} catch (NumberFormatException e) {
			System.out.println("정수를 입력해라");
			
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
			
		} catch (Exception e) { //Exception을 가장 위에 쓰면 에러뜸 why ? -> 위로 가면 아래 애들이 할일이 없어짐
			System.out.println("넌 그게 숫자로 보이냐~~?");
			System.out.println(e.toString());// 이걸 많이쓴다   java.util.InputMismatchException
			e.printStackTrace();
			
		} finally {
			System.out.println("언제든지 실행된다.");
		}
		
		System.out.println("catch문 밖....");
		
		
	}
}