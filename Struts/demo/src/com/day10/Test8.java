package com.day10;
//�߻� Ŭ����
//�߻� Ŭ������ �޸��� ������� Ŭ������ �޼ҵ带 �̸� ���踦 �ϴ� ��
//�߻� Ŭ������ �޼ҵ带 �������ؼ� ���
//�߻� Ŭ�������� �ݵ�� �ϳ� �̻��� �߻� �޼ҵ尡 �־�� �ϰ�, 
//�Ϲ� �޼ҵ嵵 ���� �� �ִ�.
//�߻� Ŭ������ �޼ҵ� ���� �����ٰ� ����ϸ� ��. �������� ������ �޼ҵ���� ����µ� ��� x
//�޼ҵ���� �����Ͽ� ���ϼ�

abstract class ShapeClass { //�߻�Ŭ���� -  �տ��� abstract�� �ٴ´�.
	
	abstract void draw();// �߻� �޼ҵ� - �߻�Ŭ���� �ȿ��� �߻� �޼ҵ尡 1�� �̻� �־����
}


class Circle extends ShapeClass {	//�߻� Ŭ������ ��ӹ޾Ƽ� �޼ҵ带 �������ؼ� ��� 

	@Override
	public void draw() {	// 
		System.out.println("���� �׸���...");
	} 
}


class  Rect extends ShapeClass {

	@Override
	public void draw() {
		System.out.println("�簢���� �׸���...");
	} 
}


class Tria extends ShapeClass {

	@Override
	public void draw() {
		System.out.println("�ﰢ���� �׸���...");
	}
}


public class Test8 {

	public static void main(String[] args) {
		
		//��ü ����
		Circle c = new Circle();
		Rect r = new Rect();
		Tria t = new Tria();
		
		c.draw();
		r.draw();
		t.draw();
		
	}

}