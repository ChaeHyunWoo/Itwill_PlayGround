package practice.num1;
//Ŭ������ ��ü - �⺻
//��ü : �޸𸮿� ��������� ���� Ȥ�� ��ü / ������ ������ ���� �ִ�.

//1. ��ü ����, �ɹ� ���� ����ϱ�
public class Student {
	//�Ӽ�(�ʵ�)
	//�������
	String name; //Ŭ�������� ������ ��� ������ default = null
	int age; // Ŭ������ ������ ��� ������ default = 0;

	public static void main(String[] args) {
		// ��ü ����
		Student s;
		//��ü ����
		s = new Student(); // 'new' ��ü�� �����ϴ� Ű����
		
		//��ü�� �ʵ��� �⺻���� ��� - ������� �� ���� ������.
		System.out.println(s.name + "," + s.age); //null
		System.out.println("--------");
		
		
		//��ü�� �ʵ忡 ������ ����
		s.name = "��ڻ�";
		s.age = 25;
		
		//��ü�� �ʵ忡 ����� ������ �б�
		System.out.println(s.name + "," + s.age);
		}

}
