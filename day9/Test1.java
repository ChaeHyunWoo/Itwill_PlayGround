package com.day9;

//부모
class Test {
	// 기본생성자로 객체 만들어보고 오버로딩된 생서자로도 객체 만들어보기
	private String title;
	protected double area;
	
	//기본 생성자
	public Test() {} //기본 생성자 꺼내놓음 why? 오버로딩된 생성자 만들려고
	
	//오버로딩된 생성자
	public Test(String title) {
		this.title = title;
	}
	
	public void write() {
		System.out.println(title + ":" + area);
	}
}
//자식
class Circle extends Test {
	
	private int r;
	protected static final double PI = 3.14;// static 알아서 메모리에 올라감
	//오버로딩된 생성자
	public Circle(int r) {//new Circle(10)때문에 r에 10이 들어가고
		super("원"); //원이 위에 title로 들어감
		this.r = r;
	}
	
	public void circleArea() {
		area = (double)r * r * PI; //구분하기 편하게 double써도된다. 지워도 오류 안뜸.
	}
}

class Rect extends Test {
	
	private int w, h;
	
	public void rectArea(int w, int h) {//메소드로 초기화 / 여긴 메소드 Rect의 메소드이다
		this.w = w;
		this.h = h;
		
		area = w * h;
	}

	
	//Override
	//상속관계에서 같은 역할을 하는 메소드의 이름을 통일시키는 작업
	//부모의 클래스를 재정의(다형성)해서 사용
	//조건 : 메소드의 이름이 부모 메소드와 정확히 같아야 한다.
	//메소드는 하늘이 두쪽나도 무조건 자신 것을 사용함
	//부모의 내용이 맘에 안들어서 자식이 마음대로 내용을 변형!
	
	@Override //어노테이션
	public void write() {
		System.out.println("가로 : " + w + " 세로 : " + h);
		System.out.println("넓이 : " + area);
		//super.write();
	}
	
}

public class Test1 {

	public static void main(String[] args) {
		
		Circle ob1 = new Circle(10);
		ob1.circleArea();
		ob1.write();//부모의 메소드를 사용한다
		
		Rect ob2 = new Rect(); //기본 생성자 생성
		ob2.rectArea(10, 20); //매개변수 값 필요
		ob2.write(); //5. 부모도 가지고있고, 나도 갖고 있으면 내껄 쓴다.무조건!!!
	}

}
