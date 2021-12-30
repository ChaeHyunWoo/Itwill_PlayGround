package com.day7;

public class Data {
	
	static String name = "아이유"; // static 변수이므로 이미 메모리 할당되어 있다.
	static int age = 27;
	
	public static void getInstance() {
		System.out.println(name + "의 나이는 " + age + "살 입니다.");
		
	}
	
	
}