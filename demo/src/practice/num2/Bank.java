package practice.num2;

import java.util.Scanner;

class Account {
	
	String account_num; //���¹�ȣ
	String name; //������
	int balance; //�ܰ�
	
	//����޼���(�Ա��ϱ�)
	public void deposit(int plus_money) {
		System.out.println("====================");
		balance += plus_money; //�ܰ� ����
		System.out.println(plus_money + "�� �ԱݵǾ����ϴ�!");
	}
	
	//����ϱ�
	public void withdraw(int minus_money) {
		System.out.println("====================");
		balance -= minus_money;
		System.out.println(minus_money + "�� ��ݵǾ����ϴ�!");
	}
	
	//��������
	public void printAccount() {
		System.out.println("======================================");
		System.out.println("[" + name + "���� ����]");
		System.out.println("���¹�ȣ : " + account_num);
		System.out.println("������ : " + name);
		System.out.println("�ܰ� : " + balance + "��");
	}
}


public class Bank {
	
	public static void main(String[] args) {
		
		Account a = new Account();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���¹�ȣ �Է� : ");
		a.account_num = sc.nextLine();
		System.out.print("������ �Է� : ");
		a.name = sc.next();
		System.out.print("�ܰ� �Է� : ");
		a.balance = sc.nextInt();
		
		
		/*a.printAccount();//�������� ���
		
		System.out.print("�Աݾ� : ");
		a.deposit(sc.nextInt());
		
		a.printAccount();
		
		System.out.println("��ݾ� : ");
		a.withdraw(sc.nextInt());
		
		a.printAccount();*/
		
		while(true) {
			
			
			System.out.println("======================================");
			System.out.println("1. ���� | 2. ��� | 3. �ܰ� | 4. ����");
			System.out.println("======================================");
			
			System.out.print("�޴� ���� ->");
			int num = sc.nextInt();
			
			if(num == 1) {
				System.out.print("���ݾ� : ");
				a.deposit(sc.nextInt());
			} else if(num == 2) {
				System.out.print("��ݾ� : ");
				a.withdraw(sc.nextInt());
			} else if(num == 3) {
				System.out.print("�ܰ� : ");
				a.printAccount();
			} else if(num == 4) {
				System.out.print("���α׷� ����");
				break;
			} else {
				System.out.println("�߸� �Է��߽��ϴ�!");
			}
		}
		
	}

}
