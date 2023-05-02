package com.day12;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Test7 {
	
	private static final String[] city = {"����", "�λ�", "�뱸", "��õ", "����", "����", "���"};

	
	public static void main(String[] args) {
		
		//Generic
		Vector<String> v = new Vector<>(); //Vector�� �����ϸ� ���������� �迭�� �ڵ����� ���������� ���� 10��
		
		String str;
		System.out.println("������ �ʱ� �뷮 : " + v.capacity()); // ������ �ʱ� �뷮 : 10
		
		for(String s : city) {
			v.add(s);
		}
		
		Iterator<String> it = v.iterator();
		while(it.hasNext()) { //�����Ͱ� ���� ������ ������
			
			str = it.next();
			System.out.print(str + " ");//���� �λ� �뱸 ��õ ���� ���� ��� 
		}
		System.out.println();
		
		System.out.println("�������� ���� : " + v.size()); // �������� ���� : 7
		
		//����
		v.set(0, "Seoul"); // 0��° �ڸ��� "����"�� �־��
		v.set(1, "Busan");
		
		for(String s : v) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		//����
		v.insertElementAt("���ѹα�", 0); // "���ѹα�"�� ���� ���̰� 0��° index�� �ִ´�.
		for(String s : v) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println("������ ���� �뷮 : " + v.capacity()); // ������ ���� �뷮 : 10
		System.out.println("�������� ���� : " + v.size()); // �������� ���� : 8 
		
		//�˻�
		int index = v.indexOf("�뱸"); // �뱸�� �ִ� ���� index�� ������ �Ͷ�
		if(index != -1) { // -1�� �����Ͱ� ���� ��� -> != ���� �ϸ�  �����Ͱ� ������
			System.out.println("�˻� ����!!" + index); // �˻� ����!!3
		} else {
			System.out.println("�˻� ����!!" + index); // �˻� ����!!-1
		}
		
		
		//��������
		Collections.sort(v);
		for(String s : v) {
			System.out.print(s + " "); //Busan Seoul ���� �뱸 ���� ���ѹα� ��� ��õ -> �����ټ����� ����
		}
		System.out.println();
		
		//��������
		Collections.sort(v, Collections.reverseOrder()); 
		for(String s : v) {
			System.out.print(s + " "); // ��õ ��� ���ѹα� ���� �뱸 ���� Seoul Busan 
		}
		System.out.println();
		
		//����
		v.remove(7); // ������ index��ȣ( ) // v.remove("Busan");
		for(String s : v) {
			System.out.print(s + " "); // ��õ ��� ���ѹα� ���� �뱸 ���� Seoul  -> Busan ������.
		}
		System.out.println();
		
		//�뷮 ����
		for(int i=1; i<=20; i++) {
			v.add(Integer.toString(i));
		}
		for(String s : v) {
			System.out.print(s + " "); // ��õ ��� ���ѹα� ���� �뱸 ���� Seoul 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 
		}
		System.out.println();
		System.out.println("������ ���� �뷮 : " + v.capacity()); // ������ ���� �뷮 : 40
		System.out.println("�������� ���� : " + v.size()); // �������� ���� : 27
		
		
		//���� (tip - ���ʹ� �뷮�� �˾Ƽ� �þ���� �ڵ����� �پ������ ����.����ڰ� �������� �ٿ�����)
		for(int i=1; i<=10; i++) {
			v.remove(5); // 5��° index ���ֺ��� �����ؼ� 10���� �����͸� ����
		}
		for(String s : v) {
			System.out.print(s + " "); // ��õ ��� ���ѹα� ���� �뱸 9 10 11 12 13 14 15 16 17 18 19 20 
		}
		System.out.println();
		System.out.println("������ ���� �뷮 : " + v.capacity()); //������ ���� �뷮 : 40
		System.out.println("�������� ���� : " + v.size()); //�������� ���� : 17
		
		
		//�̻�� ���� ����(����ڰ� �������� �����ؾ���) - �������� ������ ����� ���� �����(�̻�����) ����
		v.trimToSize();
		System.out.println();
		System.out.println("������ ���� �뷮 : " + v.capacity()); //������ ���� �뷮 : 17
		System.out.println("�������� ���� : " + v.size()); //�������� ���� : 17
		
		
		//��� ������ ����
		v.clear();
		System.out.println("������ ���� �뷮 : " + v.capacity()); //������ ���� �뷮 : 17
		System.out.println("�������� ���� : " + v.size()); //�������� ���� : 0
	}
	

}