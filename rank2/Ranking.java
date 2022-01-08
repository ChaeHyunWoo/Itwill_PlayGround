package rank2;

import java.util.Scanner;

class Start {
	
	private String name;
	private int kor, eng, mat;
	
	//입력부분
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 국어 영어 수학 : ");
		name=sc.next();
		kor=sc.nextInt();
		eng=sc.nextInt();
		mat=sc.nextInt();
		
	}
	
	//처리 부분
	public String result(int jum) {
		
		String list = "";
		
		switch(jum) {
		case(100) : case(90) :
			list = "수";
			break;
		case(80) :
			list = "우";
			break;
		case(70) :
			list = "미";
			break;
		case(60) :
			list = "양";
			break;
		default :
			list = "가";
			break;
		}
		
		return list;
	}
	
	//출력 부분
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
