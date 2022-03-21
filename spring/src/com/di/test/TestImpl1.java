package com.di.test;
//인터페이스를 구현한 클래스
public class TestImpl1 implements Test {

	private int su1;
	private int su2;
	
	
	//기본 생성자
	//매개변수로 받는것이 없으므로 this 필요없음
	public TestImpl1() {
		su1 = 10;//this 생략가능
		su2 = 20;
	}
	
	//오버로딩된 생성자
	//this 내것을 가르켜줘야함
	public TestImpl1(int su1, int su2) {
		this.su1 = su1;
		this.su2 = su2;
	}
	//100+200
	@Override
	public String result() {
		String str = String.format("%d+%d=%d", su1,su2,su1+su2);
		return str;
	}
	
	
}
