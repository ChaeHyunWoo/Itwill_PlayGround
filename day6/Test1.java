package com.day6;
//�ϳ��� ���Ͽ� 2���̻��� publicŬ������ ����� ������. �׷��� public Ŭ������ 1���� ���� ����.
//main���� �ִ� Ŭ�������� public�� ���� ������ Ŭ�������� class�� ����


class SubClass {
	
	int a, b; //instance����(��������)
	
}

public class Test1 {

	public static void main(String[] args) {
		
		SubClass ob1 = new SubClass();
		SubClass ob2 = new SubClass();
		
		System.out.println("ob1.a: " + ob1.a);	//0
		System.out.println("ob1.b: " + ob1.b);	//0
		
		ob1.a = 10;
		ob1.b = 20;
		System.out.println("ob1.a: " + ob1.a);	//10
		System.out.println("ob1.b: " + ob1.b);	//20
		
		
		System.out.println("ob2.a: " + ob2.a);	//0
		System.out.println("ob2.b: " + ob2.b);	//0
		
		
		ob2.a = 100;
		ob2.b = 200;
		System.out.println("ob2.a: " + ob2.a);	//100
		System.out.println("ob2.b: " + ob2.b);	//200
		
		System.out.println("ob1.a: " + ob1.a);	//10
		System.out.println("ob1.b: " + ob1.b);	//20	
		
		// �޸𸮰����� ��� ���� ���� ����.
	}

}
