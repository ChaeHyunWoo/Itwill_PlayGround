package com.day12;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Test7 {
	
	private static final String[] city = {"서울", "부산", "대구", "인천", "광주", "대전", "울산"};

	
	public static void main(String[] args) {
		
		//Generic
		Vector<String> v = new Vector<>(); //Vector은 생성하면 내부적으로 배열을 자동으로 일정개수를 만듬 10개
		
		String str;
		System.out.println("백터의 초기 용량 : " + v.capacity()); // 백터의 초기 용량 : 10
		
		for(String s : city) {
			v.add(s);
		}
		
		Iterator<String> it = v.iterator();
		while(it.hasNext()) { //데이터가 있을 때까지 꺼내라
			
			str = it.next();
			System.out.print(str + " ");//서울 부산 대구 인천 광주 대전 울산 
		}
		System.out.println();
		
		System.out.println("데이터의 갯수 : " + v.size()); // 데이터의 갯수 : 7
		
		//수정
		v.set(0, "Seoul"); // 0번째 자리에 "서울"을 넣어라
		v.set(1, "Busan");
		
		for(String s : v) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		//삽입
		v.insertElementAt("대한민국", 0); // "대한민국"을 넣을 것이고 0번째 index에 넣는다.
		for(String s : v) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println("백터의 현재 용량 : " + v.capacity()); // 백터의 현재 용량 : 10
		System.out.println("데이터의 갯수 : " + v.size()); // 데이터의 갯수 : 8 
		
		//검색
		int index = v.indexOf("대구"); // 대구가 있는 곳의 index를 가지고 와라
		if(index != -1) { // -1은 데이터가 없을 경우 -> != 으로 하면  데이터가 있으면
			System.out.println("검색 성공!!" + index); // 검색 성공!!3
		} else {
			System.out.println("검색 실패!!" + index); // 검색 실패!!-1
		}
		
		
		//오름차순
		Collections.sort(v);
		for(String s : v) {
			System.out.print(s + " "); //Busan Seoul 광주 대구 대전 대한민국 울산 인천 -> 가나다순으로 정렬
		}
		System.out.println();
		
		//내림차순
		Collections.sort(v, Collections.reverseOrder()); 
		for(String s : v) {
			System.out.print(s + " "); // 인천 울산 대한민국 대전 대구 광주 Seoul Busan 
		}
		System.out.println();
		
		//삭제
		v.remove(7); // 삭제할 index번호( ) // v.remove("Busan");
		for(String s : v) {
			System.out.print(s + " "); // 인천 울산 대한민국 대전 대구 광주 Seoul  -> Busan 삭제됨.
		}
		System.out.println();
		
		//용량 증가
		for(int i=1; i<=20; i++) {
			v.add(Integer.toString(i));
		}
		for(String s : v) {
			System.out.print(s + " "); // 인천 울산 대한민국 대전 대구 광주 Seoul 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 
		}
		System.out.println();
		System.out.println("백터의 현재 용량 : " + v.capacity()); // 백터의 현재 용량 : 40
		System.out.println("데이터의 갯수 : " + v.size()); // 데이터의 갯수 : 27
		
		
		//삭제 (tip - 백터는 용량이 알아서 늘어나지면 자동으로 줄어들지는 않음.사용자가 수동으로 줄여야함)
		for(int i=1; i<=10; i++) {
			v.remove(5); // 5번째 index 광주부터 시작해서 10개의 데이터를 지움
		}
		for(String s : v) {
			System.out.print(s + " "); // 인천 울산 대한민국 대전 대구 9 10 11 12 13 14 15 16 17 18 19 20 
		}
		System.out.println();
		System.out.println("백터의 현재 용량 : " + v.capacity()); //백터의 현재 용량 : 40
		System.out.println("데이터의 갯수 : " + v.size()); //데이터의 갯수 : 17
		
		
		//미사용 공간 삭제(사용자가 수동으로 삭제해야함) - 데이터의 공간만 남기고 남은 빈공간(미사용공간) 삭제
		v.trimToSize();
		System.out.println();
		System.out.println("백터의 현재 용량 : " + v.capacity()); //백터의 현재 용량 : 17
		System.out.println("데이터의 갯수 : " + v.size()); //데이터의 갯수 : 17
		
		
		//모든 데이터 삭제
		v.clear();
		System.out.println("백터의 현재 용량 : " + v.capacity()); //백터의 현재 용량 : 17
		System.out.println("데이터의 갯수 : " + v.size()); //데이터의 갯수 : 0
	}
	

}