package com.di.test;
//�������̽��� ������ Ŭ����
public class TestImpl1 implements Test {

	private int su1;
	private int su2;
	
	
	//�⺻ ������
	//�Ű������� �޴°��� �����Ƿ� this �ʿ����
	public TestImpl1() {
		su1 = 10;//this ��������
		su2 = 20;
	}
	
	//�����ε��� ������
	//this ������ �����������
	public TestImpl1(int su1, int su2) {
		this.su1 = su1;
		this.su2 = su2;
	}
	//100+200
	@Override
	public String result() {
		String str = String.format("%d+%d=%d", su1,su2,su1+su2);
		return str;
	}
	
	
}
