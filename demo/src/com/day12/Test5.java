package com.day12;

import java.util.Vector;

// Collection Framework(�����)

/*
 �迭�� ����
 1. ũ�⸦ ���ϸ� ������ �Ұ���
 2. �̸� ũ�� ������ �޸� ���� �� �� ����.
 3. �迭���̿� ������ �Ұ���
 
 Collection ���� - List, Vector, Set, Hashtable, TreeSet, HashSet ���� �ִ�.
 
 List(I) - ArrayList(C), Vector(C)												I = �������̽� , C = Ŭ����
 Vector�� ����ȭ�� �����ϴ� ��� ������/ArrayList�� ����ȭ����x ��� ������.
 
 Map(I) - Hashtable(C), HashSet(C)
 */
public class Test5 {
	
	

	public static void main(String[] args) {
		
		//Vector<E> E�� �������̶��ϴµ� �� Vecotr�� �ڷ����� ���� ������ ���°� �⺻�� String�̴�.
		
		Vector v = new Vector<>(); // Vector(�÷��Ǹ��) �⺻ ������ Ÿ���� Object�̴�.
		
		v.add("����"); // �÷����� �⺻ ����Ʈ�� object�̴�. ������ String�ε� object�� �־ upcast
		v.add(30); //upcast				//Object�ȿ� �ִ°Ŷ� ������ upcast�̴�
		v.add('c'); //upcast
		
		
		//�����ٶ� �� ������ Object�� downcast�� ������� - ����ȯ
		String s = (String)v.get(0);
		System.out.println(s);
		
		Integer i = (Integer)v.get(1);
		System.out.println(i);
		
		char c = (char)v.get(2);
		System.out.println(c);
		
	}

}