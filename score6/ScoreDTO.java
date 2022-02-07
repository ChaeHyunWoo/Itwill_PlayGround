package com.score6;
//오늘 하는건 끝나는 날까지함 매우 중요함!!!
//DB에서는 VO대신 DTO로 만듬
public class ScoreDTO { // data transfer object - 데이터를 전달하는 객체
	
	//DB에 데이터를 입력할땐 이 5개의 변수만씀
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	//DB에서 데이터를 꺼내올때는 아래 3개포함 총 8개의 변수를 씀
	private int tot;
	private int ave;
	private int rank;
	
	
	//마우스 우클릭-> source ->getters & setters 해서 모두 체크!
	public String getHak() {
		return hak;
	}
	
	public void setHak(String hak) {
		this.hak = hak;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getMat() {
		return mat;
	}
	
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public int getTot() {
		return tot;
	}
	
	public void setTot(int tot) {
		this.tot = tot;
	}
	
	public int getAve() {
		return ave;
	}
	
	public void setAve(int ave) {
		this.ave = ave;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	//toString 오버라이드
	@Override
		public String toString() {
		
			String str;
			
			str = String.format("%6s %8s %4d %4d %4d %4d %4d %4d", 
					hak,name,kor,eng,mat,tot,ave,rank);
			
			return str;
			
		}

}