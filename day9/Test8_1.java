package com.day9;

import java.io.IOException;
import java.util.Scanner;

class Result1{

	public void print(String r) {
		System.out.println(r);
	}
}

class Calc1 extends Result1{

	int num1,num2;
	String num;
	char op;

	public void input() throws IOException {

		Scanner sc = new Scanner(System.in);

		System.out.println("두개의 수[?,?]");
		num = sc.next();
		String[] ss = num.split(",");
		num1 = Integer.parseInt(ss[0]);
		num2 = Integer.parseInt(ss[1]);

		System.out.println("연산자?");
		op = (char)System.in.read();

	}

	public String calc() {

		int result = 0;

		switch(op) {
		case '+' :
			result = num1 + num2;
			break;
		case '-' :
			result = num1 - num2;
			break;
		case '*' :
			result = num1 + num2;
			break;
		case '/' :
			result = num1 + num2;
			break;

		}
		
		String s = String.format("%d %c %d = %d",num1,op,num2,result);
		
		return s;
	}




}
public class Test8_1 {

	public static void main(String[] args) throws IOException {
		
		Calc1 ob = new Calc1();
		
		ob.input();
		String r = ob.calc();
		ob.print(r);

	}

}