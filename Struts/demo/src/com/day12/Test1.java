package com.day12;
//Test1~3�� ������ ���� ���ֻ����ϰ� Test4�� ���� ����� - ũ�� 1~3�� ũ�� �߿� x
/*
 1. ����Ŭ����(Inner) - Ŭ���� �ȿ� Ŭ������ ��
��� :Ŭ�����ȿ� Ŭ���� / �޼ҵ�ȿ� Ŭ����/ Ŭ������ static���� ����� / ������ Ŭ����
*/

class Outer1 { // Outer1Ŭ���� �ȿ� Inner1Ŭ������ ��
	
	static int a = 10;//Ŭ���� ����
	int b = 20; // instance����(�Ű�����)
	
	public class Inner1 {// Outer1Ŭ���� �ȿ� Inner1Ŭ������ ��
		
		int c = 30;
		
		public void write() { // InnerŬ���� �޼���
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
		}
	}
	
	public void print() { // Outer1 Ŭ���� �޼���
		
		Inner1 ob = new Inner1(); //��ü ����
		ob.write();
	}
}
public class Test1 {

	public static void main(String[] args) {
		
		Outer1 out = new Outer1();//Outer ��ü����� -  �ܺ�Ŭ���� ��ü�� ���� �����Ǿ���
		out.print();
		
		Outer1.Inner1 in = out.new Inner1();
		in.write();

	}

}