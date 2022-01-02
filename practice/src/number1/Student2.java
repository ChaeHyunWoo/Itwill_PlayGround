package number1;

public class Student2 {
	
	//속성(필드)
	//멤버변수
	String name;
	int korean, english, math, sum;
	double avg;

	public static void main(String[] args) {
		
		//객체 선언 및 생성
		// new = 객체를 생성할 때 사용하는 연산자
		Student2 st = new Student2();
		
		//객체의 필드에 데이터 저장
		//. = 상위요소에서 하위요소로 접근할 때 사용하는 연산자
		st.name = "김은수";
		st.korean = 95;
		st.english = 60;
		st.math = 100;
		st.sum = st.english + st.korean + st.math;
		st.avg = st.sum / 3.0;
		
		
		//객체의 필드에 저장된 데이터 읽기
		System.out.println("이름 : " + st.name);
		System.out.println("국어 : " + st.korean);
		System.out.println("영어 : " + st.english);
		System.out.println("수학 : " + st.math);
		System.out.println("총점 : " + st.sum + "점");
		System.out.printf("평균 : %.2f\n", st.avg);
	}

}
