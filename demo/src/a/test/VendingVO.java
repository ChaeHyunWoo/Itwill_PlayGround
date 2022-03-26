package a.test;

import java.util.Random;
import java.util.Scanner;

public class VendingVO  {

	public int MAX = 10;
	String[] box = new String[MAX];
	int[] price = new int[MAX];
	int count = 10;
	Random rd = new Random();
	int admin = 7777; // 관리자 메뉴로 가는 비밀번호
	//int extra = 7777;
	int totalMoney = 0; // 총 수익


	Scanner sc = new Scanner(System.in);

	public void list() {

		box[0] = "고가-골라";
		price[0] = 1300;

		box[1] = "스포트라이트";
		price[1] = 1100;

		box[2] = "비크닉";
		price[2] = 500;

		box[3] = "렝스비";
		price[3] = 700;

		box[4] = "파워레인저";
		price[4] = 1300;

		box[5] = "핫세븐";
		price[5] = 1000;

		box[6] = "솔의 눈코입";
		price[6] = 900;

		box[7] = "옥수수 콧털차";
		price[7] = 1700;

		box[8] = "금수저의 물";
		price[8] = 50000;

		box[9] = "랜덤뽑기";
		price[9] = 3000;


	}


	public void admine() {


		//user();

		while(true) {

			System.out.println("================================================");
			System.out.println();
			System.out.println("---------------관리자 페이지--------------------");
			System.out.println();
			System.out.println("1. 수익 확인  2. 종료 ");
			System.out.println();
			System.out.print("번호를 입력하세요 : ");
			int num = sc.nextInt();
			System.out.println();
			System.out.println("================================================");

			if(num == 1) {

				System.out.println("현재까지의 수익은 " + totalMoney + "입니다.");

			} 

			else if(num == 2) {

				user();
				return;
			}


		}


	}



	public void user () {


		Boolean first = true;
		int money = 0; //처음 자판기 금액 초기화

		while(true) {



			try {
				Test t = new Test();
				list();
				System.out.println("==================================================================================");

				for(int i=0; i<count; i++) {
					if(i==3) {

						System.out.println();
						System.out.println();
					}
					if(i==6) {

						System.out.println();
						System.out.println();
					}
					if(i==9) {

						System.out.println();
						System.out.println();
					}
					System.out.print("[" + (i+1) + "] :" + box[i] + "(" + price[i] + "원) ");
				}

				if(first) {

					System.out.println();
					System.out.println("==================================================================================");
					System.out.println("※주의사항 : 카드결제시 부가세 150% 추가!");
					System.out.print("동전이나 지폐를 넣어주세요 : ");
					money = sc.nextInt();
					t.coin();
					first = false;
				}
				////
				if(money == 7777) {
					admine();
					return;
				}
			} catch (Exception e) {
				
				
				System.out.println("이상한거 넣지말고 돈넣어라!!!");
				sc.nextLine();
				System.out.println("※주의사항 : 카드결제시 부가세 150% 추가!");
				System.out.print("동전이나 지폐를 넣어주세요 : ");
				//
				money = sc.nextInt();
				if(money == 7777) {
					admine();
					return;
				}

			}


			System.out.println();
			System.out.println("==================================================================================");
			System.out.print("메뉴 입력 : ");
			int num = sc.nextInt();

			Test t = new Test();

			try {

				//t.drinkCan(); 

				if(num > 10) {
					System.out.println();
					System.out.println("잘못누르셨습니다. 다시 버튼을 눌러서 구매하세요");
					continue;
				}

				if(money < price[num-1]) {
					System.out.println("잔액이 부족합니다....");
					System.out.println("[[잔액 : " + money +"원]]");
					continue;
				}

				t.drinkCan(); 
				//돈이 충분한지
				if(num == 10 && money >= price[num-1]) {

					int rand = (int)(Math.random()*8) + 1;
					System.out.println("(" + box[rand] + " ) 이/가 나왔습니다~");
					money = money - price[num-1];
					totalMoney += price[num-1];
				} 

				else if(money >= price[num-1]) {

					money = money - price[num-1];
					totalMoney += price[num-1];
					System.out.println("(" + box[num-1] + " ) 이/가 나왔습니다~");
				}




			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println();
			System.out.println("[[잔액 : " + money +"원]]");
			System.out.println();
			System.out.println("========================================================================");

			//돈이0원이 되면 종료 처음으로
			if(money == 0 ) {
				System.out.println();
				System.out.println("호갱님~ 감사합니다! 또 이용해주세요~~~");
				first = true;
				continue;
			}

			//돈이 0원이 아니라면 진행
			System.out.println("[1] 계속 구매하기 [2] 금액 추가하기 [3] 잔돈 반환하기 [4] 도망치기  [5] 관리자");
			System.out.println();
			System.out.print("번호를 입력하시오 : ");
			int num1 = sc.nextInt();
			System.out.println("======================================================================");

			try {

				//VendingVO v = new VendingVO();

				if(num1 ==1) {
					//System.out.println("======================================================================");
					continue;
				}
				else if (num1 ==2) {
					System.out.println();
					System.out.print("동전이나 지폐를 투입해주세요(카드사절) : ");
					int extra = sc.nextInt();
					money += extra;//시작
					System.out.println();
					System.out.println("금액이 추가 되었습니다! [ 남은 잔액 : " + money + "원 ]");
					System.out.println("======================================================================");

				}

				else if(num1 == 3) {
					System.out.println();
					System.out.println("[ 거스름돈 " + money + "원이 반환되었습니다. ]");
					System.out.println();
					//System.out.println("다음에 또 이용해주세요~~");
					first = true;
				}



				else if(num1 == 4) {
					System.out.println();
					System.out.println("손님이 도망가버렸습니다!!!!" + money + "원 내꺼 ㅎ");
					System.exit(0);
				} 

				else if(num1 == 5) {

					admine();
					return;
				}

				else if(num1 != -1) {
					System.out.println();
					System.out.println("잘못누르셨습니다. 강제로 구매하세요 *^^*");
				}


			}
			catch (Exception e) {
				System.out.println("이상한거 넣지말고 돈넣어라!!!");
				sc.nextLine();
				System.out.println("※주의사항 : 카드결제시 부가세 150% 추가!");
				System.out.print("동전이나 지폐를 넣어주세요(카드사절): ");
				money = sc.nextInt();
			}
		}

	}
}
