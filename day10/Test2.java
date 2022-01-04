package com.day10;

import java.util.Calendar;

public class Test2 {

	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		
		int y = now.get(Calendar.YEAR); //��
		int m = now.get(Calendar.MONTH) + 1; // ��(0~11) + 1
		int d = now.get(Calendar.DATE); // ��
		int w = now.get(Calendar.DAY_OF_WEEK); // ���� ��(1~7) 1:������ ~ 7:�Ͽ���
		
		String[] week = { "�Ͽ���", "������", "ȭ����", "������", "�����", "�ݿ���", "�����" };
		System.out.println(y + "-" + m + "-" + d + "-" + week[w-1]);
		
		//���� �������� ���ϱ�
		int startDay = now.getActualMinimum(Calendar.DATE);
		int lastDay = now.getActualMaximum(Calendar.DATE);
		
		System.out.println(startDay + "�� ��������:" + lastDay + "��");
		
		System.out.printf("%tF\n", now); // 2022-01-04 -> ���� ��-��-�� ���
		System.out.printf("%tT\n", now); // 11:48:38   -> ���� �ð� ���
		System.out.printf("%1$tF  %1$tT\n", now); // ���� 2���� 1���� ��ħ. 1$�� ��ģ��.
		
		// ��(0~11)  Calendar�� ���� ���� -1���ְ� ���� ���� +1 �������
		now.set(2021,10-1,10);
		
		y = now.get(Calendar.YEAR); //��
		m = now.get(Calendar.MONTH) + 1; // ��(0~11) + 1
		d = now.get(Calendar.DATE); // ��
		w = now.get(Calendar.DAY_OF_WEEK); // ���� ��(1~7) 1:������ ~ 7:�Ͽ���
		
		System.out.println(y + "-" + m + "-" + d + "-" + week[w-1]);
		
		
	}

}