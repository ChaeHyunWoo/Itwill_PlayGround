package com.day10;

// Singleton  - static�� ����ؼ� �ϳ��� ��ü�� ���� �����ϴ� ��

class Sing {
	
	private static Sing ob; // static �־ Ŭ���� ����
	
	public static Sing getInstance() {
		
		if(ob==null)
			ob = new Sing();
		
		return ob;
	}
}

public class Test6 {

	public static void main(String[] args) {
		
		Sing ob1 = Sing.getInstance(); // ob1�̶� ob2 �ּ� ����
		Sing ob2 = Sing.getInstance();
		
		if(ob1 == ob2)
			System.out.println("������ ��ü....");
	}

}