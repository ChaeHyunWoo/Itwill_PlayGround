//6. �̸��� 3������ ������ �Է� �޾� �������ǿ� ���� ���
//	-��� ������ ������ 40�� �̻��̰� ����� 60�� �̻��̸� �հ�
//	-�Ѱ����̶� 40�� �̸��̰� ����� 60�� �̻��̸� ����(���հ�)
//	-����� 60�� �̸��̸� ���հ�

//   �̸� ? ȫ�浿
//   ������ ���� ? 60 70 80
//   �̸� : ȫ�浿
//   ���� : 210, ��� : 70, ���� :�հ�
package com.day2;
import java.util.*;

public class Number6 {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		String name;
		int kor,eng,mat,tot,avg;
		String pan;

		System.out.print("�̸� ? ");
		name=sc.next();
		System.out.print("������ ���� ?");
		kor=sc.nextInt();
		eng=sc.nextInt();
		mat=sc.nextInt();

		tot=kor+eng+mat;
		avg=tot/3;

		if(kor>=40&&eng>=40&&mat>=40&&avg>=60)
			pan="�հ�";
			else if(avg>=60)
				pan="����";
					else
					pan="���հ�";

		System.out.println("�̸� : " + name);
		System.out.println("���� : " + tot + " ��� : " + avg + " ���� : " + pan);
		}
	}