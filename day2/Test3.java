package com.day2;

import java.io.IOException;

public class Test3 {

	public static void main(String[] args) throws IOException {
		
		//@@�ڷ��� char / String�� �׻� "" ū����ǥ �����
		//String str = "hyuen woo";
		
		//@@char������ ''���� ����ǥ�� ����ϰ� 1����Ʈ or 2����Ʈ ���� 1���� ���� ����.(������ �� �ڸ� ���� ����)
		char ch, result;
		
		System.out.println("�Ѱ��� ����?"); //a(97) �ƽ�Ű �ڵ尪
		
		ch = (char)System.in.read();//���ĺ� �� �ڸ� �о�� ��ɾ� //read()�� ��ȯ���� int�� (char)�� �Ἥ ����ȯ
		// @@97�̶�� ���ڸ� �޾ƿ��µ�  ch�� ���ڸ� ������ �־� ����ȯ�� ���� char�� �ٲ���Ѵ�.
		
		//System.out.println(ch); // a ���
		
		//System.out.println(Integer.toString(ch));
		//@@����a�� �Է������� �� ������ �ƽ�Ű�ڵ尪�� ������� �� ����. �׷��� 97�� ��µȴ�.
		
		
		//97
		result = ch>=65 && ch<=90?  (char)(ch+32):  // 
				//       ����   //
			(ch>='a' && ch<='z'?(char)(ch-32):ch);
		
		System.out.println(ch + ":" + result);
	}
	//���� ������
	//(�ǿ�����1) ? (�ǿ�����2) : (��or�����)
	//						true
//									false
	
	
}
