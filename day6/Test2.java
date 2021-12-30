package com.day6;

import java.util.Scanner;

class Hap {
	
	int su, sum; //instance변수(전역변수) 인스턴스변수는 자동으로 초기화를 해줌
	
	
	public void input() {// method(메소드) - 입력 역할
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 :");
		su = sc.nextInt();
	}
	
	public int cnt() {
		
		for(int i=1; i<=su; i++) {
			sum += i; // sum = sum+i
		}
		return sum; // sum으로 반환해줌
	}
	
	public void print(int i) {	// 출력 역할
		
		System.out.println("합계: " + i);
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		
		Hap h = new Hap(); //객체 생성         클래스는 값을 저장하는역할을 하기에 자료형이다.
		
		h.input(); // input 클래스 호출
		int sum = h.cnt(); // cnt클래스 호출	cnt클래스는 int형
		h.print(sum); // print 클래스 호출
		
	}

}
