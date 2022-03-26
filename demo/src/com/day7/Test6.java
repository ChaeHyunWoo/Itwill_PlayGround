package com.day7;

class RectA {
	
	private int w, h; // �ν��Ͻ�����(��������)
	
	// private ���� �ʱ�ȭ ����� 2����. -> �ʱ�ȭ�޼��� �̿�, ������ �̿�
	
	//�⺻ ������
	public RectA() { }
	
	//Overoading�� ������
	public RectA(int w, int h) {	//�����ε��� �����ڰ� �������� �⺻ ������ �������������� ������ ���� ����
		
		this.w = w;
		this.h = h;
	}
	
	//�ʱ�ȭ �޼���
	public void set(int w, int h) {
		
		this.w = w;
		this.h = h;
	}
	
	//�ν��Ͻ� �޼���
	public int area() {
		return w*h;
	}
	
	public int length() {
		return (w*h)*2;
	}
	//�޼���
	public void print(int a) { 
		
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
		System.out.println("���� : " + a);
	}
		
	
	//�޼��� �����ε�
	public void print(int a, int l) {
		
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
		System.out.println("���� : " + a);
		System.out.println("�ѷ� : " + l);
			}
	}
	public class Test6 {

	public static void main(String[] args) {
		
		RectA ob1 = new RectA(); // �⺻������ + �ʱ�ȭ�޼��� ��� -> �⺻ ������ ȣ�� �ٽ� ���ΰ��� ����
		ob1.set(10, 20);
		
		int a = ob1.area(); //��ȯ�� 200
		int l = ob1.length(); //��ȯ�� 400
		ob1.print(a);
		ob1.print(a, l);
		
		System.out.println("-----------------------------------");
		
		RectA ob2 = new RectA(100, 200); // �����ε��� �����ڸ� ���� ��ü ���� �� �ʱ�ȭ �ٷ� ���� ->Spring������ '������ ����'�̶� ��
		
		a = ob2.area();
		l = ob2.length();
		ob2.print(a);
		ob2.print(a, l);
		
	}
}