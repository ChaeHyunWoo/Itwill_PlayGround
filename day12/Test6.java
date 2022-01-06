package com.day12;

import java.util.Iterator;
import java.util.Vector;

public class Test6 {
	
	private static final String[] city = {"서울", "부산", "대구", "인천", "광주", "대전", "울산"};

	public static void main(String[] args) {
		
		//여기서는 downcast를 할 필요가 없다. why? Vector를 String으로 해줘서
		Vector<String> v = new Vector<>();
		
		for(String s : city) {
			v.add(s); // add는 추가
			
		}
		
		//v.add(10);
		
		String str;
		
		str = v.firstElement(); // 데이터가 몇개든 첫번 째꺼 꺼내기
		System.out.println(str); // 서울
		
		str = v.get(0); // index 0번째 를 꺼내와라
		System.out.println(str); // 서울
		
		str = v.get(1);
		System.out.println(str); // 부산
		
		str = v.lastElement(); // 데이터가 몇개가 되든 마지막꺼 꺼내기
		System.out.println(str);
		
		//for
		for(int i=0; i<v.size(); i++) {
			System.out.print(v.get(i) + " "); // 서울 부산 대구 인천 광주 대전 울산 
		}
		System.out.println(); // 
		
		//확장for
		for(String s : v) {
			System.out.print(s + " ");
		}
		System.out.println(); // 서울 부산 대구 인천 광주 대전 울산 
		
		
		//Iterator(전용출력기) - 반복자 - 데이터가 많으면 많을수록 for문 or 확장for보다 더 빠르다.
		Iterator<String> it = v.iterator(); // vector에 있는 iterator를 써서 데이터를 꺼내서 it에 넣음
		while(it.hasNext()) { 
			
			str = it.next();
			System.out.print(str + " ");
			
		}

	}

}