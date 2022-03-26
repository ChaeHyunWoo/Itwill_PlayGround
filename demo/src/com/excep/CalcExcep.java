package com.excep;
//Day14�� �ߴ� ����

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CalcExcep {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		double num1, num2, result;
		
		OperationAuthenticator auth = new OperationAuthenticator(); // ��ü �� ��
		
		try {
			
			System.out.print("�� ���� ��[a,b] : ");
			str = br.readLine(); // �Է¹��� ���� �б�
			
			auth.inputFormat(str);// ���ٰ� ���� ������ �ٽ� ���� ������ ������ MYException���� ��
			
			String[] temp = str.split(","); // ,�������� ������ temp�� �ִ´�
			
			auth.number(temp[0]); // number�� 0��°���� �������� �Ǽ����� �������� Ȯ��
			
			//�Է��Ѱ� �����̸�
			num1 = Double.parseDouble(temp[0]);
			
			auth.number(temp[1]); // number�� 1��°���� �������� �Ǽ����� �������� Ȯ��
			num2 = Double.parseDouble(temp[1]);
			
			System.out.print("������ : ");
			str = br.readLine();
			
			//�����ڸ� ������ �Է��� �� ������
			auth.operator(str.charAt(0));// ������ �־ 0��° index 1���� ������
			
			char ch = str.charAt(0);  //str�� 0��° �ڸ� ���� ��������
			
			result = 0;
			
			if(ch == '+')
				result = num1 + num2;
			else if(ch == '-')
				result = num1 - num2;
			else if(ch == '*')
				result = num1 * num2;
			else if(ch == '/')
				result = num1 / num2;
			
			System.out.printf("%g %c %g = %g\n", num1, ch, num2, result);
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
