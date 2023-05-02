package com.day8;



//상속(부모가 자식한테 주는 것)

//조건
//1. 부모꺼는 내꺼다.
//2. 부모가 private로 선언한 것은 상속이 불가능하다.
//3. 부모가 protected로 선언한 것은 상속 가능
//4. 내껀 내꺼다.(자식꺼는 자식꺼다 / 부모가 자식거를 못씀)
//5. 부모와 자식이 같은 객체를 가지고 있으면 무조건 자식(내꺼)를 쓴다.

//1
class TestA {	//TestA를 부모로 만들고 Rect를 자식으로 만듬
	
	private String title;
	private int area;	//private로 변수를 만들면 우회도로를 만들어야함/이럴때 변수의 혼동을 막기 위해 this를 사용함.
	
	public void set(String title, int area) { // 메소드로 우회도로 만듬
		this.title = title;	//초기화
		this.area = area;	//초기화
		
	}
	
	public void print() {
		
		System.out.println(title +":" + area);
	}
}

//2
class Rect extends TestA {	//TestA를 부모로 만들고 Rect를 자식으로 만듬
	
	private int w,h; //변수를 초기화하기위해서 우회도로 만들어야함/생성자로 우회도로	(2) w,h에 들어가고
	
	public Rect(int w, int h) { //오버로딩으로 된 생성자로 우회도로 만듬(생성자로 초기화)	(1) 10,20이 들어가서
		this.w = w;
		this.h = h;
	}
	
	public void rectArea() {
		int a = w*h;	// (3) 여기서 계산해서 200이되고
		set("사각형", a);	//1. 부모는 내꺼다
		
	}
}


//3
public class Test2 {

	public static void main(String[] args) {
		
		Rect ob = new Rect(10, 20);
		
		ob.rectArea();
		ob.print();//1. 부모꺼는 내꺼다
	}

}
