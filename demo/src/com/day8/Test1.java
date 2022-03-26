package com.day8;
//Call By value
//���� �������� ������.
//stack ������ Heap�������� ���̰� �Ѿ

//Call By Reference
//���� �ѱ� �� ��ü�� ������ �ּҰ� �Ѿư�. ��ü�� ���� �ϳ��� �θ��� ���ڰ� ��ȭ��ȣ�� ���� ������ ����
//Heap������ �ִ� �����͸� ������ �� ��������ü�� ����Ǵ°� �ƴ϶� �ּҰ� ����Ǵ� ��
//static�� ���� ������ ��
//���� �ּҸ� ������. �ּҸ� ���� ������ ����
//�̹� ������� ���� ������ �� �� ���
class Test {
	public int x = 10; // �ν��Ͻ� ����
	
	public void sub(int a) {
		x += a;
	}
}

public class Test1 {

	public static void main(String[] args) {
		
		Test ob = new Test();
		
		//Call by value
		int a = 20;
		
		System.out.println("Sub�޼��� ������ x : " + ob.x);
		
		ob.sub(a);
		System.out.println("Sub�޼��� ������ x: " + ob.x);
		
		
		//Call By Reference @ �߿� @  - ob�� �ּҰ��� ob1�� �־��.�ּҰ��� �����ؼ� ���� ���� ����Ű�Ƿ� ���ϰ��� ����
		Test ob1;
		ob1 = ob;
		
		System.out.println(ob.x);//30
		System.out.println(ob.x);//30
		
		//�Ȱ��� ��ġ�� �� ��� �Ƴ�? ���� �����ؼ� �ٽ� ��ȸ�غ��� �ȴ�.
		ob1.x = 100;
		System.out.println(ob.x);//100
		System.out.println(ob1.x);//100

	}
}