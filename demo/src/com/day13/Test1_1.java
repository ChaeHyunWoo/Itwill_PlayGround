package com.day13;

//	ArrayList
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test1_1 {

	public static void main(String[] args) {
		
		ArrayList<String> lists = new ArrayList<>();
		
		lists.add("����");//������ �ֱ�
		lists.add("�λ�");
		lists.add("�뱸");
		
		//������ ����ϱ����� Iterator
		Iterator<String> it = lists.iterator();
		while(it.hasNext()) {
			String str = it.next();// �� ������ ���ٷ� �ٲٸ�
			System.out.print(str + " ");// System.out.print(it.next() + " ");
		}
		System.out.println();
		
		//ListIterator
		ListIterator<String> it1 = lists.listIterator();
		while(it1.hasNext()) {
			System.out.print(it1.next() + " ");
		}
		System.out.println();
		System.out.println("===================");
		
		while(it1.hasPrevious()) {
			System.out.print(it1.previous() + " "); //������ �ݴ�� �־��ش�.
		}
		System.out.println();
		
		List<String> lists1 = new ArrayList<String>();
		lists1.addAll(lists);
		lists1.add("��õ");
		
		int n = lists1.indexOf("�λ�");	
		lists1.add(n+1,"����");
		
		for(String s : lists1) {
			System.out.print(s+ " ");
			
		}
		System.out.println("\n-----------------");
		
		Iterator<String> it2 = lists1.iterator();
		while(it2.hasNext()) {
			String str = it2.next();
			if(str.startsWith("��")) { //String�� �޼��� : startsWith
				System.out.println(str);
			}
		}
	
	}

}