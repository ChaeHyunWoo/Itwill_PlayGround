package number1;

public class Student2 {
	
	//�Ӽ�(�ʵ�)
	//�������
	String name;
	int korean, english, math, sum;
	double avg;

	public static void main(String[] args) {
		
		//��ü ���� �� ����
		// new = ��ü�� ������ �� ����ϴ� ������
		Student2 st = new Student2();
		
		//��ü�� �ʵ忡 ������ ����
		//. = ������ҿ��� ������ҷ� ������ �� ����ϴ� ������
		st.name = "������";
		st.korean = 95;
		st.english = 60;
		st.math = 100;
		st.sum = st.english + st.korean + st.math;
		st.avg = st.sum / 3.0;
		
		
		//��ü�� �ʵ忡 ����� ������ �б�
		System.out.println("�̸� : " + st.name);
		System.out.println("���� : " + st.korean);
		System.out.println("���� : " + st.english);
		System.out.println("���� : " + st.math);
		System.out.println("���� : " + st.sum + "��");
		System.out.printf("��� : %.2f\n", st.avg);
	}

}
