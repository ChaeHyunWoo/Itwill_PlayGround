package com.day16;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

//��ü�� ����ȭ
//�޸𸮿� ������ Ŭ���� ��ü�� �ν��Ͻ������� ���� ���¸�
//�״�� ���Ͽ� �����ϰų� ��Ʈ��ũ�� ���ؼ� ���� �� ���ִ� ���
//������ ����Ʈ �����θ� �����͸� �ۼ��� �� �� �ִ�.

//������ ��ü�� ������ ����� ���Ŀ� ���� ���� �ʰ� ��ü�� ���Ͽ� ���������ν�
//���Ӽ��� ������ �� �ְ�, ��ü ��ü�� ��Ʈ��ũ�� ���� �ս��� ��ȯ�� �� �ְ� �ȴ�.

//implements Serializable
// �޼��尡 ����.

public class Test15 {

	public static void main(String[] args) throws Exception {
		
		Hashtable<String, String> h = new Hashtable<>();
		
		h.put("1", "�����");
		h.put("2", "���γ�");
		h.put("3", "���μ�");
		
		//����ȭ �� �����͸� ����
		FileOutputStream fos = new FileOutputStream("c:\\doc\\out.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(h);
		oos.close();
		oos.close();
		
		System.out.println("����ȭ ������ ���� ����!!");
		
	
	}

}