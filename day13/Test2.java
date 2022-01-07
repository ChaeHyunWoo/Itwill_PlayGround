package com.day13;

import java.util.Hashtable;
import java.util.Iterator;

//Map(I) - Hashtable(C), HashMap(C)
//Hashtable : Vector와 동일
//HashMap : ArrayList와 동일

//Map<key, value>
//키는 중복값을 가질수 없다.(key:Set)
//키가 중복되면 마지막 값이 저장된다.(수정)
//Map은 Iterator가 없다.
//put(키, 값) : 추가
//get(키, 값) : 읽기
public class Test2 {
	
	//key
	public static final String[] tel = { "11-111", "222-222", "333-333", "1111-111", "444-444"};
	
	//value
	public static final String[] name = {"배수지", "유인나", "정인성", "안젤리나", "정인아"};

	public static void main(String[] args) {
		
		//데이터 타입이 다 String이라서 확인가능하다
		Hashtable<String, String> h = new Hashtable<>();
		
		for(int i=0; i<name.length; i++) {
			h.put(tel[i], name[i]);
		}
		
		System.out.println(h);
		
		String str;
		
		//key를 주면 value를 가져온다
		str = h.get("111-111");
		
		
		if(str==null || str.equals("")) { //if(str==null)
			System.out.println("자료없음!");
		} else {
			System.out.println(str);
		}
		
		//값이 존재하는지 검사
		if(h.containsKey("222-222")) {
			System.out.println("222-222가 존재");
		}
		
		//값이 존재하는지 검사
		if(h.containsKey("유인나")) {
			System.out.println("유인나 여기 있어요~");
		
		}
		
		
		//삭제
		h.remove("222-222");
		if(h.containsKey("222-222")) {
			System.out.println("222-222가 존재");
		} else {
			System.out.println("222-222가 존재x ");
		}
		
		//Map의 key자료형은 set이다
		Iterator<String> it = h.keySet().iterator();
		while(it.hasNext()) {
			
			String key = it.next(); //key만 읽음
			String value = h.get(key); // value을 읽음 - key를 value한테 주면 값을 읽어온다.
			
			System.out.println(key + ":" + value);
		}

	}
}