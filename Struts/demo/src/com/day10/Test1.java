package com.day10;

//Wrapper 클래스
//기본 자료형을 클래스로 사용할 수 있게 해줌
//자료형
//boolean, byte, char, short, int, long, float, double
//Wrapper 클래스
//Boolean,Byte,Character, Short, Integer, Long, Float, Double

//Auto-Boxing(자료형 ->Wrapper클래스로 변환)
//Auto-unBoxing(Wrapper클래스 -> 자료형으로 변환:heap -> stack)
public class Test1 {

	public static void main(String[] args) {
		
		int n1 = 10;
		int n2;
		
		Integer num1;
		Integer num2 = new Integer(20);
		
		num1 = n1; //오토박싱
		n2 = num2; //오토언박싱
		
		System.out.println(n1 + ":" + num1);
		System.out.println(n2 + ":" + num2);
		
		int a = 24;
		System.out.println(a); // 24
		System.out.println(Integer.toString(a) + 10); //2410
		System.out.println(Integer.toString(a,2));//11000 (2진수로 출력)
		System.out.println(Integer.toString(a,16));//18 (16진수로 출력)
		
		
/*
 
int u = 10;
float f;

f = i; // 암시적 형변환
i = f; // 안들어감
i = (int)f; // 명시적 형변환. 큰 데이터를 넣기 위해서는 반드시 명시적 형변환 필수

----------------------------------------------------------------------------------
부모(f) - 자식(i)

부모(f) = 자식(i);         o  UPCAST           들어갈 수 있다. why? 부모가 자식보다 더 큰 개념이기때문
자식(i) = 부모(f);         x  
자식(i) = (자식)부모(f);   o  DOWNCAST
 */

	}

}