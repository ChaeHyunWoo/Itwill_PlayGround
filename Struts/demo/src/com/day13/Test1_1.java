package com.day13;

//	ArrayList
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test1_1 {

	public static void main(String[] args) {
		
		ArrayList<String> lists = new ArrayList<>();
		
		lists.add("서울");//데이터 넣기
		lists.add("부산");
		lists.add("대구");
		
		//데이터 출력하기위해 Iterator
		Iterator<String> it = lists.iterator();
		while(it.hasNext()) {
			String str = it.next();// 이 두줄을 한줄로 바꾸면
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
			System.out.print(it1.previous() + " "); //순서를 반대로 넣어준다.
		}
		System.out.println();
		
		List<String> lists1 = new ArrayList<String>();
		lists1.addAll(lists);
		lists1.add("인천");
		
		int n = lists1.indexOf("부산");	
		lists1.add(n+1,"광주");
		
		for(String s : lists1) {
			System.out.print(s+ " ");
			
		}
		System.out.println("\n-----------------");
		
		Iterator<String> it2 = lists1.iterator();
		while(it2.hasNext()) {
			String str = it2.next();
			if(str.startsWith("부")) { //String의 메서드 : startsWith
				System.out.println(str);
			}
		}
	
	}

}