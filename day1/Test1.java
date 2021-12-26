package com.day1;

//public, private : 접근지정자
//Test1(클래스이름) : 첫글자는 영문자 대문자/단어구분을 위해 던어첫글자는 대문자 : 카멜표기법 ex) CustomInfo
public class Test1 {

	public static void main(String[] args) {
		//System은 이클리스의 클래스이고, out은 main에 있는 메소드, " ~ " 는 매개변수
		//print는 사용자가 입력한 값을 콘솔창에 뿌려주는 역할
		System.out.print("자바의 세계에 오신것을 환영합니다!!!\n\n");
		System.out.println("자바 첫시간");
		
	}

}
/*

method(메소드) : 실행 명령어
void는 반환값없고 실행만하는것
main : 메소드 이름(영문 소문자 시작)
(String[] args) : String[]는 매개변수
Test1이라는 클래스에 들어가고싶은데 Main이 출입문 역할
VM(인터프리터)이 찾는 첫번째 메소드(main)이다.
인터프리터란 실행하는 순서가 1번라인부터 마지막라인까지 순처적으로 실행하는 것
컴파일은 기계어로 바꾸는것
*/
