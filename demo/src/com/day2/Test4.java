package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {

	public static void main(String[] args) throws IOException {
		
		//=���, �ݺ���
		//���ǹ�(���) : for��, switch��
		//�ݺ��� : while��, for��, do-while��, 
	
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		int num;
		String str = "";
		
		System.out.println("���� �Է� : ");
		num = Integer.parseInt(br.readLine()); //����ó���ؾ��ϰ� ��ȯ�ϴ°��� ���ڶ� int�� ����ȯ
		
		/*//if�� ����(���� if��)
		if(num%2 == 0) {
			str = "¦��";
		}
		if(num%2 != 0) {  // != 0 �̶�ᵵ�ǰ� == 1�̶� �ᵵ�� 
			str = "Ȧ��";
		} */
		
		if(num %2 == 0) {
			str = "¦��";
		} else {
			str = "Ȧ��";
		}
		
		System.out.println(num + ":" + str); //Initialize variable ������ �ʱ�ȭ �϶�� ����
		
	}

}
