package com.day3;

import java.io.IOException;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) throws IOException {
		
		//�Է��� �������� �հ踦 ���ϱ�
		
		Scanner sc = new Scanner(System.in);
		
		int su, sum = 0;
		char ch;
		
		while(true) { //���ѷ���
			
			do {
				System.out.print("���ϴ� �� : ");//100
				su = sc.nextInt();
			} while(su<1 || su>5000); //���ϴ¼��� �Է��ϵ� while�� ������ �Ǵ�
			//������ �ݴ�� ����� while�� �������´�.
			
			sum = 0; //�ѹ� ������ �ϸ� sum���� �ʱ�ȭ ���ش�. �ʱ�ȭ�� ���ϸ� ���� �����ȴ�!
			for(int i=1; i<=su; i++) {
				
				sum += i; //sum = sum + i;(sum�� �� ����)
			}
			
			System.out.println("1~" + su + "������ �� : " + sum);
			
			System.out.print("����ҷ�? [Y/N]");// Y,y,N,n
			ch = (char)System.in.read();
			
			if(ch != 'Y' && ch !='y') { //Tip ������ ����(!=)�� ������ �߰��� ||(or)���� �ȵǰ� &&(and)�� �����.!!!
				System.out.println("���α׷� ����");
				break; //break�� if��, while��, do-while��, for��, switch�� � �� ��� �����ϴ�.
			}
		}
	}
}