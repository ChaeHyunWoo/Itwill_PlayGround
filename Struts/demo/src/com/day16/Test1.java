package com.day16;

import java.io.IOException;

//Stream
//������ ����� �� ��� �����͸� ���¿� ������� �Ϸõ� �帧���� �����ϴ� �� - ����������

//in 
public class Test1 {

	public static void main(String[] args) throws IOException {
		
		int data;
		
		System.out.print("���� �Է� : "); // dfd235
					//System.in,read�� �ڹٿ��� �����ϴ� �Է� Stream
		while((data = System.in.read()) != -1) {// 1����Ʈ ���� 1���� �о��
			
			char ch = (char)data;
			System.out.print(ch);
		}
		
	}

}