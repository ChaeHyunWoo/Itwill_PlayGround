package com.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//     /��Ű��/Ŭ����
public class Test4 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//? ScannerŬ������ ����ؼ� ������ ã�ƺ��� 
		
		//System.in : Ű����� �Է��� 1byte�� ����
		//InputStreamReader : System.in�� ���� 1byte�� ����(2byte)�� ����
		//BufferedReader : �޸𸮻� ���� ���� ���� (�������� ������� �̸��� br�� ��������)
		//�������� �г� ����(Enter)���� ���� 
		
		
		
		int r;
		//double r;
		double area, length;
		
		System.out.println("������?"); 
		
		r = Integer.parseInt(br.readLine());
		//r = Double.parseDouble(br.readLine());
		
		//Integer.parseInt ����(����)�ιٲ۴�/ �ٲ� �� r�� �ִ´�
		area = r * r * 3.14; // ������ area�� double�� �����ؼ� ���� �ȶ�
		length = r * 2 * 3.14;
		
		System.out.println("������ : " + r);
		System.out.println("���� : " + area);
		System.out.println("�ѷ� : " + length);
	
	}
}