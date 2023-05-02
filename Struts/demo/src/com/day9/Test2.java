package com.day9;
	//java���� ��� Ŭ����(class) + �������� Ŭ������ �θ�(����)�� ������Ʈ��(Object)
	// Object�� ���� ū �ڷ���. ������Ʈ �޼ҵ忡��  equals�� toString �޼ҵ� ����ϱ�

	class TestA { //���� ���� Ŭ������ �θ� ����� �� ������ �⺻������ ������ Object�̴�.
				  // class TestA extends Object { �̷��� �ᵵ ���� �ȶ�
		private int a = 10;
		
		public void write() {
			System.out.println("a" + a);
		}
	}
	
	
public class Test2 {
	
	public static void main(String[] args) {
		
		TestA ob1 = new TestA();
		TestA ob2 = new TestA();
		
		System.out.println("ob1 == ob2:" + (ob1 == ob2)); //false�� ����
		//why? �Ȱ��� Ŭ������ ��ü�� ���������� ob1�� ����ִ� �ּҿ� ob2�� ����ִ� �ּҰ� �ٸ��� ����.
		
		System.out.println("ob.equals(ob2):" + ob1.equals(ob2)); // false�� ����
		//equals�� Object�� �޼ҵ��ε� TestA�� �θ�� Object�� ��밡��
		
		System.out.println("ob1 : " + ob1);//�ּ�//ob1 : com.day9.TestA@7852e922   -> @�ڿ� ���ڴ� �ؽ��ڵ�(hashcode)
		System.out.println("ob2 : " + ob2);//�ּ�//ob2 : com.day9.TestA@4e25154f   -> @�ڿ� ���ڴ� �ؽ��ڵ�(hashcode)
		System.out.println("ob1.toString(): " + ob1.toString());//�ּ�//ob1.toString(): com.day9.TestA@7852e922
		//toString�޼ҵ� : �ȿ� ����ִ� ���� �ڷ����� �����̵� (string����)���ڷ� ����Ѵ�
		//TestA�� �θ� Object���� toString�� ��� �����ѰŴ�.
	}	

}