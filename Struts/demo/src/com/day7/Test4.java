package com.day7;

class Rect { //���� �ν��Ͻ������� �ν��Ͻ� �޼���
	
	private int w, h; //�ν��Ͻ� ����(��������)
	
	//�ν��Ͻ� �޼���
	public void set(int w, int h) { // �ν��Ͻ� ������ �̸��� ������ ȥ���� ���� this�� ����Ѵ�.
		
		//��ȸ��� - ��ȸ�ؼ� �ʱ�ȭ
		this.w = w;
		this.h = h;
	}
	
	//�ν��Ͻ� �޼��� - ����
	public int area() { 
		return w*h;
	}
	
	
	//�ν��Ͻ� �޼��� - �ѷ�
	public int length() {
		return (w*h)*2;
	}
	
	//�ν��Ͻ� �޼��� - ���
	public void print(int a, double l) {
		
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
		System.out.println("���� : " + a);
		System.out.println("�ѷ� : " + l);
	}
	
	
	/*
	�޼��� �ߺ� ����(Overloading) - �����ε�
	�ϳ��� Ŭ���� �ȿ� ����� ������ �ϴ� �޼ҵ��� �̸��� ���Ͻ�Ű�� �������
	�޼����� �̸��� ���������� ��ȣ ���� �μ��� ������ �μ��� �ڷ����� �ٸ��� �ָ�
	���� �ٸ� �޼���� �ν��Ѵ�.
	 */
	//�����ε��� �޼���
	public void print() {
		
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
	}
	//�����ε��� �޼���
	public void print(int a) {
		
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
		System.out.println("���� : " + a);
	}
	//�����ε��� �޼���
	public void print(double l) {
		
		System.out.println("���� : " + w);
		System.out.println("���� : " + h);
		System.out.println("�ѷ� : " + l);
	}
}


public class Test4 {

	public static void main(String[] args) {	// main�Լ�
		
		Rect ob = new Rect(); //��ü����. �ٽ� ���� ���� ����
		
		ob.set(10, 20); // w�� 10, h�� 20�� �־��ش�.
		
		int a = ob.area(); //area�� ���� int a �� �ִ´�
		double l = ob.length(); // length�� ���� double l �� �ִ´�.
		
		ob.print();
		ob.print(l);
		ob.print(a);
		ob.print(a, l);

	}

}
