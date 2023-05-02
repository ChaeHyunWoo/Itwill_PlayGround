package com.day12;

import java.util.Iterator;
import java.util.Vector;

public class Test6 {
	
	private static final String[] city = {"����", "�λ�", "�뱸", "��õ", "����", "����", "���"};

	public static void main(String[] args) {
		
		//���⼭�� downcast�� �� �ʿ䰡 ����. why? Vector�� String���� ���༭
		Vector<String> v = new Vector<>();
		
		for(String s : city) {
			v.add(s); // add�� �߰�
			
		}
		
		//v.add(10);
		
		String str;
		
		str = v.firstElement(); // �����Ͱ� ��� ù�� °�� ������
		System.out.println(str); // ����
		
		str = v.get(0); // index 0��° �� �����Ͷ�
		System.out.println(str); // ����
		
		str = v.get(1);
		System.out.println(str); // �λ�
		
		str = v.lastElement(); // �����Ͱ� ��� �ǵ� �������� ������
		System.out.println(str);
		
		//for
		for(int i=0; i<v.size(); i++) {
			System.out.print(v.get(i) + " "); // ���� �λ� �뱸 ��õ ���� ���� ��� 
		}
		System.out.println(); // 
		
		//Ȯ��for
		for(String s : v) {
			System.out.print(s + " ");
		}
		System.out.println(); // ���� �λ� �뱸 ��õ ���� ���� ��� 
		
		
		//Iterator(������±�) - �ݺ��� - �����Ͱ� ������ �������� for�� or Ȯ��for���� �� ������.
		Iterator<String> it = v.iterator(); // vector�� �ִ� iterator�� �Ἥ �����͸� ������ it�� ����
		while(it.hasNext()) { 
			
			str = it.next();
			System.out.print(str + " ");
			
		}

	}

}