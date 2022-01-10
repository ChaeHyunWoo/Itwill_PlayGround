package practice;
//�߻� Ŭ���� ����

abstract class ShapeClass { // �߻�Ŭ������ �θ�Ŭ������ ������ ��
	
	abstract void draw(); // Ʋ�� ����� ������ �����ٰ� ������(Override)�ؼ� ����ض�. Interface(�������̽�)�� ����
						  // ������ return���� void, �޼������ draw
	
}

class Circle1 extends ShapeClass {

	@Override
	void draw() {
		System.out.println("���� �׸���..");
		
	}
	
	
}

class Rect extends ShapeClass { // �߻� Ŭ������ �޼��� �� unimplement method ���� �� ����

	@Override
	void draw() {
		System.out.println("�簢���� �׸���..");
		
	}
	
}

class Tri extends ShapeClass {

	@Override
	void draw() {
		System.out.println("�ﰢ���� �׸���..");
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