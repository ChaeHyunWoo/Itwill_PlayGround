package com.excep;
//Day14�� �ߴ� ����

public class OperationAuthenticator {
	
	public void inputFormat(String str)  throws MyException {
		
		String temp[] = str.split(","); // ��ǥ�� �����ض�
		
		if(temp.length != 2) { // �Է��� ���ڰ� 2���� �ƴϸ�
			throw new MyException("���� �Է� ����! : " + str);
		}
		
	}
	
	//���� �Ƚᵵ�ȴ�.
	@SuppressWarnings("unused") // ��������ʴ� ������ ���� �����޽����� ǥ����������(����� ���������)
	public void number(String str) throws MyException {
		
		try {
			
			if(str.indexOf(".") != -1) { //  �� : .�� �ֳ�? - �����͸� ��ã���� -1�̴�. ���� -1�� �ƴϸ�
				double num = Double.parseDouble(str); // ������ double�� ����ȯ
			} else {
				int num = Integer.parseInt(str); // ������ int�� ����ȯ
			}
			
		} catch (NumberFormatException e) {
			throw new MyException("���� ��ȯ �Ұ� : " + str);	// MYException���� ������
		}
		
	}
	
	
	public void operator(char ch) throws MyException {
		
		switch(ch) {
		
		case '+':
		case '-':
		case '*':
		case '/':
			return; // ��������� �ϰ� ������������
		default:
			throw new MyException("������ ����! : " + ch); // ���� throws MyException �Ⱦ��� ������
				//���� �����ڰ� ������ ������ �߻����Ѽ� MyException���� ������
				
		}
				
	}
}