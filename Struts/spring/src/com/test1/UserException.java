package com.test1;

//예외처리 필요한 파일
public class UserException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	//에러를 처리할때 애한테 보낸다.
	// - 생성자
	public UserException(String str) {
		super(str);//super는 Exception이다.
	}

}
