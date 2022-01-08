package com.day7;

//1. static�� new�� ������� �ʾƵ� �˾Ƽ� �޸𸮷� �ö󰣴�.
//2. static�� ��ü�� 100���� �����ǵ� �޸� ������ 1���� �����ȴ�.

//Test2 Ŭ����
public class Test2 {
	
	public static int a = 10; // Ŭ�������� : static�� �ִ� ����
	
	//Ŭ�������� �Ǵ� Ŭ���� �޼���� Ŭ������ �ε��Ǵ� ���� �޸� �Ҵ��� �̷������,
	// [Ŭ�����̸�.��ü]�� ���� ������ �� �ִ�.
	// ��, new�� ���� �޸� �Ҵ��� ���� �ʾƵ� ��� ����.
	
	private int b = 20; // �ν��Ͻ�����(�������,��������)
	// �ν��Ͻ� ���� �Ǵ� �ν��Ͻ��޼���� new�� ���� �޸𸮸� �Ҵ�޾ƾ߸�
	// ��밡���ϰ� �ٸ� �޼��忡���� ���� ���������� Ŭ���� �޼��忡���� ���� �Ұ���
	
	// �ν��Ͻ� �޼���
	public void write() {
		
		System.out.println("class ���� a : " + a);
		System.out.println("instance ���� b : " + b);
	}
	
	// Ŭ���� �޼��� - static�� ������ �ν��Ͻ��޼��忡�� Ŭ���� �޼��尡 �ȴ�.
	public static void print() {
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("class ���� a : " + a);//10
		System.out.println("class ���� a : " + Test2.a); // 10 Ŭ���� ����
		System.out.println("------------------------");
		//write();
		print(); // 10
		Test2.print(); // 10 Ŭ���� �޼���
		
		Test2 ob1 = new Test2(); // ��ü����. �ٽ� ���� ���� ����
		
		System.out.println("class���� a : " + ob1.a); // 10
		System.out.println("instance���� b : " + ob1.b); //20
		System.out.println("------------------------");
		
		//ob1.print();
		ob1.write();
		System.out.println("------------------------");
		
		Test2 ob2 = new Test2(); // ��ü����. �ٽ� ���� ���� ����
		ob2.a = 100;
		ob2.b = 200;
		ob2.write();
		System.out.println("------------------------");
		
		Test2 ob3 = new Test2(); // ��ü����. �ٽ� ���� ���� ����
		ob3.a = 1000;
		ob3.b = 2000;
		ob3.write();
		System.out.println("------------------------");
		
		ob1.write();
		ob2.write();
		ob3.write();
	}
}
/*
�������� �Ʒ��� �������鼭 �о�µ� static�� ������ ���ÿ� �޸𸮿� �ö󰡼� ���� / static�� ���¾ֵ���
new�� ������(��ü����) ����Ǽ� �ϴ� �н��ϸ鼭 �� �������� new�� ������ ��ü ������ ���ش�. �׸���
�ٽ� ���ΰ��� static�� ���� �ֵ��� ��������. static�� �ִ� �ֵ��� �̹� ���������� �н��Ѵ�.
*/