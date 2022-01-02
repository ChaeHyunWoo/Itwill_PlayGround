package com.day7;

// this : 클래스이름(ME)
//클래스 이름인데 클래스 안에 같은 클래스를 입력하면 이상해서 this로 표현
class Circle {	//사용자한테 반지름값을 받아서 계산해서 출력
	
	private int r;	//instance(인스턴스)변수/ 값을 변경할 수 있으니 외부에서 접근하지 못하게 접근지정자 지정
					//정보의 은닉화(캡슐화)
	
	//초기화 메소드.매개변수 이용
	public void setData(int r) {//setData(int r, Circle this)내부적으로는 이렇게 처리된다.
	   //우회도로
		this.r = r;	//전역변수 r, 지역변수 r처럼 이름이 동일하면 java가 구분하지 못함. 전역변수로 인식하기 위해 this 사용.
					//this는 me와 같다(클래스이름의 대명사)
					//Circle를 this로 바꾼것이다.(클래스안에 같은 클래스명을 쓰면 오류가뜨기에)
	}
	
	public double area() {	// area(Circle this)
		return r*r*3.14;	//아래랑 같다. 혼동될때(우회도로) 아니면 this 안써도 실행가능
		//return this.r*this.r*3.14;
	}
	
	public void result(double a) {// result(double a, Circle this)
		System.out.println("반지름 :" + r);	//  = ("반지름 :" + this.r);
		System.out.println("넓이 : " + a);
	}
}


public class Test1 {

	public static void main(String[] args) {
		
		Circle ob = new Circle();	//ob 는 circle의 다른이름
		//ob.r은 캡슐화되어있어 외부에서 접근 못함.
		
		ob.setData(10);	// = setData(10,ob); -> 내부적으로 ob클래스의 주소를 가져감
		double a = ob.area();//ob.area(ob) -> 매개변수가 없으므로 ob클래스 주소만 가져감
		ob.result(a);// result(a, ob)
		
		ob.setData(100);
		a = ob.area();
		ob.result(a);
	}
}