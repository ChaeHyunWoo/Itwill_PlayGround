package com.day13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Test3 {

	public static void main(String[] args) {
		
		//Set : �ߺ����� ������� �ʴ´�.
		
		Set<String> s = new HashSet<String>();
		
		s.add("����");
		s.add("�λ�");
		s.add("�뱸");
		
		System.out.println(s); //����,�λ�,�뱸
		
		s.add("����"); //Set�� �ߺ����� ������� �ʴ´�.������.
		
		System.out.println(s); //����,�λ�,�뱸 ������ �� �������ʰ� ������.
		
		System.out.println("=================");
		
		//Stack
		Stack<String> st = new Stack<String>();
		
		//Stack�� �������߰�
		st.push("����");
		st.push("�λ�"); // add�� push�Ѵ� ����
		st.add("�뱸"); //�뱸 �λ� ���� �Է��Ѱ��� �������� ���´�. ������ ���� �Է¹޾� �� �ؿ� ���δ�.
		
		//Set�� ���
		while(!st.empty()) {//�����Ͱ� ������ ���������� (�����Ͱ� ���� ������)
			System.out.println(st.pop());
		}
		System.out.println("=================");

		//Queue
		Queue<String> q = new LinkedList<String>();
		
		//Queue�� �������߰�
		q.offer("����");
		q.offer("�λ�");
		q.offer("�뱸");
		q.add("����");
		
		//Queue�� ���
		while(q.peek()!=null) {
			System.out.println(q.poll());// Queue�� ����� poll�̴�
		}
		System.out.println("=================");

		List<String> lists1 = new LinkedList<String>();
		lists1.add("A");
		lists1.add("B");
		lists1.add("C");
		lists1.add("D");
		lists1.add("E");
		lists1.add("F");
		lists1.add("G");
		lists1.add("H");
		lists1.add("I");

		List<String> lists2 = new LinkedList<String>();
		lists2.add("����");
		lists2.add("�λ�");
		lists2.add("�뱸");
		
		lists2.addAll(lists1); //�÷��ǿ� �÷����� �߰� �� �� �ִ�.
		
		System.out.println("lists1.............");
		for(String ss : lists1) {
			System.out.println(ss);
		}
		System.out.println("\nlists2.............");
		for(String ss : lists2) {
			System.out.println(ss);
		}
	
		lists2.subList(2, 5).clear();
		System.out.println("\nlists2.............");
		for(String ss : lists2) {
			System.out.println(ss);
		}
		
		String[] str = {"��","ī","��","��","��","��","��"};
		for(String ss : str)
			System.out.print(ss + " ");
		
		System.out.println();
		
		Arrays.sort(str);
		for(String ss : str)
			System.out.print(ss + " ");
		
		
		

				
		
				
				
	}

}