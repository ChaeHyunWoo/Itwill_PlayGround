package com.day2;

public class Test1 {

	public static void main(String[] args) {

		float f = 0;
		double d = 0;
		
		//for(���۰�;�ִ밪;������)
		for(int i=1;i<=100000;i++) { //i=i+1
			
			f+=100000;	//f = f + 100000; 
			d+=100000;	//d = d + 100000;
			
		}
		
		System.out.println("float: " + (f/100000));
		System.out.println("double: " + (d/100000));
		
	}

}
