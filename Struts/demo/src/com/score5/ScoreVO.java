package com.score5;

import java.io.Serializable;

public class ScoreVO implements Serializable {
	
	private String name;
	private int birth;
	private int score;
	
	public ScoreVO(String name, int birth, int score) {
		
		this.name = name;
		this.birth = birth;
		this.score = score;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {

		String str = String.format("%s %d %d",name,birth,score);
		return str;
	}
	
}