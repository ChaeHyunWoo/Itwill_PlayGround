package com.excep;
//Day14�� �ߴ� ����

public class MyException extends Exception {

	
	private static final long serialVersionUID = 1L; // ��Ŭ������ �ڵ� Exception�� ������� ���� ���ص��ȴ�.
	
	public MyException(String msg) {
		super(msg);// �θ����� msg�� �ش�. super=Exception /  �θ� : Exception 
	}
	
}