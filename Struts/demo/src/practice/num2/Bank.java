package practice.num2;

import java.util.Scanner;

class Account {
	
	String account_num; //계좌번호
	String name; //예금주
	int balance; //잔고
	
	//멤버메서드(입금하기)
	public void deposit(int plus_money) {
		System.out.println("====================");
		balance += plus_money; //잔고에 누적
		System.out.println(plus_money + "원 입금되었습니다!");
	}
	
	//출금하기
	public void withdraw(int minus_money) {
		System.out.println("====================");
		balance -= minus_money;
		System.out.println(minus_money + "원 출금되었습니다!");
	}
	
	//계좌정보
	public void printAccount() {
		System.out.println("======================================");
		System.out.println("[" + name + "님의 계좌]");
		System.out.println("계좌번호 : " + account_num);
		System.out.println("예금주 : " + name);
		System.out.println("잔고 : " + balance + "원");
	}
}


public class Bank {
	
	public static void main(String[] args) {
		
		Account a = new Account();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계좌번호 입력 : ");
		a.account_num = sc.nextLine();
		System.out.print("예금주 입력 : ");
		a.name = sc.next();
		System.out.print("잔고 입력 : ");
		a.balance = sc.nextInt();
		
		
		/*a.printAccount();//계좌정보 출력
		
		System.out.print("입금액 : ");
		a.deposit(sc.nextInt());
		
		a.printAccount();
		
		System.out.println("출금액 : ");
		a.withdraw(sc.nextInt());
		
		a.printAccount();*/
		
		while(true) {
			
			
			System.out.println("======================================");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("======================================");
			
			System.out.print("메뉴 선택 ->");
			int num = sc.nextInt();
			
			if(num == 1) {
				System.out.print("예금액 : ");
				a.deposit(sc.nextInt());
			} else if(num == 2) {
				System.out.print("출금액 : ");
				a.withdraw(sc.nextInt());
			} else if(num == 3) {
				System.out.print("잔고 : ");
				a.printAccount();
			} else if(num == 4) {
				System.out.print("프로그램 종료");
				break;
			} else {
				System.out.println("잘못 입력했습니다!");
			}
		}
		
	}

}
