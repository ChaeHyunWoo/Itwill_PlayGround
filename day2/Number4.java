package com.day2;
//년도를 입력받고, 윤년인지 아닌지를 출력.
//예) 2010 입력시 -> 2010 => 평년
//    2012 입력시 -> 2012 => 윤년
import java.util.*;

public class Number4 {

	public static void main(String[] args) {
		
		Scanner result = new Scanner(System.in);
		
		int num1;
		
		System.out.println("년도를 입력 : ");
		num1 = result.nextInt();
		
		String str;
		
		//str = num1%2==0?"짝수":"홀수";
		
		//str = num1>0?"양수":(num1<0?"음수":"영");
		
		str = num1%4==0 && num1%100!=0 || num1%400==0?"윤년":"평년";
		
		System.out.println(num1 + "=> " + str);
	}
}