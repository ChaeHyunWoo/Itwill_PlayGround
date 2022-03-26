package com.day14;
// Test4를 boolean으로 한 풀이		
import java.util.Scanner;


//시작
class MyAuthExcep1 {
	
	public void inputFormat(String str) throws Exception {
		
		//문자 길이 - 길이가 5보다 작거나 10보다 크면 안된다.
		if(str.length() < 5 || str.length() > 10) {
			throw new Exception("문자열의 길이는 5~10자 입니다!!");
		}
		
		 
		boolean eng = false;
		boolean num = false;
		//boolean eng, num;
		//eng = num = false;  -> 위와 같은 방법이다. 초기화 할 변수가 많을 때는 이렇게 하기!
		
		for(int i=0; i<str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if((ch>='A' && ch<='Z') || (ch>='a' && ch<'z')) {
				eng = true;
			} else if(ch>='0' && ch<='9') {
				num = true;
			}
		}	
		
		if(eng ==false || num == false)
			throw new Exception("영문자, 숫자혼용만 가능합니다.");
	}
	
}


public class Test4_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str;
		
		//위의 클래스를 사용하기위해 객체 생성
		MyAuthExcep1 auth = new MyAuthExcep1();
		
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
