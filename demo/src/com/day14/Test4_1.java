package com.day14;
// Test4�� boolean���� �� Ǯ��		
import java.util.Scanner;


//����
class MyAuthExcep1 {
	
	public void inputFormat(String str) throws Exception {
		
		//���� ���� - ���̰� 5���� �۰ų� 10���� ũ�� �ȵȴ�.
		if(str.length() < 5 || str.length() > 10) {
			throw new Exception("���ڿ��� ���̴� 5~10�� �Դϴ�!!");
		}
		
		 
		boolean eng = false;
		boolean num = false;
		//boolean eng, num;
		//eng = num = false;  -> ���� ���� ����̴�. �ʱ�ȭ �� ������ ���� ���� �̷��� �ϱ�!
		
		for(int i=0; i<str.length(); i++) {
			
			char ch = str.charAt(i);
			
			if((ch>='A' && ch<='Z') || (ch>='a' && ch<'z')) {
				eng = true;
			} else if(ch>='0' && ch<='9') {
				num = true;
			}
		}	
		
		if(eng ==false || num == false)
			throw new Exception("������, ����ȥ�븸 �����մϴ�.");
	}
	
}


public class Test4_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str;
		
		//���� Ŭ������ ����ϱ����� ��ü ����
		MyAuthExcep1 auth = new MyAuthExcep1();
		
		try {
			System.out.print("���ڿ� : ");
			str = sc.next();
			
			//�����ϱ����� inputFormat���� ����
			auth.inputFormat(str); 
			
			System.out.println(str);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

}
