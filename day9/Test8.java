package com.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

	public void print(String r) {
		System.out.println(r);
	}
}
// ---------------------------------------------------���� �״�� �� ���¿��� �����

class Calc extends Result {

	private int num1, num2, r; // ����1, ����2, ������
	private char oper; // ������(����)
	//private String result, str;

	public void input() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("����[3+5] : ");
		String str = br.readLine();
		str = str.replaceAll("\\s", ""); // ��������
		for(String op : new String [] {"+", "-", "*", "/"}) {
			
			int pos = str.indexOf(op); // op�� �ִ� �ڸ��� index ��ȣ�� �����Ͷ�
			
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