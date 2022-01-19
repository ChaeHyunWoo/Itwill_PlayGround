package a.project;
import java.util.InputMismatchException;
import java.util.Random;
//테스트용
import java.util.Scanner;

public class hello extends Thread {
	public static int MAX = 10;

	static Scanner sc = new Scanner(System.in);
	static String[] box = new String[MAX];
	static int[] price = new int[MAX];
	static int count = 10;
	static Random rd = new Random();
	static int admin = 7777; // 관리자 메뉴로 가는 비밀번호
    static int totalMoney = 0; // 총 수익
    
    
	@Override
	public void run() {
		int i=0;
		while(i<3) {
			
			System.out.println("     ___#________");
			System.out.println("    // *       //");
			System.out.println("   //    음    //");
			System.out.println("  //    료  * //");
			System.out.println(" //*   수    //");
			System.out.println("//     *    //");
			System.out.println("￣￣￣￣￣￣￣");
			System.out.println();
			System.out.println("___#________     ");
			System.out.println("\\\\ *       \\\\");
			System.out.println(" \\\\    음   \\\\");
			System.out.println("  \\\\  * 료   \\\\");
			System.out.println("   \\\\    수 * \\\\");
			System.out.println("    \\\\    *    \\\\");
			System.out.println("    ￣￣￣￣￣￣￣");
			i++;
			
			try {
				sleep(800);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	public static void admine() {
		
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
		
		
	public static void initialize() {
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

		box[6] = "솔의 코";
		price[6] = 900;

		box[7] = "옥수수 콧털차";
		price[7] = 1700;

		box[8] = "금수저의 물";
		price[8] = 50000;
		
		box[9] = "랜덤뽑기";
		price[9] = 3000;


	}
	//자판기 화면 인터페이스
	public static void user() {
		
		Boolean first = true;
		int money = 0; //처음 자판기 금액 초기화
		
		/*
		hello p2 = new hello();
		p2.start();
		
		try {
			p2.join();
			
			
		} catch (Exception e) {
			
		}
		*/
		System.out.println("=========================================================");
		System.out.println();
		System.out.println("   자 판 기  ");
		System.out.println(" _____________          ////\\\\"); 	
		System.out.println("| _ _________ |         |      |");
		System.out.println("||.---------.||        @  o  o  @");
		System.out.println("|||         |||         |  ~   |");
		System.out.println("|||         |||         \\  --  /         |\\  |");
		System.out.println("|||         |||         __|  |___        | \\ |");
		System.out.println("|||---------|||       //         \\      /|___|");
		System.out.println("| ........... |      //           \\    / /");
		System.out.println("| ||  ^^^  () |     /  /| .  . |\\  \\  / /");
		System.out.println("|[  ]         |    /  / |      | \\  \\/ /");
	    System.out.println("| ||          |   <  <  |      |  \\   /");
	    System.out.println("|     _ _     |    \\   \\|  .   |   \\_/");
		System.out.println("|          :::|     \\  \\|______|");
		System.out.println("|-------------|         |      |");
		System.out.println("                        |  |   |");
		System.out.println();
		System.out.println("어서오세요~~ 성재와 현우가 부자되기위한 자판기입니다!!");
		System.out.println();
		
		while(true) {
			
			System.out.println();
			System.out.println("▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
			System.out.println("▥              음료수 자판기! (번호 : 삼품)                ▥");
			System.out.println("▥                                                          ▥");
			System.out.println("▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
			System.out.println("▥                                                          ▥");
			System.out.println("▥                                                          ▥");
			System.out.println("▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥▥");
			System.out.println();
			
			for(int i=0; i<count; i++) {
				if(i==3) {
					
					System.out.println();
					System.out.println();
				}
				if(i==6) {
					
					System.out.println();
					System.out.println();
				}
				System.out.print("[" + (i+1) + "] :" + box[i] + "(" + price[i] + "원) ");
			}

			System.out.println();
			System.out.println("===========================================================================");
			
			
			try {
				
			if(first) {
				
				
				System.out.println("※주의사항 : 카드결제시 부가세 150% 추가!");
				System.out.print("동전이나 지폐를 넣어주세요 : ");
				money = sc.nextInt();
				first = false;
				}
			////
			if(money == 7777) {
                admine();
                return;
            }
			} catch (InputMismatchException e) {
				//변수의 선언형 값이 아닌 값을 입력시 오류를 캐치(InputMismatchException e)해서 
				//입력받은 값을 초기화 sc.nextLine(); 해준다. 엔터치기전의 키값을 전부 비운다.
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
			
			
			
			System.out.print("메뉴 입력 : ");
			int num = sc.nextInt();
			
			
			

			hello p1 = new hello();
			p1.start();

			try {
				//돈이 충분한지
				p1.join(); // 종료될때까지 대기 쓰레드
				
				
				
				if(num == 10) {
					
					int rand = (int)(Math.random()*8) + 1;
					System.out.println(box[rand] + " 이/가 나왔습니다~");
					money = money - price[num-1];
					totalMoney += price[num-1];
				}
				
				else if(money >= price[num-1]) {
					
					money = money - price[num-1];
					totalMoney += price[num-1];
					System.out.println(box[num-1] + " 이/가 나왔습니다~");
				}
				
				else { 
					
					System.out.println("잔액이 부족합니다....");
				}
				

			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println();
			System.out.println("◇◆[잔액 : " + money +"원]◆◇");
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
			System.out.println("[1] 계속 구매하기 [2] 금액 추가하기 [3] 잔돈 반환하기 [4] 도망치기");
			System.out.print("번호를 입력하시오 : ");
			int num1 = sc.nextInt();
			
			try {
				

			if(num1 ==1) {
				continue;
			}
			else if (num1 ==2) {
				System.out.println();
				System.out.print("동전이나 지폐를 투입해주세요(카드사절) : ");
				int extra = sc.nextInt();
				if(extra == 7777) {
	                admine();
	                return;
	            }
				money += extra;//시작
				System.out.println();
				System.out.println("금액이 추가 되었습니다! ◇◆남은 잔액 : " + money + "원◆◇");
				
			}
			
			
			else if(num1 == 3) {
				System.out.println();
				System.out.println("◇◆거스름돈 " + money + "원이 반환되었습니다.◆◇");
				System.out.println();
				//System.out.println("다음에 또 이용해주세요~~");
				first = true;
				
			} else if(num1 == 4) {
				System.out.println();
				System.out.println("손님이 도망가버렸습니다!!!!  잔돈 내꺼 ㅎ");
				System.exit(0);
			} else if(num1 != -1) {
				System.out.println();
				System.out.println("잘못누르셨습니다. 다시 버튼을 눌러서 구매하세요");
			}
			
			}
			catch (InputMismatchException e) {
				System.out.println("이상한거 넣지말고 돈넣어라!!!");
				sc.nextLine();
				System.out.println("※주의사항 : 카드결제시 부가세 150% 추가!");
				System.out.print("동전이나 지폐를 넣어주세요(카드사절): ");
				money = sc.nextInt();
			}
			}

		}
	


	public static void main(String[] args) {

		initialize();
		user();
		return;

	}
}