package com.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		// system.in�� 1����Ʈ ���ڸ� �о��.
		// InputStreamReader�� 1����Ʈ ���ڸ� 2����Ʈ�� �ٲ㼭 �о��.
		int num1,num2;
		
		System.out.print("ù��° ��?");//20
		num1 = Integer.parseInt(br.readLine());
		
		System.out.print("�ι�° ��?");//5
		num2 = Integer.parseInt(br.readLine());
		
		System.out.printf("%d + %d = %d\t",num1,num2,num1+num2);
		System.out.printf("%d - %d = %d\n",num1,num2,num1-num2);
		System.out.printf("%d * %d = %d\t",num1,num2,num1*num2);
		System.out.printf("%d / %d = %d\n",num1,num2,num1/num2);
		System.out.printf("%d %% %d = %d\n",num1,num2,num1%num2);
		
		System.out.println("num1>num2: " + (num1>num2));
		System.out.println("num1==num2: " + (num1==num2));
		
		
		String str;
		
		//���׿�����(����?true��:false��)
		str = num1%2==0?"¦��":"Ȧ��";
		
		str = num1>0?"���":(num1<0?"����":"��");
		
		 //1. ������ ture�̸� "���"�� ����, 2. false�̸� (num1<0?�κ��� �����ϴµ� ���⵵ 
		 //3. �����̸� "����":"��"����
		
		//  (�׸���)  A and(&&) B : A, B �Ѵ� true�̿��� ����� true
		//  (�Ǵ�)    A OR(||) B : A,B ���� �ϳ��� true�̸� ����� true
	
		str = num1%4==0 && num1%100!=0 || num1%400==0?"����":"���";
		
		System.out.println(num1 + ":" + str);
		
		
		//https://blog.naver.com/lbr71004/222158448268
		//�� ���ǻ���

		//1. ���׿����ڸ� ����Ͽ� �ڵ��� ������ �پ����ٰ� ������ �ӵ��� �������� ���� �ƴմϴ�.

		//2. ���׿����ڸ� �ߺ��ؼ� ó���� ���. �������� ������ �� �����Ƿ� �ߺ�ó���� ���ϴ°��� �����ϴ�.

	}

}



