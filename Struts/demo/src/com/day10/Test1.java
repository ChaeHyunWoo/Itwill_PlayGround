package com.day10;

//Wrapper Ŭ����
//�⺻ �ڷ����� Ŭ������ ����� �� �ְ� ����
//�ڷ���
//boolean, byte, char, short, int, long, float, double
//Wrapper Ŭ����
//Boolean,Byte,Character, Short, Integer, Long, Float, Double

//Auto-Boxing(�ڷ��� ->WrapperŬ������ ��ȯ)
//Auto-unBoxing(WrapperŬ���� -> �ڷ������� ��ȯ:heap -> stack)
public class Test1 {

	public static void main(String[] args) {
		
		int n1 = 10;
		int n2;
		
		Integer num1;
		Integer num2 = new Integer(20);
		
		num1 = n1; //����ڽ�
		n2 = num2; //�����ڽ�
		
		System.out.println(n1 + ":" + num1);
		System.out.println(n2 + ":" + num2);
		
		int a = 24;
		System.out.println(a); // 24
		System.out.println(Integer.toString(a) + 10); //2410
		System.out.println(Integer.toString(a,2));//11000 (2������ ���)
		System.out.println(Integer.toString(a,16));//18 (16������ ���)
		
		
/*
 
int u = 10;
float f;

f = i; // �Ͻ��� ����ȯ
i = f; // �ȵ�
i = (int)f; // ����� ����ȯ. ū �����͸� �ֱ� ���ؼ��� �ݵ�� ����� ����ȯ �ʼ�

----------------------------------------------------------------------------------
�θ�(f) - �ڽ�(i)

�θ�(f) = �ڽ�(i);         o  UPCAST           �� �� �ִ�. why? �θ� �ڽĺ��� �� ū �����̱⶧��
�ڽ�(i) = �θ�(f);         x  
�ڽ�(i) = (�ڽ�)�θ�(f);   o  DOWNCAST
 */

	}

}