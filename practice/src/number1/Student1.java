package number1;

public class Student1 {
	
	//�Ӽ�(�ʵ�)
	//�������
	String name;
	int age;
	String hobby;

	public static void main(String[] args) {
		
		//��ü ���� �� ����
		Student1 st = new Student1();
		
		st.name = "��ڻ�";
		st.age = 25;
		st.hobby = "����";
		
		System.out.println(st.name + "/" + st.age + "/" + st.hobby);
		
		System.out.println("---------------");
		Student1 st1 = new Student1();
		st1.name = "������";
		st1.age = 23;
		st1.hobby = "�౸";
		
		System.out.println(st1.name + "/" + st1.age + "/" + st1.hobby);
	}

}
