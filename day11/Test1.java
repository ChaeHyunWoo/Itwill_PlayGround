package com.day11;

class TestA {
	public void print() {
		System.out.println("AŬ����...");
	}
}
//-----------------------------------------------------
class TestB {
	public void print() {
		System.out.println("BŬ����...");
	}
}
//-----------------------------------------------------

public class Test1 {

	public static void main(String[] args) {
		
		TestA a = new TestA();
		TestB b;
		//������ Ÿ���� �޶� �ȵȴ�. �ɷ��� TestB�� TestA�� �ٲ������
		//b=a;
		//b=(TestB)a;

	}

}
