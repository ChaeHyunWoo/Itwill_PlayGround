package com.day7;

class Rect { //���� instance������ instance �޼ҵ�
	
	private int w, h;// ��������, �ν��Ͻ� ����
	
	public void set(int w, int h) { // ���������� �Ű������� �̸��� ������ ȥ���� ���� this�� ���
									// ��ȸ�ؼ� �ʱ�ȭ.
		this.w = w;
		this.h = h;
	}
	
	
	public int area() {	//����	//�ν��Ͻ� �޼ҵ�
		return w*h;
	}
	
	
	public int length() {	//�ѷ�
		return (w+h)*2;
	}
	
	
	public void print(int a, double l) {
		
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
		System.out.println("���� : " + a);
		System.out.println("�ѷ� : " + l);
	}
	// �޼ҵ� �ߺ� ����(Overloading)
	// �ϳ��� Ŭ���� �ȿ��� ����� �������ϴ� �޼ҵ��� �̸��� 
	// ���Ͻ�Ű�� ������� �޼ҵ��� �̸��� ����������
	//��ȣ ���� �μ��� ������ �μ��� �ڷ����� �ٸ��� �ָ�
	// ���� �ٸ� �޼ҵ�� �ν��� �Ѵ�.
	public void print() {
		
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
	}
	
	public void print(int a) {
		
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
		System.out.println("���� : " + a);
	}
	
	public void print(double l) {
		
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
		System.out.println("�ѷ� : " + l);
		
	}
	
}



public class Test4 {
	
	public static void main(String[] args) {
		
		Rect ob = new Rect();
		
		ob.set(10, 20);
		
		int a = ob.area();
		double l = ob.length();
		
		ob.print();
		ob.print(l);
		ob.print(a);
		ob.print(a, l);
	}
}