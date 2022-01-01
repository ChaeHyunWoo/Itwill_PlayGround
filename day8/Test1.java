package com.day8;

//Call By value
//stack영역의 Heap영역으로 데이가 넘어감  
//Call By Reference 
//값을 넘길때 객체의 시작점 주소가 넘어감    객체의 값이 하나라 두명의 남자가 전화번호를 서로 나누어 가짐 



class Test{
	
	public int x = 10;
									//보이지 않는 기본생성자 
	public void sub(int a) {
		x += a;
		
	}
}


public class Test1 {

	public static void main(String[] args) {
		
		Test ob = new Test();
		
		//Call by value 
		int a = 20;
		
		System.out.println("Sub메소드 실행전 x: " + ob.x);
		ob.sub(a);
		System.out.println("Sub메소드 실행후 x: " + ob.x);
		
		
		//Call By Reference @중요@
		
		Test ob1; //같은 남자여야해
		ob1 = ob;
		
		System.out.println(ob.x); //30
		System.out.println(ob1.x);//30
		
		ob1.x = 100;
		System.out.println(ob.x); // 100
		System.out.println(ob1.x);// 100
		
	}

}