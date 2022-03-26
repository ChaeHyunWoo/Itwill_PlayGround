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
		
		//Set : 중복값을 허용하지 않는다.
		
		Set<String> s = new HashSet<String>();
		
		s.add("서울");
		s.add("부산");
		s.add("대구");
		
		System.out.println(s); //서울,부산,대구
		
		s.add("서울"); //Set은 중복값을 허용하지 않는다.덮어씌운다.
		
		System.out.println(s); //서울,부산,대구 서울이 또 찍히지않고 덮어씌운다.
		
		System.out.println("=================");
		
		//Stack
		Stack<String> st = new Stack<String>();
		
		//Stack의 데이터추가
		st.push("서울");
		st.push("부산"); // add랑 push둘다 가능
		st.add("대구"); //대구 부산 서울 입력한것의 역순으로 나온다. 서울이 먼저 입력받아 들어가 밑에 쌓인다.
		
		//Set의 출력
		while(!st.empty()) {//데이터가 비여있지 않을때까지 (데이터가 있을 때까지)
			System.out.println(st.pop());
		}
		System.out.println("=================");

		//Queue
		Queue<String> q = new LinkedList<String>();
		
		//Queue의 데이터추가
		q.offer("서울");
		q.offer("부산");
		q.offer("대구");
		q.add("광주");
		
		//Queue의 출력
		while(q.peek()!=null) {
			System.out.println(q.poll());// Queue의 출력은 poll이다
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
		lists2.add("서울");
		lists2.add("부산");
		lists2.add("대구");
		
		lists2.addAll(lists1); //컬렉션에 컬렉션을 추가 할 수 있다.
		
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
		
		String[] str = {"라","카","하","나","마","가","다"};
		for(String ss : str)
			System.out.print(ss + " ");
		
		System.out.println();
		
		Arrays.sort(str);
		for(String ss : str)
			System.out.print(ss + " ");
		
		
		

				
		
				
				
	}

}