package com.day1;

public class Test3 {

	public static void main(String[] args) {
		
		int r = 10;
		float area, length;//�Ǽ���
		
		area = r * r * 3.14f;
		length = r * 2 * 3.14f;
		
		System.out.println(area); //���� �ʺ�
		System.out.println(length); //���� �ѷ�
		
		System.out.println("������ : " + r + ", ����: " + area);
		
		System.out.printf("������ : %d, ���� :%.2f\n", r, area);
		//%f���� �Ҽ��� 2��°¥������ �������� %.2f�� ����.
		
		//-------------------------------------------
		
		// float�� int�� ���� 4byte������ float�� ��ũ��/java�� 2���� ����x
		int a=5;
		float b;
		
		b=a; // �Ͻ��� ����ȯ
		System.out.println(b);//5.0
		//�ݴ���ϸ� ���� why? float�� int���� �� ũ�⶧�� 
		//ū���� �����Ϳ� �� �� ����.
		
		a = (int)b;  //���� ����ȯ
		System.out.println(a);//5
		
	}

}