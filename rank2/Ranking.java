package rank2;

import java.util.Scanner;

class Start {
	
	private String name;
	private int kor, eng, mat;
	
	//�Էºκ�
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸� ���� ���� ���� : ");
		name=sc.next();
		kor=sc.nextInt();
		eng=sc.nextInt();
		mat=sc.nextInt();
		
	}
	
	//ó�� �κ�
	public String result(int jum) {
		
		String list = "";
		
		switch(jum) {
		case(100) : case(90) :
			list = "��";
			break;
		case(80) :
			list = "��";
			break;
		case(70) :
			list = "��";
			break;
		case(60) :
			list = "��";
			break;
		default :
			list = "��";
			break;
		}
		
		return list;
	}
	
	//��� �κ�
	public void print() {
		
		System.out.printf("%5s %4d(%s), %4d(%s), %4d(%s)\n", name, kor, result(kor), eng, result(eng), mat, result(mat));
	
	}
}




public class Ranking {

	public static void main(String[] args) {

		Start st = new Start();
		
		st.input();
		st.print();
		
	}

}
