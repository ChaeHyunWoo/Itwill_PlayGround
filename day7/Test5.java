package com.day7;

//������
//����� ����
// 1. ��ü����, 2. ���� �ʱ�ȭ ����
//�޸� �Ҵ��� ���� �� ����� �ϰ� �����ڴ� class�� �̸��� ����
//���ϰ��� ���� ������ property�� �ʿ� ����.
//�����ڴ� �ߺ�����(overloading)�� �����ϴ�.
//������ �ȿ��� �����ڸ� ȣ���� �� �ִ�.
//�� ȣ�� �� ���� ���ο����� ȣ�� �����ϴ�.// �����ڴ� �⺻������ �����Ǿ� �ִ�.
public class Test5 {
	
	private int x;
	
	public Test5() {// �⺻ ������ // �����ڴ� �⺻������ �����Ǿ� �ִ�.
		
		this(50); // = Test5(int x)
		System.out.println("�⺻ ������...");
		x = 10;
		System.out.println("x : " + x);
	}
	
	public Test5(int x) {
		
		System.out.println("�����ε��� ������...");
		this.x = x;
		System.out.println("x : " + x);
	}
	
	public static void main(String[] args) {
		
		Test5 ob1 = new Test5();
		Test5 ob2 = new Test5(50);
		
	}

}
