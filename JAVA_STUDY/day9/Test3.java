package com.day9;

//String
//String�� Class(Ŭ����)�̴�. (�ڷ����� �ƴ�)
//StringŬ������ �ڷ���ó�� ����ϴ� ������ ������ �����ʹ� ����ϰ� ��� �󵵴� ���� �����̴�.

//String �����ʹ� equalse�� ���ؾ� ��Ȯ�� ���� ����
//String�� �Һ��� ��Ģ(�޸𸮿� ���� ����Ǹ� ����or���� ����) ���ο� ���� ����
public class Test3 {

	public static void main(String[] args) {
		
		String ob1 = "Seoul";	// �ڷ���ó�� ����
		String ob2 = "Seoul";
		String ob3 = new String ("Seoul"); //Ŭ���� ���� ����
		
		System.out.println("ob1 == ob2 : " + (ob1 == ob2)); //true | why? String�� ���ڰ� 100%������ ���� ������ �ʰ�, �ּҸ� �����Ѵ�.
		System.out.println("ob1 == ob3 : " + (ob1 == ob3)); //false | new�� ���� ���� ������ ��������.
															// ������ ������ �ּҰ� �޶� false
		System.out.println("ob1.equals(ob3) : " + ob1.equals(ob3)); //true 
		
		ob2 = "korea";
		System.out.println("ob1 == ob2 : " + (ob1 == ob2)); // false
		
		ob2 = "use";
		System.out.println("ob1 == ob2 : " + (ob1 == ob2)); // false
		
		ob2 = "Seoul";
		System.out.println("ob1 == ob2 : " + (ob1 == ob2)); // true
		
		System.out.println(ob2); // hashcode ( x) 
		//String Ŭ������ �ڷ��� �䳻�� �ִ��� ���� ���� hascode �ּҰ��� �ȳ����� �ּҷ� ã�ư� �ִ� �����͸� �������
		System.out.println(ob2.toString()); // Seoul

	}
}