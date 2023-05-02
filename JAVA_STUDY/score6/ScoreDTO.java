package com.score6;
//���� �ϴ°� ������ �������� �ſ� �߿���!!!
//DB������ VO��� DTO�� ����
public class ScoreDTO { // data transfer object - �����͸� �����ϴ� ��ü
	
	//DB�� �����͸� �Է��Ҷ� �� 5���� ��������
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	//DB���� �����͸� �����ö��� �Ʒ� 3������ �� 8���� ������ ��
	private int tot;
	private int ave;
	private int rank;
	
	
	//���콺 ��Ŭ��-> source ->getters & setters �ؼ� ��� üũ!
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
	
	//toString �������̵�
	@Override
		public String toString() {
		
			String str;
			
			str = String.format("%6s %8s %4d %4d %4d %4d %4d %4d", 
					hak,name,kor,eng,mat,tot,ave,rank);
			
			return str;
			
		}

}