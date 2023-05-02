package practice.num1;
//클래스와 객체 - 기본
//객체 : 메모리에 만들어지는 물건 혹은 물체 / 묶음의 성격을 갖고 있다.

//1. 객체 생성, 맴버 변수 출력하기
public class Student {
	//속성(필드)
	//멤버변수
	String name; //클래스에서 선언한 멤버 변수는 default = null
	int age; // 클래스에 선언한 멤버 변수는 default = 0;

	public static void main(String[] args) {
		// 객체 선언
		Student s;
		//객체 생성
		s = new Student(); // 'new' 객체를 생성하는 키워드
		
		//객체의 필드의 기본값이 출력 - 멤버변수 값 지정 안했음.
		System.out.println(s.name + "," + s.age); //null
		System.out.println("--------");
		
		
		//객체의 필드에 데이터 자장
		s.name = "김박사";
		s.age = 25;
		
		//객체의 필드에 저장된 데이터 읽기
		System.out.println(s.name + "," + s.age);
		}

}
