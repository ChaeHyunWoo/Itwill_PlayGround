package rank;
//������ �ҽ� �ڵ�
import java.util.Scanner;
class Jumsu{

	//����
	private String name;
	private int kor,eng,mat;


	// �Է�
	public void Input(){
		Scanner sc = new Scanner(System.in);

		System.out.print("�̸� ���� ���� ���� ?");
		name=sc.next();
		kor=sc.nextInt();
		eng=sc.nextInt();
		mat=sc.nextInt();

	}

	//ó��
	public String result(int jum){

		String pan="";			

		switch(jum/10){
			case(10):
			case(9):pan = "��"; break;
			case(8):pan = "��"; break;
			case(7):pan = "��"; break;
			case(6):pan = "��"; break;
			default: pan = "��"; break;
		}
		return pan;
	}


	//���
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

