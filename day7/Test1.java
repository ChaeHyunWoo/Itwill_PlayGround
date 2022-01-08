package com.day7;

// this : 클래스이름(ME)
//클래스 이름인데 클래스 안에 같은 클래스를 입력하면 헷갈려서 this로 표현
class Circle { // Circle 클래스
	
	private int r; // 인스턴스변수(맴버변수) - 정보의 은닉화(캡슐화)
					  // 값을 변경할 수 있으니 외부에서 접근하지 못하게 접근 지정자 지정
	
	//초기화 메서드. 매개변수 이용
	public void setDate(int r) { //setData(int r, Circle this)내부적으로 이렇게 처리
		//우회도로
		this.r =r; // 전역변수r, 지역변수r, 처럼 이름이 동일하면 java가 구분하지 못함. 전역변수로 인식하기 위해 this 사용.
					// this는 me와 같다(클래스이름의 대명사)
					// Circle를 this로 바꾼 것이다.(클래스 안에 같은 클래스명을 쓰면 오류가 뜸)
	}				
	
	// 메서드
	public double area() {	//  area(Circle this)
		return r*r*3.14;
		//retrun this.r*this.r*3.14;
	}
	
	//메서드 - void가 있으면 반환값 x
	public void result(double a) { // result(double a, Circle this)
		System.out.println("반지름 : " + r);	 // = ("반지름 : " + this.r);
		System.out.println("넓이 : " + r);
		
	}
}

public class Test1 {

	public static void main(String[] args) {
		
		 Circle ob = new Circle();	// ob는 Circle의 다른 이름
		 //ob.r은 캡슐화되어있어 외부에서 접근 못함.
		 
		 
		 ob.setDate(10);	// = setData(10.ob); -> 내부적으로 ob클래스의 주소를 가져감.
		 double a = ob.area(); // ob.area(ob) -> 매개변수가 없으므로 ob클래스 주소만 가져감
		 ob.result(a); // result(a, ob)
		 
		 ob.setDate(100);
		 a = ob.area();
		 ob.result(a);	
	}

}