package com.day6;

import java.util.Scanner;

class Hap {
	
	int su, sum; //instance����(��������) �ν��Ͻ������� �ڵ����� �ʱ�ȭ�� ����
	
	
	public void input() {// method(�޼ҵ�) - �Է� ����
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� :");
		su = sc.nextInt();
	}
	
	public int cnt() {
		
		for(int i=1; i<=su; i++) {
			sum += i; // sum = sum+i
		}
		return sum; // sum���� ��ȯ����
	}
	
	public void print(int i) {	// ��� ����
		
		System.out.println("�հ�: " + i);
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		
		Hap h = new Hap(); //��ü ����         Ŭ������ ���� �����ϴ¿����� �ϱ⿡ �ڷ����̴�.
		
		h.input(); // input Ŭ���� ȣ��
		int sum = h.cnt(); // cntŬ���� ȣ��	cntŬ������ int��
		h.print(sum); // print Ŭ���� ȣ��
		
	}

}
