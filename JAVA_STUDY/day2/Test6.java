package com.day2;

import java.util.*;

//Scanner�� �ܶ� ���ڸ� �����ؼ� �����͸� �Է¹��� �� ����.
//�⺻ �ܶ��� �����̴�.
public class Test6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String name;
		int kor, eng, mat;

		// System.out.println("�̸� ���� ���� ����? ");// suzi 40 50 70
		System.out.println("�̸�,����,����,����? ");// suzi 40 50 70

		sc = new Scanner(sc.next()).useDelimiter("\\s*,\\s*");// ����ȭ ǥ����

		name = sc.next(); // �̸�
		kor = sc.nextInt(); // ����
		eng = sc.nextInt(); // ����
		mat = sc.nextInt(); // ����

		System.out.println(name + ":" + (kor + eng + mat) + "��");

		sc.close(); // �� ����ϴ°� �ƴ�.
	}

}
