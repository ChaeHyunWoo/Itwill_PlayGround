package com.day10;

class  Test { //�θ� Ŭ����(Test)
	
	protected int a = 10, b = 20;
	
	public void write() { // �޼���  void�־ ��ȯ�� �ʿ����
		
		System.out.println("Super Class write()...");
		System.out.println("a: " + a + ", b: " + b);
	}
}

class Demo extends Test { // �ڽ� Ŭ����(Demo)
	
	protected int b = 30, c = 40;
	
	//�θ��� �޼��带 override�ϱ�
	@Override //�������̵��ϸ� ������ ������ ��������.
		public void write() { //override�ϴ� ���� �θ� write, �ڽĵ� write�� ���� �־� �ڽĲ��� ���� ����.(�������� ����)
			System.out.println("Sub Class write()");
			System.out.println("a: " + a + ", b: " + b + ", c: " + c);
			System.out.println("super.b: " + super.b); // 20
		}
	
	public void print1() { // �޼���
		System.out.println("Sub Class print1()���� write()ȣ��...");
		write();
	}
	
	public void print2() { // �޼���
		System.out.println("Sub Class print1()���� write()ȣ��...");
		super.write(); // super�� �Ἥ �θ�(Test)�� write()�� ����.
	}
}
public class Test5 {

	public static void main(String[] args) {
		
		Demo ob = new Demo();
		ob.write();
		ob.print1();
		ob.print2();
		
		System.out.println("ob.b : " + ob.b); //30 �θ� �ְ� ���� ������ ���� ����.
		System.out.println("((Test)ob).b : " + ((Test)ob).b);
		System.out.println("=============================");
		((Test)ob).write();
	}

}
