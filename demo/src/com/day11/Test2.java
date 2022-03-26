package com.day11;

class SuperTest {
	
	public int a = 10, b = 20;
	
	public void write() {
		System.out.println("슈퍼클래스 write() 메소드...");
	}
	
	public int hap() {
		return a + b;
	}
}

class SubTest extends SuperTest {
	
	public int b = 100, c = 200;
	
	public void print() {
		System.out.println("서브클래스 print() 메소드...");
	}
	
	@Override
	public int hap() {
		return a + b + c;// a=10 , b =100, c=200
	}
	
}
public class Test2 {

	public static void main(String[] args) {
		
		SubTest ob1 = new SubTest();
		System.out.println(ob1.b); // 100
		
		SuperTest ob2 = ob1; // upcast - 작은값이 큰값으로 
		System.out.println(ob2.b); // 20
		
		System.out.println(ob2.hap()); // 310
		
		ob2.write();
		
		//ob2.print(); 4. 내꺼는 내꺼다
		((SubTest)ob2).print(); // downcast
		
	}

}
