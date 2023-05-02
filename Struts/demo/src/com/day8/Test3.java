package com.day8;


// �ڹٴ� ���ϻ�Ӹ� �����ϴ�. c���� ���߻�Ӱ��� 
//���(�θ� �ڽ����� �ִ� ��)

//����
//1. �θ𲨴� ������.				(�Ҿƹ������� ������) �޼ҵ� �����ͼ� �̿밡��
//2. �θ� private�� ������ ���� ����� �Ұ����ϴ�.
//3. �θ� protected�� ������ ���� ��� ����
//4. ���� ������.					(�ڽĲ��� �ڽĲ��� / �θ� �ڽİŸ� ����)
//5. �θ�� �ڽ��� ���� ��ü�� ������ ������ ������ �ڽ�(����)�� ����.

//1
class TestB {	//TestB�� �θ�� ����� RectB�� �ڽ����� ����
	
	private String title;
	protected int area;	//3. �θ� protected�� ������ ���� ��� ���� @�߿�@ Test2������ pivate�� �ϴ� ���
	
	public void set(String title) { // �޼ҵ�� ��ȸ���� ����
		this.title = title;	//�ʱ�ȭ
	
		
	}
	
	public void print() {
		
		System.out.println(title +":" + area);
	}
}

//2
class RectB extends TestB {	//TestA�� �θ�� ����� Rect�� �ڽ����� ����
	
	private int w,h; //������ �ʱ�ȭ�ϱ����ؼ� ��ȸ���� ��������/�����ڷ� ��ȸ����	(2) w,h�� ����
	
	public RectB(int w, int h) { //�����ε����� �� �����ڷ� ��ȸ���� ����(�����ڷ� �ʱ�ȭ)	(1) 10,20�� ����
		this.w = w;
		this.h = h;
	}
	
	public void rectArea() {
		area = w*h;	// (3) ���⼭ ����ؼ� 200�̵ǰ�
		set("�簢��");	//1. �θ�� ������
		
	}
}


//3
public class Test3 {

	public static void main(String[] args) {
		
		RectB ob = new RectB(10, 20);
		
		ob.rectArea();
		ob.print();//1. �θ𲨴� ������
	}

}
