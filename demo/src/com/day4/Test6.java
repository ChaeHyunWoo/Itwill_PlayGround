package com.day4;

import com.day5.Rect;

public class Test6 {

	public static void main(String[] args) {
		
		Rect usa = new Rect();	// ��Ű���� �޶� import ���Ѿ���
		
		usa.input();
		int aa = usa.area();
		int ll = usa.length();
		usa.print(aa, ll);
		
		//��������: �ʱⰪ = 0
		//�������� �ʱⰪ = �����Ⱚ ������ �ִ�.
	}
}