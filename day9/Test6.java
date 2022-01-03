package com.day9;
//String 클래스의 메소드들 배우기!
// 여기 적힌 메소드들은 알고 있어야한다.(자주사용)
public class Test6 {

	public static void main(String[] args) {
		
		//split은 String클래스의 메소드
		String s1 = "서울,부산,대구";
		String [] ss = s1.split(",");
		
		for(String s : ss) 
			System.out.print(s + " ");
		System.out.println();
		
		String s2 = "seoul";
		String s3 = "Seoul";
		System.out.println(s2.equals(s3)); //false
		System.out.println(s2.equalsIgnoreCase(s3)); //true
		
		
		String s4 = "abc.def.hij";
		//           01234567890        < - index 번호 부여
		System.out.println(s4.indexOf(".")); // 3 
		System.out.println(s4.lastIndexOf("."));// 7
		System.out.println(s4.indexOf("def")); // 4
		System.out.println(s4.indexOf("x"));// -1
		
		String s5 = "우리나라 대한민국 좋은나라 대한민국";
		String s6 = s5.replaceAll("대한", "大韓");
		System.out.println(s6);
		
		String s7 = "  a  b  c  ";
		System.out.println(s7);
		System.out.println(s7.trim()); //trim 메소드는 양쪽의 공백을 없애준다.
		System.out.println(s7.replaceAll(" ", "")); // ex)공백이 있는걸 공백이 없는 것으로 만들자.
		System.out.println(s7.replaceAll("\\s", ""));
		
		char ch = "abcdefg".charAt(2);
		System.out.println(ch); // c

		System.out.println("abcdefg".length()); // 7
		
		String s8 = "abcdefg";
		String s9 = "abceefg";
		//아스키값으로 비교하는 방법
		System.out.println(s8.compareTo(s9)); // -1
		System.out.println(s9.compareTo(s8)); // 1
		
	}	
}