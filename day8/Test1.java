package com.day8;

//Call By value
//stack������ Heap�������� ���̰� �Ѿ  
//Call By Reference 
//���� �ѱ涧 ��ü�� ������ �ּҰ� �Ѿ    ��ü�� ���� �ϳ��� �θ��� ���ڰ� ��ȭ��ȣ�� ���� ������ ���� 



class Test{
	
	public int x = 10;
									//������ �ʴ� �⺻������ 
	public void sub(int a) {
		x += a;
		
	}
}


public class Test1 {

	public static void main(String[] args) {
		
		Test ob = new Test();
		
		//Call by value 
		int a = 20;
		
		System.out.println("Sub�޼ҵ� ������ x: " + ob.x);
		ob.sub(a);
		System.out.println("Sub�޼ҵ� ������ x: " + ob.x);
		
		
		//Call By Reference @�߿�@
		
		Test ob1; //���� ���ڿ�����
		ob1 = ob;
		
		System.out.println(ob.x); //30
		System.out.println(ob1.x);//30
		
		ob1.x = 100;
		System.out.println(ob.x); // 100
		System.out.println(ob1.x);// 100
		
	}

}