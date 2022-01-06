package com.day12;

import java.util.Vector;
//Vector안에는 뭐든 다들어간다.배열 안에도 뭐든 다들어간다.

class Test {
	
	String name;
	int age;
}

public class Test8 {

	public static void main(String[] args) {
		
		Vector<Test> v = new Vector<>(); // Vector에 Test클래스를 넣는다.
		
		Test ob;
		ob = new Test();	// 2명의 데이터를 넣어서 2번씀
		ob.name = "배수지";
		ob.age = 27;
		v.add(ob);
		
		ob = new Test();// 2명의 데이터를 넣어서 2번씀
		ob.name = "유인나";
		ob.age = 41;
		v.add(ob);
		
		for(Test t : v) {
			System.out.println(t.name + ":" + t.age);
		}
		
	}

}