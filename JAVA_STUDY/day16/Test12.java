package com.day16;

import java.io.File;
import java.io.IOException;
import java.util.Date;

//File Ŭ����
//���� �� ������ ������ �� �ֵ��� ����� �������ִ� Ŭ����
//������ ���� �Ǵ� �̸����� ���� ������ �� ��쿡�� ���� ��
//������ ������ ����� �ϱ����� �޼��带 ���������� �ʴ´�.

public class Test12 {

	public static void main(String[] args) throws IOException {
		
		File f = new File("c:\\doc\\test.txt");
		
		System.out.println("���ϸ� : " + f.getName());
		System.out.println("���� ���� : " + f.length());
		System.out.println("���ϰ�� : " + f.getAbsolutePath());
		System.out.println("ǥ�ذ�� : " + f.getCanonicalPath()); //����ó�� �������
		System.out.println("���糯 : " + new Date(f.lastModified()));
		System.out.println("���� �н� : " + f.getParent());
		System.out.println("�б�Ӽ� : " + f.canRead());
		System.out.println("����Ӽ� : " + f.canWrite());

	}

}