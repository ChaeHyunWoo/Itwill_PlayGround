package com.di.test;
//�������̽��� ������ Ŭ����
public class TestImpl2 implements Test {

	
	private String name;
	private int age;
	
	
	//�⺻ ������
	public TestImpl2() {
		this.name = "�����";
		this.age = 27;
	}
	
	
	//�����ε��� ������
	public TestImpl2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
	//result �������̵�
	@Override
	public String result() {
		String str = "�̸�:" + name + ", ����:" + age;
		return str;
	}
	
}
