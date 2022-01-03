package com.day9;

public class Test5 {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("서울");
		sb.append("부산");
		System.out.println(sb);
		
		String str = sb.toString();
		System.out.println(str);
	}

}