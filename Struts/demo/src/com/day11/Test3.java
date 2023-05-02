package com.day11;

// Interface(�������̽�) - Ŭ������
// �߻�Ŭ������ �������� ���� �ϰ�, ����(����)�� ����.
// ������ final ������ ���� �����ϴ�.
// �������̽��� �����ϱ����ؼ��� implements�� ����Ѵ�.
// �������̽��� ���������� �������̽��� ��� �޼��带 ������(�������̵�)�ؾ� �Ѵ�.
// �������̽��� �ٸ� �������̽��� ��ӹ��� �� �ִ�. �׶��� extends�� ����Ѵ�.
// Ŭ������ ���� ��������� �������̽��� ���߻���� �����ϴ�.

interface Fruit { //�������̽�
	
	String Won = "��";  // �������̽� ���� ���� - public static final�� �����Ǿ� ����
	
	int getPrice(); // public abstract �����Ǿ� ����
	

	public String getName();
	// �������̽� �ȿ��� �Ϲ� �޼ҵ带 ���� �� ����.
}

class FruitImpl implements Fruit {//�������̽��� extends ��� implements�� ��ӹ޴´�.
	

	@Override
	public int getPrice() {
		return 1000;
	}

	@Override
	public String getName() {
		return "���";
	}
	
	public String getItems() {
		return "����";
	}

	
}

public class Test3 {

	public static void main(String[] args) {
		
		
		//Fruit ob1 = new FruitImpl();�� �ϸ� getItems�� ������ why? �θ�� �ڽĲ� ���� ���⿡
		FruitImpl ob1 = new FruitImpl();
		
		System.out.println(ob1.getItems());
		System.out.println(ob1.getName());
		System.out.println(ob1.getPrice() + Fruit.Won);
		
		Fruit ob2 = ob1; // upcast - �ڽ��� �θ� ����
		
		System.out.println(ob2.getName());
		//System.out.println(ob2.getItem()); ���� - �θ�� �ڽĲ� �� �� ����.
	}

}
