package com.day12;

import java.util.Vector;

// Collection Framework(방법론)

/*
 배열의 단점
 1. 크기를 정하면 변경이 불가능
 2. 미리 크게 잡으면 메모리 낭비가 될 수 있음.
 3. 배열사이에 삽입이 불가능
 
 Collection 종류 - List, Vector, Set, Hashtable, TreeSet, HashSet 등이 있다.
 
 List(I) - ArrayList(C), Vector(C)												I = 인터페이스 , C = 클래스
 Vector는 동기화를 지원하는 대신 느리다/ArrayList는 동기화지원x 대신 빠르다.
 
 Map(I) - Hashtable(C), HashSet(C)
 */
public class Test5 {
	
	

	public static void main(String[] args) {
		
		//Vector<E> E는 제러닉이라하는데 이 Vecotr의 자료형을 뭐로 정할지 고르는거 기본은 String이다.
		
		Vector v = new Vector<>(); // Vector(컬렉션모두) 기본 데이터 타입이 Object이다.
		
		v.add("서울"); // 컬렉션은 기본 디폴트가 object이다. 서울은 String인데 object에 넣어서 upcast
		v.add(30); //upcast				//Object안에 넣는거라 모든것이 upcast이다
		v.add('c'); //upcast
		
		
		//꺼내줄때 는 서울이 Object라서 downcast를 해줘야함 - 형변환
		String s = (String)v.get(0);
		System.out.println(s);
		
		Integer i = (Integer)v.get(1);
		System.out.println(i);
		
		char c = (char)v.get(2);
		System.out.println(c);
		
	}

}