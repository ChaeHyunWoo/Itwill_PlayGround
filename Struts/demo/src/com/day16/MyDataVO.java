package com.day16;

import java.io.Serializable;

//implements Serializable를 해줘야 직렬화가 된다
public class MyDataVO implements Serializable {
	
	private String name;
	private int score;
	
	
	public MyDataVO(String name, int score) {
		
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name + ":" + score;
	}
	
	


}
