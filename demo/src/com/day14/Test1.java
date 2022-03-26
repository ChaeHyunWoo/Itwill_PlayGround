package com.day14;
// Integer�̶� int�� ����

class Box<T> { // T�� �ڷ����ε� ����ڰ� �� �ֳĵ��� �ڷ����� �޶���.
	
	private T t; // private���� ��������� ��ȸ���� ��������
	//T�� �ؿ��� Integer�� ����
	public void set(T t) {
		this.t = t;
	}
	
	public  T get() {
		return t;
	}
}

public class Test1 {

	public static void main(String[] args) {
		
		Box<Integer> b1 = new Box<Integer>();	// ��ü�����ϰ�
		b1.set(10);	//set���� 10�� ���� -> auto-Boxing - ���ÿ����� �ִ� �����Ͱ� �� ��������
		
		int i = b1.get(); // auto-unboxing	//�ڵ����� �Ǵ� �� ����ϱ� - �� ������ �ִ� �����Ͱ� ���� ��������
		System.out.println(i);
		
		Box<String> b2 = new Box<String>();
		//b2.set(10); �ڷ����� String���� ������� ������ ���� 
		b2.set("����");
		String s = b2.get();
		System.out.println(s);
		
		Box b3 = new Box<>(); // �ڷ����� �ƹ��͵� ���� ������ ������Ʈ
		b3.set(30);
		Integer ii = (Integer)b3.get(); // downcast ���ϸ� Integer���� �޾ƿ´�.
		System.out.println(ii);
		
	}
}