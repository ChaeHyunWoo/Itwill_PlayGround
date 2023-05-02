package com.day8;

class ClassA {
	
	public ClassA(String a) {
		
	}
}

class ClassB extends ClassA {
	
	public ClassB() {
		//super();
		super("¸¾´ë·Î");
	}
}

public class Test5 {

	public static void main(String[] args) {
		
		ClassB ob = new ClassB();
	}

}
