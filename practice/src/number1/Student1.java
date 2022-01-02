package number1;

public class Student1 {
	
	//속성(필드)
	//멤버변수
	String name;
	int age;
	String hobby;

	public static void main(String[] args) {
		
		//객체 선언 및 생성
		Student1 st = new Student1();
		
		st.name = "김박사";
		st.age = 25;
		st.hobby = "게임";
		
		System.out.println(st.name + "/" + st.age + "/" + st.hobby);
		
		System.out.println("---------------");
		Student1 st1 = new Student1();
		st1.name = "박조교";
		st1.age = 23;
		st1.hobby = "축구";
		
		System.out.println(st1.name + "/" + st1.age + "/" + st1.hobby);
	}

}
