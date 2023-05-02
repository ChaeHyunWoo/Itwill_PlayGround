package com.excep;
//Day14에 했던 예제

public class MyException extends Exception {

	
	private static final long serialVersionUID = 1L; // 이클립스의 코딩 Exception의 저장공간 굳이 안해도된다.
	
	public MyException(String msg) {
		super(msg);// 부모한테 msg를 준다. super=Exception /  부모 : Exception 
	}
	
}