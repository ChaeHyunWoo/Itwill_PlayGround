package com.day5;

import java.util.Scanner;

public class Rect {	//Ŭ����
	
	int w, h; // instance����(��������)
	
	
	public void input() {	//input�޼ҵ�
		
		Scanner sc = new Scanner(System.in);
		
		//int w,h; // ��������(���ú���)
		System.out.print("���� : "); //10
		w = sc.nextInt();
		
		System.out.print("���� : ");//5
		h = sc.nextInt();
		
		
		return; //����
	}
	
	
	public int area() {
		
		int result; //��������
		result = w * h;
		
		return result;
	}
	
	
	public int length() {
		
		return (w+h) * 2;
	}
	
	public void print(int area, int length) { // int area()�� void print���� a�� l�� ������
		
		System.out.println("���� :" + w);
		System.out.println("���� :" + h);
		System.out.println("���� :" + area);
		System.out.println("�ѷ� :" + length);
	}

}
