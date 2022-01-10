package com.day14;
// Integer이랑 int는 같다

class Box<T> { // T는 자료형인데 사용자가 뭘 주냐따라 자료형이 달라짐.
	
	private T t; // private으로 만들었으니 우회도로 만들어야함
	//T는 밑에서 Integer로 해줌
	public void set(T t) {
		this.t = t;
	}
	
	public  T get() {
		return t;
	}
}

public class Test1 {

	public static void main(String[] args) {
		
		Box<Integer> b1 = new Box<Integer>();	// 객체생성하고
		b1.set(10);	// set으로 10을 넣음 -> auto-boxing -스택영역에 있는 데이터가 힙 영역으로
		int i = b1.get(); // auto-unboxing	//자동으로 되니 용어만 기억하기 - 힙 영역에 있는 데이터가 스택 영역으로
		System.out.println(i);
		
		Box<String> b2 = new Box<String>();
		//b2.set(10);
		b2.set("서울");
		String s = b2.get();
		System.out.println(s);
		
		Box b3 = new Box<>();
		b3.set(30);
		Integer ii = (Integer)b3.get(); // downcast
		System.out.println(ii);
		
	}
}