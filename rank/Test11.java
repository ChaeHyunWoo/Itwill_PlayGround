package rank;
//선생님 소스 코드
import java.util.Scanner;
class Jumsu{

	//변수
	private String name;
	private int kor,eng,mat;


	// 입력
	public void Input(){
		Scanner sc = new Scanner(System.in);

		System.out.print("이름 국어 영어 수학 ?");
		name=sc.next();
		kor=sc.nextInt();
		eng=sc.nextInt();
		mat=sc.nextInt();

	}

	//처리
	public String result(int jum){

		String pan="";			

		switch(jum/10){
			case(10):
			case(9):pan = "수"; break;
			case(8):pan = "우"; break;
			case(7):pan = "미"; break;
			case(6):pan = "양"; break;
			default: pan = "가"; break;
		}
		return pan;
	}


	//출력
	public void print(){

	System.out.printf("%6s %4d(%s),%4d(%s),%4d(%s)\n",
		name,kor,result(kor),eng,result(eng),mat,result(mat)); 
	
	}
}

public class Test11{
	public static void main(String[] args){
		
		Jumsu js = new Jumsu();
		
		js.Input();
		js.print();

	}
}

