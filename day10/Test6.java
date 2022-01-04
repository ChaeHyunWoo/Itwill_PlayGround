package com.day10;

// Singleton  - static을 사용해서 하나의 객체만 만들어서 공유하는 거

class Sing {
	
	private static Sing ob; // static 있어서 클래스 변수
	
	public static Sing getInstance() {
		
		if(ob==null)
			ob = new Sing();
		
		return ob;
	}
}

public class Test6 {

	public static void main(String[] args) {
		
		Sing ob1 = Sing.getInstance(); // ob1이랑 ob2 주소 공유
		Sing ob2 = Sing.getInstance();
		
		if(ob1 == ob2)
			System.out.println("동일한 객체....");
	}

}