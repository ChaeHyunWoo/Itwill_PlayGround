package com.day9;
//String Ŭ������ �޼ҵ�� ����!
// ���� ���� �޼ҵ���� �˰� �־���Ѵ�.(���ֻ��)
public class Test6 {

	public static void main(String[] args) {
		
		//split�� StringŬ������ �޼ҵ�
		String s1 = "����,�λ�,�뱸";
		String [] ss = s1.split(",");
		
		for(String s : ss) 
			System.out.print(s + " ");
		System.out.println();
		
		String s2 = "seoul";
		String s3 = "Seoul";
		System.out.println(s2.equals(s3)); //false
		System.out.println(s2.equalsIgnoreCase(s3)); //true
		
		
		String s4 = "abc.def.hij";
		//           01234567890        < - index ��ȣ �ο�
		System.out.println(s4.indexOf(".")); // 3 
		System.out.println(s4.lastIndexOf("."));// 7
		System.out.println(s4.indexOf("def")); // 4
		System.out.println(s4.indexOf("x"));// -1
		
		String s5 = "�츮���� ���ѹα� �������� ���ѹα�";
		String s6 = s5.replaceAll("����", "����");
		System.out.println(s6);
		
		String s7 = "  a  b  c  ";
		System.out.println(s7);
		System.out.println(s7.trim()); //trim �޼ҵ�� ������ ������ �����ش�.
		System.out.println(s7.replaceAll(" ", "")); // ex)������ �ִ°� ������ ���� ������ ������.
		System.out.println(s7.replaceAll("\\s", ""));
		
		char ch = "abcdefg".charAt(2);
		System.out.println(ch); // c

		System.out.println("abcdefg".length()); // 7
		
		String s8 = "abcdefg";
		String s9 = "abceefg";
		//�ƽ�Ű������ ���ϴ� ���
		System.out.println(s8.compareTo(s9)); // -1
		System.out.println(s9.compareTo(s8)); // 1
		
	}	
}