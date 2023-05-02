package com.day11;

interface Test {
	
	public int total();
	public void write();
	
}

class TestImpl implements Test { //인터페이스
	
	private String hak, name;
	private int kor, eng;
	
	public TestImpl() { // 기본 생성자 - 기본생성자는 코딩이 없다.
		//기본생성자를 만들어서 메소드를 만들어서 초기화 하는 방법
	}
	
	public TestImpl(String hak, String name, int kor, int eng) { // 오버로딩된 생성자
		//오버로딩된 생성자를 만들어서 만들자마자 초기화
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		
	}
	
	public void set(String hak, String name, int kor, int eng) {
		//기본생성자를 만들어서 메소드를 만들어서 초기화 하는 방법
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
 
	@Override
	public int total() {
		return kor + eng;
	}

	@Override
	public void write() {
		
		System.out.println(hak + "," + name + "," + total());
	}
	
	@Override // 메서드 이름을 써서 여기는 override를 굳이 안써도 된다.
	public boolean equals(Object ob) {	// ob1.equals(ob2), TestImpl // Object의 equals를 override한다. 이래서 
						//Object ob = ob2 -> upcast (upcast 주변에는 Object가 있다.)
		boolean flag = false;
		
		if(ob instanceof TestImpl) { //instanceof연산자
			
			TestImpl t = (TestImpl)ob; // downcast
			
			// - Upcast : 상속관계에서 자식클래스의 객체를 부모클래스로 형변환

			// - Downcast : 상속관계에서 부모클래스의 객체를 자식클래스로 형변환
			
			if(this.hak.equals(t.hak) && t.name.equals(this.name)) {
				flag = true;			
			}
		}
		
		return flag;
	}
	
	
}
public class Test4 {

	public static void main(String[] args) {
		
		// TestImpl 대신 Test를 써도된다. why? 부모관계 or 인터페이스 관계이기 때문
		// TestImpl ob1 = new TestImpl("111", "배수지", 80, 90);
		Test ob1 = new TestImpl("111", "배수지", 80, 90);
		TestImpl ob2 = new TestImpl("111", "배수지", 100, 100);
		
		if(ob1.equals(ob2)) {
			System.out.println("ob1과 ob2는 동일인물!");
		} else {
			System.out.println("ob1과 ob2는 동일인물 x ");
		}
		
		ob1.write();
		ob2.write();
	}

}
