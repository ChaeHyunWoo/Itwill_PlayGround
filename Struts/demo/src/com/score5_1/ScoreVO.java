package com.score5_1;

import java.io.Serializable;

//����ȭ �ؼ� �����ϴ� implements Serializable�ϱ�

public class ScoreVO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String birth;
	private int score;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
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
		return String.format("%6s %6s %4d", name, birth, score);
	}
	

}
