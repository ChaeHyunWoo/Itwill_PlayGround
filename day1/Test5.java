package com.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test5 {

	public static void main(String[] args) throws IOException {
		
		//����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String name; //String�� �ڷ���ó�� ������ Ŭ�����̴�.
		int kor, eng, tot;
		
		//�Է�
		System.out.print("�̸�?"); //suzi
		name = br.readLine();
		
		System.out.println("����?");//60
		kor = Integer.parseInt(br.readLine());
		
		System.out.println("����?"); //70
		eng = Integer.parseInt(br.readLine());
		
		//����
		tot = kor + eng;
		
		//���
		System.out.println("�̸�: " + name);
		System.out.println("����: " + kor +", ����: " + eng);
		System.out.println("����: " + tot + "��");
	}

}