package com.day8;



//���(�θ� �ڽ����� �ִ� ��)

//����
//1. �θ𲨴� ������.
//2. �θ� private�� ������ ���� ����� �Ұ����ϴ�.
//3. �θ� protected�� ������ ���� ��� ����
//4. ���� ������.(�ڽĲ��� �ڽĲ��� / �θ� �ڽİŸ� ����)
//5. �θ�� �ڽ��� ���� ��ü�� ������ ������ ������ �ڽ�(����)�� ����.

//1
class TestA {	//TestA�� �θ�� ����� Rect�� �ڽ����� ����
	
	private String title;
	private int area;	//private�� ������ ����� ��ȸ���θ� ��������/�̷��� ������ ȥ���� ���� ���� this�� �����.
	
	public void set(String title, int area) { // �޼ҵ�� ��ȸ���� ����
		this.title = title;	//�ʱ�ȭ
		this.area = area;	//�ʱ�ȭ
		
	}
	
	public void print() {
		
		System.out.println(title +":" + area);
	}
}

//2
class Rect extends TestA {	//TestA�� �θ�� ����� Rect�� �ڽ����� ����
	
	private int w,h; //������ �ʱ�ȭ�ϱ����ؼ� ��ȸ���� ��������/�����ڷ� ��ȸ����	(2) w,h�� ����
	
	public Rect(int w, int h) { //�����ε����� �� �����ڷ� ��ȸ���� ����(�����ڷ� �ʱ�ȭ)	(1) 10,20�� ����
		this.w = w;
		this.h = h;
	}
	
	public void rectArea() {
		int a = w*h;	// (3) ���⼭ ����ؼ� 200�̵ǰ�
		set("�簢��", a);	//1. �θ�� ������
		
	}
}


//3
public class Test2 {

	public static void main(String[] args) {
		
		Rect ob = new Rect(10, 20);
		
		ob.rectArea();
		ob.print();//1. �θ𲨴� ������
	}

}
