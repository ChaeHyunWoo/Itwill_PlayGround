package com.score1;

public class ScoreMain {

	public static void main(String[] args) {
		
		Score ob = new Score(); //객체 생성
		
		ob.set();
		//ob.inwon = 3; 이렇게 하면 오류뜸
		ob.input();
		ob.print();
	}

}
