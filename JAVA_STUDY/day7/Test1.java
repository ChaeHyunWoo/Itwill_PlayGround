package com.day7;

// this : Ŭ�����̸�(ME)
//Ŭ���� �̸��ε� Ŭ���� �ȿ� ���� Ŭ������ �Է��ϸ� �򰥷��� this�� ǥ��
class Circle { // Circle Ŭ����
	
	private int r; // �ν��Ͻ�����(�ɹ�����) - ������ ����ȭ(ĸ��ȭ)
					  // ���� ������ �� ������ �ܺο��� �������� ���ϰ� ���� ������ ����
	
	//�ʱ�ȭ �޼���. �Ű����� �̿�
	public void setDate(int r) { //setData(int r, Circle this)���������� �̷��� ó��
		//��ȸ����
		this.r =r; // ��������r, ��������r, ó�� �̸��� �����ϸ� java�� �������� ����. ���������� �ν��ϱ� ���� this ���.
					// this�� me�� ����(Ŭ�����̸��� ����)
					// Circle�� this�� �ٲ� ���̴�.(Ŭ���� �ȿ� ���� Ŭ�������� ���� ������ ��)
	}				
	
	// �޼���
	public double area() {	//  area(Circle this)
		return r*r*3.14;
		//retrun this.r*this.r*3.14;
	}
	
	//�޼��� - void�� ������ ��ȯ�� x
	public void result(double a) { // result(double a, Circle this)
		System.out.println("������ : " + r);	 // = ("������ : " + this.r);
		System.out.println("���� : " + r);
		
	}
}

public class Test1 {

	public static void main(String[] args) {
		
		 Circle ob = new Circle();	// ob�� Circle�� �ٸ� �̸�
		 //ob.r�� ĸ��ȭ�Ǿ��־� �ܺο��� ���� ����.
		 
		 
		 ob.setDate(10);	// = setData(10.ob); -> ���������� obŬ������ �ּҸ� ������.
		 double a = ob.area(); // ob.area(ob) -> �Ű������� �����Ƿ� obŬ���� �ּҸ� ������
		 ob.result(a); // result(a, ob)
		 
		 ob.setDate(100);
		 a = ob.area();
		 ob.result(a);	
	}

}