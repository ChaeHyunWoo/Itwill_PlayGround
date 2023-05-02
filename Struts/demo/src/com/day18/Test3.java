package com.day18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//정규화 표현식
//java.util.regex

/*
c[a-z]* : c로 시작하는 영단어
c[a-z] : c로 시작하는 두글자 영단어(c,ca,cz)
c[a-zA-ZO-9] : ca, cA, c4
c. : c로 시작하는 두글자(ca,cB,c&)
c.* : c로 시작하는 모든글자
[b|c].* 또는 [bc].* 또는 [b-c].* : b,c,bbb

[\\b]+ 또는 [0-9]+ : 하나 이상의 숫자

 */
public class Test3 {

	public static void main(String[] args) {
		
		String[] str = {"bat", "baby", "bonus", "c", "cA", "ca", "c.", "c0", 
				"car", "combat", "count", "date", "disc" };
		
		Pattern p;
		
		p = Pattern.compile("c[a-z]*");
		for(String s : str) {
			Matcher m = p.matcher(s); //비교해서 꺼내놓고
			if(m.matches()) { //일치하면 출력
				System.out.println(s);
			}
		}
		
		System.out.println("-----------------------------------------");
		
		p = Pattern.compile("c.");
		for(String s : str) {
			Matcher m = p.matcher(s);
			if(m.matches()) {
				System.out.println(s);
			}
		}
		
		System.out.println("-----------------------------------------");
		
		String[] mails = {"aaa@aaa.com", "@aaa.co.kr", ".bbb.com", "aaa@vvv.co.kr", "sss.co.kr", "abc@aaa"};
		
		//   [\\w]+ : 한글자 이상의 영, 숫자
		//   @
		//  (\\.[\\w+]) : 괄호 안에있는 것은 반드시 한번은 표시 되야함
		//  \\. : .
		
		String pat = "[\\w]+@[\\w]+(\\.[\\w]+)+";
		
		for(String s : mails) {
			
			if(Pattern.matches(pat, s)) {
				System.out.println(s);
			}
		}
		
	}
}