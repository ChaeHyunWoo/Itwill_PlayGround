package com.day10;

//final�� 3���� Ư¡(Ư��) - ���� �ڵ��� �ս��� ������ �� ���
//�ν��ϼ������� final�� ���̸� �� �ѹ��� �ʱ�ȭ�� �����ϴ�.
//�޼ҵ忡 final�� ���̸� Override�� �Ұ����ϴ�
//Ŭ������ final�� ���̸� ����� �Ұ����ϴ�.
//-------------------------------------------------------------------------------------------
//final class TestA  - Ŭ������ final�� ���̸� ��� �Ұ���(Ŭ������ final�� �ִ� ���� ���� ����.)
class TestA {
	
	public static final double PI;	// �ʱ�ȭ�� ���ϸ� ������
	
	static {
		PI = 3.14; //�ѹ� �ʱ�ȭ�ϸ� ���� �ٲ� �� ����.
	}
	
	public double area; //instance����
	
	public final void write(String title) {//�޼ҵ忡 final�� �ָ� �ڽ��� �θ� �޼ҵ带 ������ �־ override�� �� �� ����.
		System.out.println(title + ":" + area);
	}
}

public class Test7 extends TestA { //�θ𲨴� ������.
	
	//@Override		//�޼ҵ忡 final�� �ָ� �ڽ��� �θ� �޼ҵ带 �� �� ����.
	//public void write(String title) {
	//}
	
	public void circleArea(int r) {
		area = (double)r*r*PI;
	}

	public static void main(String[] args) {
		
		Test7 ob = new Test7();
		ob.circleArea(10);
		ob.write("��");
	
	}

}
