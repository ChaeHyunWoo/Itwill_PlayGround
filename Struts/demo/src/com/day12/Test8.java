package com.day12;

import java.util.Vector;
//Vector�ȿ��� ���� �ٵ���.�迭 �ȿ��� ���� �ٵ���.

class Test {
	
	String name;
	int age;
}

public class Test8 {

	public static void main(String[] args) {
		
		Vector<Test> v = new Vector<>(); // Vector�� TestŬ������ �ִ´�.
		
		Test ob;
		ob = new Test();	// 2���� �����͸� �־ 2����
		ob.name = "�����";
		ob.age = 27;
		v.add(ob);
		
		ob = new Test();// 2���� �����͸� �־ 2����
		ob.name = "���γ�";
		ob.age = 41;
		v.add(ob);
		
		for(Test t : v) {
			System.out.println(t.name + ":" + t.age);
		}
		
	}

}