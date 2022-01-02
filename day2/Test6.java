package com.day2;

import java.util.*;

//Scanner는 단락 문자를 구분해서 데이터를 입력받을 수 있음.
//기본 단락은 공백이다.
public class Test6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String name;
		int kor, eng, mat;

		// System.out.println("이름 국어 영어 수학? ");// suzi 40 50 70
		System.out.println("이름,국어,영어,수학? ");// suzi 40 50 70

		sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*");// 정규화 표현식

		name = sc.next(); // 이름
		kor = sc.nextInt(); // 국어
		eng = sc.nextInt(); // 영어
		mat = sc.nextInt(); // 수학

		System.out.println(name + ":" + (kor + eng + mat) + "점");

		sc.close(); // 꼭 써야하는건 아님.
	}

}
