package com.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ���ܸ� �ǵ������� �߻���Ű�� ���
public class Test3 {
										//2
		public static String getOper() throws Exception {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String oper = null;
			
			try {
				
				System.out.print("������ : ");
				oper = br.readLine(); // ���� �����ߴµ� catch���� exception�� �ذ�����
				
				if(!oper.equals("+") && !oper.equals("-") &&
						!oper.equals("*") && !oper.equals("/")) { // ������ �����̸� &&
					
					//����� ���� ����
					//1
					throw new Exception("������ �Է� ����!!"); // �Ʒ� Exception���� ������
				}
				
				
			} catch (IOException e) {
				System.out.println("�Է� ����!!");
				
			}
			
			return oper; // oper�� ��ȯ
		}
		
		public static void main(String[] args) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int num1, num2, result;
			String oper;
			
			try {
				
				System.out.print("ù��° �� : ");
				num1 = Integer.parseInt(br.readLine());
				System.out.print("�ι�° �� : ");
				num2 = Integer.parseInt(br.readLine());
				
				oper = Test3.getOper();
				
				result = 0;
				
				if(oper.equals("+")) { // oper�� String�̶� equals�� ��
					result = num1 + num2;
				} else if (oper.equals("-")) {
					result = num1 - num2;
				} else if (oper.equals("*")) {
					result = num1 * num2;
				} else if (oper.equals("/")) {
					result = num1 / num2;
				}
				
				System.out.printf("%d %s %d = %d\n", num1, oper, num2, result);
				
			} catch (Exception e) {
				System.out.println(e.toString());
				
			}		
	}
}