package com.day1;

public class Test2 {
	
	public static void main(String[] args) {
		
		//���� ����
		//�ڷ��� int : ����(���� : ��-21�� ~ 21��) /�ڷ����� 8�� + String
		int a=10; // int�� ����a�� �����ϰ� 10���� �ʱ�ȭ
		int b=5;
		
		int c,d; // ������ ���� �������
		
		System.out.println(a); //10
		System.out.println(b); //5
		//System.out.println(c); // ������ ���� / �ڵ� �󿡴� �������µ� �����ϸ� �ߴ� ������ ��Ÿ�� ����.
		
		c = a + b;
		System.out.println(c);//15     // syso  Ȥ�� sout ���� ��Ʈ��+�����̽� (println)�ڵ��ϼ�
		
		d = a - b;
		System.out.println(d);//5
		
		System.out.println(a + "+" + b + "=" + c);
		System.out.println();
		System.out.println(a + "-" + b + "=" + d);
		
		//printf�� f�� format(���)�̴�.//%n�� �ٹٲ� \n�� �ᵵ�� 
		System.out.printf("%d + %d = %d %n", a, b, c);
		System.out.printf("%d - %d = %d\n", a, b, d);
		
	}

}