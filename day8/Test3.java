package com.day8;


// 자바는 단일상속만 가능하다. c언어는 다중상속가능 
//상속(부모가 자식한테 주는 것)

//조건
//1. 부모꺼는 내꺼다.				(할아버지꺼도 내꺼다) 메소드 가져와서 이용가능
//2. 부모가 private로 선언한 것은 상속이 불가능하다.
//3. 부모가 protected로 선언한 것은 상속 가능
//4. 내껀 내꺼다.					(자식꺼는 자식꺼다 / 부모가 자식거를 못씀)
//5. 부모와 자식이 같은 객체를 가지고 있으면 무조건 자식(내꺼)를 쓴다.

//1
class TestB {	//TestB를 부모로 만들고 RectB를 자식으로 만듬
	
	private String title;
	protected int area;	//3. 부모가 protected로 선언한 것은 상속 가능 @중요@ Test2에서는 pivate로 하는 방법
	
	public void set(String title) { // 메소드로 우회도로 만듬
		this.title = title;	//초기화
	
		
	}
	
	public void print() {
		
		System.out.println(title +":" + area);
	}
}

//2
class RectB extends TestB {	//TestA를 부모로 만들고 Rect를 자식으로 만듬
	
	private int w,h; //변수를 초기화하기위해서 우회도로 만들어야함/생성자로 우회도로	(2) w,h에 들어가고
	
	public RectB(int w, int h) { //오버로딩으로 된 생성자로 우회도로 만듬(생성자로 초기화)	(1) 10,20이 들어가서
		this.w = w;
		this.h = h;
	}
	
	public void rectArea() {
		area = w*h;	// (3) 여기서 계산해서 200이되고
		set("사각형");	//1. 부모는 내꺼다
		
	}
}


//3
public class Test3 {

	public static void main(String[] args) {
		
		RectB ob = new RectB(10, 20);
		
		ob.rectArea();
		ob.print();//1. 부모꺼는 내꺼다
	}

}
