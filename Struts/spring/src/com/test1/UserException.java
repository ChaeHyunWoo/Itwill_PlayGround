package com.test1;

//����ó�� �ʿ��� ����
public class UserException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	//������ ó���Ҷ� ������ ������.
	// - ������
	public UserException(String str) {
		super(str);//super�� Exception�̴�.
	}

}