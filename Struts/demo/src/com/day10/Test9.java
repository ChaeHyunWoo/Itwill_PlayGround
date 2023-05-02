package com.day10;
//�ڹٿ����� �߻�Ŭ�������� �������̽��� �� ���� ����Ѵ�.
abstract class SortInt { // �߻�Ŭ����
	
	private int [] value; // �ʱⰪ : null
	
	protected abstract void sorting(); // �߻� �޼ҵ� - �߻�Ŭ���� �ȿ��� �ּ� 1���̻� �߻� �޼ҵ尡 �־�� ��.
	
	
	public void sort(int [] value) { // (�Ϲ�)�޼ҵ�
		
		this.value = value; // value �迭�� value�� �־��
		
		sorting();
		
	}
	
	
	public int length() {	// �޼��� void ��� return �ʿ�
		
		if(value==null) {
			return 0;
		}
		
		return value.length;
	}
	
	
	protected final int compare(int i, int j) {
		//if(value[i] > value[j])
		if(value[i] == value[j])
			return 0;
		else if(value[i] > value[j])
			return 1;
		else
			return -1;
	}
	
	protected final void swap(int i, int j) {
		int temp;
		temp = value[i];
		value[i] = value[j];
		value[j] = temp;
	}
	
	public void print() {
		
		if(value==null) // ���� value�� �ؽ��ڵ尡 �ִٸ� �ּҸ� ã�ư���
			return;
		
		for(int su : value) {
			System.out.printf("%4d", su); //�����͸� ���
		}
		System.out.println();
	}
}

class SortTest extends SortInt {

	@Override
	protected void sorting() {
		
		//Selection Sort
		for(int i=0; i<length()-1; i++) {
			for(int j=i+1; j<length(); j++) {
				
				if(compare(i, j)>0) {
					swap(i, j);
				}
			}
		}
	}
}


public class Test9 {

	public static void main(String[] args) {
		
		int [] value = {50, 34, 56, 89, 23};
		
		SortTest ob = new SortTest();
		ob.sort(value);
		ob.print();	
	}
}