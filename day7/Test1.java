package com.day7;

// this : Ŭ�����̸�(ME)
//Ŭ���� �̸��ε� Ŭ���� �ȿ� ���� Ŭ������ �Է��ϸ� �̻��ؼ� this�� ǥ��
class Circle {	//��������� ���������� �޾Ƽ� ����ؼ� ���
	
	private int r;	//instance(�ν��Ͻ�)����/ ���� ������ �� ������ �ܺο��� �������� ���ϰ� ���������� ����
					//������ ����ȭ(ĸ��ȭ)
	
	//�ʱ�ȭ �޼ҵ�.�Ű����� �̿�
	public void setData(int r) {//setData(int r, Circle this)���������δ� �̷��� ó���ȴ�.
	   //��ȸ����
		this.r = r;	//�������� r, �������� ró�� �̸��� �����ϸ� java�� �������� ����. ���������� �ν��ϱ� ���� this ���.
					//this�� me�� ����(Ŭ�����̸��� ����)
					//Circle�� this�� �ٲ۰��̴�.(Ŭ�����ȿ� ���� Ŭ�������� ���� �������߱⿡)
	}
	
	public double area() {	// area(Circle this)
		return r*r*3.14;	//�Ʒ��� ����. ȥ���ɶ�(��ȸ����) �ƴϸ� this �Ƚᵵ ���డ��
		//return this.r*this.r*3.14;
	}
	
	public void result(double a) {// result(double a, Circle this)
		System.out.println("������ :" + r);	//  = ("������ :" + this.r);
		System.out.println("���� : " + a);
	}
}


public class Test1 {

	public static void main(String[] args) {
		
		Circle ob = new Circle();	//ob �� circle�� �ٸ��̸�
		//ob.r�� ĸ��ȭ�Ǿ��־� �ܺο��� ���� ����.
		
		ob.setData(10);	// = setData(10,ob); -> ���������� obŬ������ �ּҸ� ������
		double a = ob.area();//ob.area(ob) -> �Ű������� �����Ƿ� obŬ���� �ּҸ� ������
		ob.result(a);// result(a, ob)
		
		ob.setData(100);
		a = ob.area();
		ob.result(a);
	}
}