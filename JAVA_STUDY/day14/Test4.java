package com.day14;
//5~10자 이내의 문열을 입력받아 출력하는 프로그램
//문자열 : abcd
		// 문자열의 길이는 5~10자 입니다.
		
		//문자열 : abc2345
		//영문자만 가능합니다.		
import java.util.Scanner;


//시작
class MyAuthExcep {
	
	public void inputFormat(String str) throws Exception {
		
		//문자 길이 - 길이가 5보다 작거나 10보다 크면 안된다.
		if(str.length() < 5 || str.length() > 10) {
			throw new Exception("문자열의 길이는 5~10자 입니다!!");
		}
		
		
		int eng = 0;
		int num = 0;
		
		for(int i=0; i<str.length(); i++) {
			
			char ch = str.charAt(i);
			
			//영어만 쓸때
			//if((ch<'A' || ch>'Z' && (ch<'a' || ch>'z')) or if((ch<65 || ch>90) && (ch<97 || ch>122))
			
			if((ch>='A' && ch<='Z') || (ch>='a' && ch<'z')) {
				eng++;
			} else if(ch>='0' && ch<='9') {
				num++;
			}
		}	
		
		if(eng ==0 || num == 0)
			throw new Exception("영문자, 숫자혼용만 가능합니다.");
	}
	
}


public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str;
		
		//위의 클래스를 사용하기위해 객체 생성
		MyAuthExcep auth = new MyAuthExcep();
		
		try {
			System.out.print("문자열 : ");
			str = sc.next();
			
			//검증하기위해 inputFormat으로 보냄
			auth.inputFormat(str);
			
			System.out.println(str);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}