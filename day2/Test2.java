package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		// system.in은 1바이트 문자를 읽어낸다.
		// InputStreamReader은 1바이트 문자를 2바이트로 바꿔서 읽어낸다.
		int num1,num2;
		
		System.out.print("ù��° ��?");//20
		num1 = Integer.parseInt(br.readLine());
		
		System.out.print("�ι�° ��?");//5
		num2 = Integer.parseInt(br.readLine());
		
		System.out.printf("%d + %d = %d\t",num1,num2,num1+num2);
		System.out.printf("%d - %d = %d\n",num1,num2,num1-num2);
		System.out.printf("%d * %d = %d\t",num1,num2,num1*num2);
		System.out.printf("%d / %d = %d\n",num1,num2,num1/num2);
		System.out.printf("%d %% %d = %d\n",num1,num2,num1%num2);
		
		System.out.println("num1>num2: " + (num1>num2));
		System.out.println("num1==num2: " + (num1==num2));
		
		
		String str;
		
		//삼항연산자(조건?true값; : false값)
		str = num1%2==0?"¦��":"Ȧ��";
		
		str = num1>0?"���":(num1<0?"����":"��");
		
		 //1. 조건이 true이면 "양수"를 실행, 2. false이면 (num1<0?부분을 실행하는데 여기도
		 //3. 거짓이면 "음수" : "영" 실행

		//  (그리고)  A and(&&) B : A, B 둘다 true이여만 결과가 true
		//  (또는)    A OR(||) B : A,B 둘중 하나만 true이면 결과가 true
	
		str = num1%4==0 && num1%100!=0 || num1%400==0?"����":"���";
		
		System.out.println(num1 + ":" + str);


		//https://blog.naver.com/lbr71004/222158448268
		//※ 주의사항

		//1. 삼항연산자를 사용하여 코드의 라인이 줄어들었다고 컴파일 속도가 빨라지는 것은 아닙니다.

		//2. 삼항연산자를 중복해서 처리할 경우. 가독성이 떨어질 수 있으므로 중복처리는 피하는것이 좋습니다.

	}

}



