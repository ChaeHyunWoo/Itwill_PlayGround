package com.day9;

//�θ�
class Test {
	// �⺻�����ڷ� ��ü ������ �����ε��� �����ڷε� ��ü ������
	private String title;
	protected double area;
	
	//�⺻ ������
	public Test() {} //�⺻ ������ �������� why? �����ε��� ������ �������
	
	//�����ε��� ������
	public Test(String title) {
		this.title = title;
	}
	
	public void write() {
		System.out.println(title + ":" + area);
	}
}
//�ڽ�
class Circle extends Test {
	
	private int r;
	protected static final double PI = 3.14;// static �˾Ƽ� �޸𸮿� �ö�
	//�����ε��� ������
	public Circle(int r) {//new Circle(10)������ r�� 10�� ����
		super("��"); //���� ���� title�� ��
		this.r = r;
	}
	
	public void circleArea() {
		area = (double)r * r * PI; //�����ϱ� ���ϰ� double�ᵵ�ȴ�. ������ ���� �ȶ�.
	}
}

class Rect extends Test {
	
	private int w, h;
	
	public void rectArea(int w, int h) {//�޼ҵ�� �ʱ�ȭ / ���� �޼ҵ� Rect�� �޼ҵ��̴�
		this.w = w;
		this.h = h;
		
		area = w * h;
	}

	
	//Override
	//��Ӱ��迡�� ���� ������ �ϴ� �޼ҵ��� �̸��� ���Ͻ�Ű�� �۾�
	//�θ��� Ŭ������ ������(������)�ؼ� ���
	//���� : �޼ҵ��� �̸��� �θ� �޼ҵ�� ��Ȯ�� ���ƾ� �Ѵ�.
	//�޼ҵ�� �ϴ��� ���ʳ��� ������ �ڽ� ���� �����
	//�θ��� ������ ���� �ȵ� �ڽ��� ������� ������ ����!
	
	@Override //������̼�
	public void write() {
		System.out.println("���� : " + w + " ���� : " + h);
		System.out.println("���� : " + area);
		//super.write();
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		
		Circle ob1 = new Circle(10);
		ob1.circleArea();
		ob1.write();//�θ��� �޼ҵ带 ����Ѵ�
		
		Rect ob2 = new Rect(); //�⺻ ������ ����
		ob2.rectArea(10, 20); //�Ű����� �� �ʿ�
		ob2.write(); //5. �θ� �������ְ�, ���� ���� ������ ���� ����.������!!!
	}

}
