//  5.�ܰ� 15,800��¥�� ��ǰ�� ���� ���� �̻� ���Խ� ������ ���ݴϴ�.
//    �������� ������ �����ϴ�.
//    10�� �̻� -> 10%
//    20�� �̻� -> 15%
//    30�� �̻� -> 20%
//    �Ǹűݾ��� ����غ��ϴ�.
//    ��) ���Լ��� 15���� ��� -> ���Լ���: 15��, �Ǹ��ѱݾ�: 213300��
package com.day2;
import java.util.*;
public class Number5 {

	public static void main(String[] args) {
		
		Scanner result = new Scanner(System.in);
		
		float won = 15800;
		int num;
		
		System.out.println("� �����߳���?");
		num = result.nextInt();
		
		if(num>=10) {
			won = won * 0.9f;
		}
		if(num>=20) {
			won = won * 0.85f;
		}
		if(num>=30) {
			won = won * 0.8f;
		}
		System.out.println("���� ���� : " + num + "��" + ", �Ǹ� �� �ݾ� : " + ((int)won*num)+"��");
	}
}