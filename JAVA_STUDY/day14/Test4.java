package com.day14;
//5~10�� �̳��� ������ �Է¹޾� ����ϴ� ���α׷�
//���ڿ� : abcd
		// ���ڿ��� ���̴� 5~10�� �Դϴ�.
		
		//���ڿ� : abc2345
		//�����ڸ� �����մϴ�.		
import java.util.Scanner;


//����
class MyAuthExcep {
	
	public void inputFormat(String str) throws Exception {
		
		//���� ���� - ���̰� 5���� �۰ų� 10���� ũ�� �ȵȴ�.
		if(str.length() < 5 || str.length() > 10) {
			throw new Exception("���ڿ��� ���̴� 5~10�� �Դϴ�!!");
		}
		
		
		int eng = 0;
		int num = 0;
		
		for(int i=0; i<str.length(); i++) {
			
			char ch = str.charAt(i);
			
			//��� ����
			//if((ch<'A' || ch>'Z' && (ch<'a' || ch>'z')) or if((ch<65 || ch>90) && (ch<97 || ch>122))
			
			if((ch>='A' && ch<='Z') || (ch>='a' && ch<'z')) {
				eng++;
			} else if(ch>='0' && ch<='9') {
				num++;
			}
		}	
		
		if(eng ==0 || num == 0)
			throw new Exception("������, ����ȥ�븸 �����մϴ�.");
	}
	
}


public class Test4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str;
		
		//���� Ŭ������ ����ϱ����� ��ü ����
		MyAuthExcep auth = new MyAuthExcep();
		
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