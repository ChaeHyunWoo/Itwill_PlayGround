package com.day16;

import java.io.IOException;
import java.io.OutputStream;

public class Test2 {
	
	public static void main(String [] args) throws IOException {
		
		OutputStream os = System.out; //System.out�� 1����Ʈ�� ��������
		
		
		//OutputStream�� �ƽ�Ű���� �迭�� �־���� �迭�� �ѹ��� �� ��������.
		byte[] b = new byte[3]; // buffer
		
		b[0] = 65;
		b[1] = 97;
		b[2] = 122;
		//���� �� �ڵ����� ����ȯ�Ǽ� �ƽ�Ű������ ����
		
		//3���� ����� �Ѳ����� ����. os�� �������°��� os�� ������ ��¸���
		os.write(b); // OutputStream�� write()�޼��带 �̿��ؼ� �ѹ��� ���
		System.out.println("�� ����!?");
		
		os.close(); // close�� �ϸ� System.out�� ���� ������.
		System.out.println("�� ���̳�??? ");
	}

}