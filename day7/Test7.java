package com.day7;
// static�� ���� ���� ����ǰ� �����ڰ� ���� �ʰ� ����ȴ�.  �ν��Ͻ������� new�� ������ ����ȴ�.
public class Test7 {
	
	int a = 5; // �ν��Ͻ� ���� (���or���� ����)
	
	//��ü�� �����Ǹ� �ٷ� ����Ǵ� instance ��
	{ // �ʱ�ȭ �� -  �޼���� ȣ�������� �ʴµ� ������ ����� ��. instance. ��ü�� �����ؾ� �� �� ����
		System.out.println("�ʱ�ȭ �� : a ->" + a); // 5
		a = 10;
		System.out.println("�ʱ�ȭ ��:a ->" + a);
	}
	
	static int b; // Ŭ��������. �޸� �Ҵ��� �Ǿ� ���� 
	
	static { // static ��
		b = 10;
		System.out.println("static ��b : " + b);
	}
	
	final int C; //����� �빮��
	
	
	public Test7() {
		System.out.println("������...");
		C = 100;
		System.out.println("C : " + C);
	} // �̷� ��쿡 ���� �������� �����Ǵ� ���� ������
	
	
	public static void main(String[] args) {
		
		Test7 ob1 = new Test7(); // ��ü���� - static ���� ���� ���� �����ȴ�.
		Test7 ob2 = new Test7(); // ��ü 2�� ���� �� static�� ��ü�� ������ ���� �ѹ��� ������� why? �޸𸮸� ���̾��ϱ�

	}

}
