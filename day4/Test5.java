package com.day4;

import java.util.Random;

public class Test5 {

	public static void main(String[] args) {
		
		//1~45������ �� �߿��� 6���� ������ �߻����� ũ������� ���� (�ζ�)
		
		Random rd = new Random();
		int [] num = new int[6];
		int i, j, n, temp;
		
		n = 0;
		//Math.random();
		//��� �����ؾ����� �𸣴� while�� ���'
	
		while(n<6) {	// 6���� �������� ����
			num[n] = rd.nextInt(45)+1;	//(45)������ 0���� 44�̴�. (45)+1�� �ϸ� 1~45 ������ ���´�
										//@@ �ſ� �߿� @@//
			for(i=0; i<n; i++) {		//�� while�� ��������ϸ� �ߺ����� ���� �ȳ��´�.
				if(num[i] == num[n]) {	// �ߺ����� ������ n-- ���ҽ��� �迭 �� ĭ���� ���� �ٽ� �������ڸ� �̴´�.
					n--;				// ���� �����ڸ� �ߺ����ڰ� �ȳ����� �������� 6���� �� �̾��ְ�, ���࿡
					break;				// �ߺ����� ������ �ٽ� ����ĭ���� ���ư��µ� break�� ������ ���� ����  
				}						// ������ �ʰ� �ٽ� �������ڸ� ä���.
			}
			n++;
		}
		
		// ����	�����̱��ؼ� ���ľ��Ϸ��� �� �κ��� �ּ�ó��
		for(i=0; i<num.length-1; i++) {
			for(j=i+1; j<num.length; j++) {
				
				if(num[i]>num[j]) {
					
					temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}		//�������
		
		//for(int i=0; i<num.length; i++) �Ʒ��� for���� ���� for���� ����.
		for(int su : num) {	//Ȯ�� for�� -> �迭������ ��� �����ϴ�.
			System.out.printf("%4d", su);
		}
	}
}
