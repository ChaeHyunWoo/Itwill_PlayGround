package com.day14;

import java.util.Scanner;

/* ���� ó��( try - catch ��)
Exception
*/
public class Test2 {

	public static void main(String[] args) {
		
		int num1, num2, result;
		String oper;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.print("�� ���� �� : ");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			
			System.out.print("������ : ");
			oper = sc.next();
			
			result = 0; // result���� 0���� �ʱ�ȭ
			
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
			 //try���� ������ �߻��ϸ� catch���� ������ ��Ƴ��� Exception�� ����ó���� �����  �Ű����� e���� ��ȯ����
			
		} catch (NumberFormatException e) {		// ������ catch�� Exception�� ������ ����(s)�� ó���Ѵ�.
			System.out.println("������ �Է��ض�");
			
		} catch (ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�.");
			
		} catch (Exception e) {  //Exception�� ���� ���� ���� �Ʒ��͵� �� ����ó���� �ϱ⶧���� ������ ����.
								 //������ catch�� Exception�� ������ ����(s)�� ó���Ѵ�
			System.out.println("�� �װ� ���ڷ� ���̳�~~?");
			System.out.println(e.toString());//Exception e �� String���� ������ش�.
			e.printStackTrace();
			
		} finally {//������ �����ϱ⶧���� ������ ��������
			System.out.println("�������� ����ȴ�.");
		}
		
		System.out.println("catch�� ��....");
		
		
	}
}