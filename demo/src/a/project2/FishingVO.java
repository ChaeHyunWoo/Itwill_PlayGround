package a.project2;

import java.io.Serializable;

public class FishingVO implements Serializable{
	
	
	private String aquaList;
	
	public FishingVO() {
		
	}
	
	public FishingVO (String aquaList) {
		this.aquaList = aquaList;
	}

	public String getAquaList() {
		return aquaList;
	}

	public void setAquaList(String aquaList) {
		this.aquaList = aquaList;
	}
	
	public String toString() {

		String str;
		
		str = String.format("%6s",aquaList);
		
		return str;
	}
	

}