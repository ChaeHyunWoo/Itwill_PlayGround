package com.score2;
// 인터페이스를 활용하는 문제 //
public class ScoreMain {

	public static void main(String[] args) {
		
		ScoreImpl ob = new ScoreImpl();
		
		ob.set();
		ob.input();
		ob.print();
	}
}