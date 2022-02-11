package com.calc;

public class Calc {
	
	private int su1;
	private int su2;
	private String oper;
	
	
	//개터세터
	public int getSu1() {
		return su1;
	}
	public void setSu1(int su1) {
		this.su1 = su1;
	}
	public int getSu2() {
		return su2;
	}
	public void setSu2(int su2) {
		this.su2 = su2;
	}
	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}
	
	
	public String sum() {
		
		String str = "";
		int result = 0;
		
		if(oper != null) {
			
			if(oper.equals("+"))
				
				result = su1 + su2;
			
			else if(oper.equals("-"))
				
				result = su1 - su2;
			
			else if(oper.equals("*"))
				
				result = su1 * su2;
			
			else if(oper.equals("/"))
				
				result = su1 / su2;
		}
		
		str = String.format("%d %s %d = %d", su1,oper,su2,result);
		
		return str;
	}
	
	
	

}
