package com.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//�غ�(width)�� ����(height)�� �Է¹޾� ����� ����(a) ���ϱ�
		//�غ�? : 10
		//����? : 10
		//����? : xx
		//���� = �غ� * ���� / 2
		
		
		int width, height;
		double a;
		
		
		System.out.println("�غ��� ���̴�?");
		width = Integer.parseInt(br.readLine());
		
		System.out.println("���̴�?");
		height = Integer.parseInt(br.readLine());
		
		a = width * height/2.0;
		
		System.out.println("���̴�? " + a);
		
	}

}