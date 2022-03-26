package com.day12;

//4. 내부클래스(익명의, 무명의, Anonymous클래스)
public class Test4 {
	
	public Object getTitle() {
		
		return new Object() { 
			
			@Override
			public String toString() {//여기부터
				return "익명의 클래스";
			}
		};// 이게 반환값이 된다. -> 여기까지
	}

	public static void main(String[] args) {
		
		Test4 ob = new Test4();
			
			Object str = ob.getTitle();//Object로 받아서 찍는다.
			
			System.out.println(str);
					
	}

}