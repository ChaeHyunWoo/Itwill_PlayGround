package com.day12;

// 2. ����Ŭ����(Local)
// �޼ҵ� �ȿ� Ŭ����

class Outer2 { // Outer2Ŭ����
	
	static int a = 10; 
	int b = 20;
	
	public void write() { // write�޼ҵ�
		
		int c = 30;	//��������
		final int d = 40;
		
		class Inner2 {  // �޼ҵ� �ȿ� �ִ� Inner2Ŭ����
				
			public void print() {
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				System.out.println(d);
			}
			
		}
		
		Inner2 ob = new Inner2(); // �޼ҵ� �ȿ����� ��ü���� ����
		ob.print();
	}
}
public class Test2 {
	//�޼ҵ� �ȿ��ִ� Ŭ������ �޼ҵ� �ȿ����� ��ü������ �����ϴ�.
	public static void main(String[] args) {
		
		Outer2 out = new Outer2();
		out.write();

	}

}
