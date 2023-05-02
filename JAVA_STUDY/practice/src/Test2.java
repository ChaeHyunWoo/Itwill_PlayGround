package practice;
//추상 클래스 예제

abstract class ShapeClass { // 추상클래스도 부모클래스의 역할을 함
	
	abstract void draw(); // 틀을 만들어 놨으니 가져다가 재정의(Override)해서 사용해라. Interface(인터페이스)와 같음
						  // 무조건 return값은 void, 메서드명은 draw
	
}

class Circle1 extends ShapeClass {

	@Override
	void draw() {
		System.out.println("원을 그린다..");
		
	}
	
	
}

class Rect extends ShapeClass { // 추상 클래스의 메서드 중 unimplement method 존재 시 오류

	@Override
	void draw() {
		System.out.println("사각형을 그린다..");
		
	}
	
}

class Tri extends ShapeClass {

	@Override
	void draw() {
		System.out.println("삼각형을 그린다..");
	}
	
}


public class Test2 {

	public static void main(String[] args) {
		
		Circle1 ob1 = new Circle1();
		Rect ob2 = new Rect();
		Tri ob3 = new Tri();
		
		ob1.draw();
		ob2.draw();
		ob3.draw();

	}

}