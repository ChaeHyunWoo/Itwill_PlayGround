package com.day8;


class TestC {
	
	private String title;
	protected int area;
	
	public TestC() {	//기본생성자
	}
	
	public TestC(String title) {
		this.title = title;
	}
	
	public void print() {
		System.out.println(title + ":" + area);
	}
}

class RectC extends TestC {
	
	private int w, h;	//생성자로 초기화     constructor(생성자)  /    오류에 proterty라는 말이 나오면 메서드 오류
	
	public RectC(int w, int h) {
		super("사각형");
		this.w = w;
		this.h = h;
	}
	
	public void rectArea() {
		area = w*h;
	}
}
public class Test4 {

	public static void main(String[] args) {
		
		RectC ob = new RectC(10,20);//
		ob.rectArea();
		ob.print();
	}

}
