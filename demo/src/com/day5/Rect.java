package com.day5;

import java.util.Scanner;

public class Rect {	//Ŭ����
	
	int w, h; // instance����(��������) : Ŭ���� �� ��𼭳� ��� ������ ��������
	
	
	public void input() {	//input�޼ҵ�
		
		Scanner sc = new Scanner(System.in);
		
		//int w,h; // ��������(���ú���)
		System.out.print("���� : "); //10
		w = sc.nextInt();
		
		System.out.print("���� : ");//5
		h = sc.nextInt();
		
		
		//return;  void�� �����س��� ������ return ���� ����
	}
	
	
	public int area() {	//return���� ������
		
		int result; //�������� : �ٸ� �޼ҵ忡�� �ν� ����
		result = w * h;
		
		return result;
	}
	
	
	public int length() {	//return���� ������
		
		return (w+h) * 2;// ���������� ���� ��ȯ�ص� ������, return���� �ٷ� ������� �־ ���� ����
	}
	
	public void print(int area, int length) { // int area()�� void print���� a�� l�� ������
											  // ��ȯ������.�Ű����� 2�� �ʿ�.�޼ҵ带 �����ϰ� ����
		System.out.println("���� :" + w);
		System.out.println("���� :" + h);
		System.out.println("���� :" + area);
		System.out.println("�ѷ� :" + length);
	}

}