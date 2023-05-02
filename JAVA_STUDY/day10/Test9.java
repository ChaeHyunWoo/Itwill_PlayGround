package com.day10;
//자바에서는 추상클래스보단 인터페이스를 더 많이 사용한다.
abstract class SortInt { // 추상클래스
	
	private int [] value; // 초기값 : null
	
	protected abstract void sorting(); // 추상 메소드 - 추상클래스 안에는 최소 1개이상 추상 메소드가 있어야 함.
	
	
	public void sort(int [] value) { // (일반)메소드
		
		this.value = value; // value 배열에 value를 넣어라
		
		sorting();
		
	}
	
	
	public int length() {	// 메서드 void 없어서 return 필요
		
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
		
		if(value==null) // 만약 value에 해쉬코드가 있다면 주소를 찾아가서
			return;
		
		for(int su : value) {
			System.out.printf("%4d", su); //데이터를 출력
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