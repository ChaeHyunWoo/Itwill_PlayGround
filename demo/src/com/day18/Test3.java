package com.day18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//����ȭ ǥ����
//java.util.regex

/*
c[a-z]* : c�� �����ϴ� ���ܾ�
c[a-z] : c�� �����ϴ� �α��� ���ܾ�(c,ca,cz)
c[a-zA-ZO-9] : ca, cA, c4
c. : c�� �����ϴ� �α���(ca,cB,c&)
c.* : c�� �����ϴ� ������
[b|c].* �Ǵ� [bc].* �Ǵ� [b-c].* : b,c,bbb

[\\b]+ �Ǵ� [0-9]+ : �ϳ� �̻��� ����

 */
public class Test3 {

	public static void main(String[] args) {
		
		String[] str = {"bat", "baby", "bonus", "c", "cA", "ca", "c.", "c0", 
				"car", "combat", "count", "date", "disc" };
		
		Pattern p;
		
		p = Pattern.compile("c[a-z]*");
		for(String s : str) {
			Matcher m = p.matcher(s); //���ؼ� ��������
			if(m.matches()) { //��ġ�ϸ� ���
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
		
		//   [\\w]+ : �ѱ��� �̻��� ��, ����
		//   @
		//  (\\.[\\w+]) : ��ȣ �ȿ��ִ� ���� �ݵ�� �ѹ��� ǥ�� �Ǿ���
		//  \\. : .
		
		String pat = "[\\w]+@[\\w]+(\\.[\\w]+)+";
		
		for(String s : mails) {
			
			if(Pattern.matches(pat, s)) {
				System.out.println(s);
			}
		}
		
	}
}