package com.day16;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

// InputStreamReader
// 1byte Stream�� 2byte Stream���� ��ȯ���ִ� Stream -1����Ʈ���ڸ� 2����Ʈ �ؽ�Ʈ�� �ٲٴ°�
// �긴�� ��Ʈ���̶�� �� - ���� �ٸ�����

public class Test3 {

	public static void main(String[] args) throws IOException {
		
		int data;
		System.out.print("���ڿ� ? ");
		
		//Reader�� ��Ƴ���
		Reader rd = new InputStreamReader(System.in);
		
		//rd�� �����͸� �ϳ� ������ rd.read�� ������ ��ȯ�ؼ� data�� �ִ´�
		while((data = rd.read()) != -1) {
			
			char ch = (char)data;
			System.out.print(ch);
		}

	}

}
