package com.score6;
//���⼭ ������ �߰����������� ��6�� �޼���� �� �ܿ�� ��û �߿���!!!!!
import java.util.Scanner;

//�޴��� �ִ°�
public class ScoreMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Score ob = new Score(); //��ü���� - (���԰���)
		
		int ch;
		
		while(true) {
			
			do {
				System.out.print("1.�߰� 2.���� 3.���� 4.��ü��� 5.�̸��˻� 6.�й��˻� 7.����");
				ch = sc.nextInt();//���� ch�� �����Ŵ�.
				
			} while(ch<1||ch>7);
			
			switch(ch) { //�޴��� ������ Score �� insert�� ����Ǿ��ϴ� ����  Score ��ü�������ֱ�
			
			case 1:
				ob.insert();
				break;
			case 2:
				ob.update();
				break;
			case 3:
				ob.delete();
				break;
			case 4:
				ob.selectAll();
				break;
			case 5:
				ob.searchName();
				break;
			case 6:
				ob.searchHak();
				break;
				
			default:
				System.exit(0);
			
			}
		} //������� while(true)
		

	}
}