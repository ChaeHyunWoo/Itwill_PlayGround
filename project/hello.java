package a.project;
import java.util.InputMismatchException;
import java.util.Random;
//�׽�Ʈ��
import java.util.Scanner;

public class hello extends Thread {
	public static int MAX = 10;

	static Scanner sc = new Scanner(System.in);
	static String[] box = new String[MAX];
	static int[] price = new int[MAX];
	static int count = 10;
	static Random rd = new Random();
	static int admin = 7777; // ������ �޴��� ���� ��й�ȣ
    static int totalMoney = 0; // �� ����
    
    
	@Override
	public void run() {
		int i=0;
		while(i<3) {
			
			System.out.println("     ___#________");
			System.out.println("    // *       //");
			System.out.println("   //    ��    //");
			System.out.println("  //    ��  * //");
			System.out.println(" //*   ��    //");
			System.out.println("//     *    //");
			System.out.println("��������������");
			System.out.println();
			System.out.println("___#________     ");
			System.out.println("\\\\ *       \\\\");
			System.out.println(" \\\\    ��   \\\\");
			System.out.println("  \\\\  * ��   \\\\");
			System.out.println("   \\\\    �� * \\\\");
			System.out.println("    \\\\    *    \\\\");
			System.out.println("    ��������������");
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
			System.out.println("---------------������ ������--------------------");
			System.out.println();
			System.out.println("1. ���� Ȯ��  2. ���� ");
			System.out.println();
			System.out.print("��ȣ�� �Է��ϼ��� : ");
			int num = sc.nextInt();
			System.out.println();
			System.out.println("================================================");
			
			if(num == 1) {
				
				System.out.println("��������� ������ " + totalMoney + "�Դϴ�.");
				
			} 
			
			else if(num == 2) {
				
				user();
                return;
			}
			
			
		}
		
		
	}
		
		
	public static void initialize() {
		box[0] = "��-���";
		price[0] = 1300;

		box[1] = "����Ʈ����Ʈ";
		price[1] = 1100;

		box[2] = "��ũ��";
		price[2] = 500;

		box[3] = "������";
		price[3] = 700;

		box[4] = "�Ŀ�������";
		price[4] = 1300;

		box[5] = "�ּ���";
		price[5] = 1000;

		box[6] = "���� ��";
		price[6] = 900;

		box[7] = "������ ������";
		price[7] = 1700;

		box[8] = "�ݼ����� ��";
		price[8] = 50000;
		
		box[9] = "�����̱�";
		price[9] = 3000;


	}
	//���Ǳ� ȭ�� �������̽�
	public static void user() {
		
		Boolean first = true;
		int money = 0; //ó�� ���Ǳ� �ݾ� �ʱ�ȭ
		
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
		System.out.println("   �� �� ��  ");
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
		System.out.println("�������~~ ����� ���찡 ���ڵǱ����� ���Ǳ��Դϴ�!!");
		System.out.println();
		
		while(true) {
			
			System.out.println();
			System.out.println("�ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");
			System.out.println("��              ����� ���Ǳ�! (��ȣ : ��ǰ)                ��");
			System.out.println("��                                                          ��");
			System.out.println("�ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");
			System.out.println("��                                                          ��");
			System.out.println("��                                                          ��");
			System.out.println("�ȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢȢ�");
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
				System.out.print("[" + (i+1) + "] :" + box[i] + "(" + price[i] + "��) ");
			}

			System.out.println();
			System.out.println("===========================================================================");
			
			
			try {
				
			if(first) {
				
				
				System.out.println("�����ǻ��� : ī������� �ΰ��� 150% �߰�!");
				System.out.print("�����̳� ���� �־��ּ��� : ");
				money = sc.nextInt();
				first = false;
				}
			////
			if(money == 7777) {
                admine();
                return;
            }
			} catch (InputMismatchException e) {
				//������ ������ ���� �ƴ� ���� �Է½� ������ ĳġ(InputMismatchException e)�ؼ� 
				//�Է¹��� ���� �ʱ�ȭ sc.nextLine(); ���ش�. ����ġ������ Ű���� ���� ����.
				System.out.println("�̻��Ѱ� �������� ���־��!!!");
				sc.nextLine();
				System.out.println("�����ǻ��� : ī������� �ΰ��� 150% �߰�!");
				System.out.print("�����̳� ���� �־��ּ��� : ");
				//
				money = sc.nextInt();
				if(money == 7777) {
	                admine();
	                return;
	            }
				
			}
			
			
			
			System.out.print("�޴� �Է� : ");
			int num = sc.nextInt();
			
			
			

			hello p1 = new hello();
			p1.start();

			try {
				//���� �������
				p1.join(); // ����ɶ����� ��� ������
				
				
				
				if(num == 10) {
					
					int rand = (int)(Math.random()*8) + 1;
					System.out.println(box[rand] + " ��/�� ���Խ��ϴ�~");
					money = money - price[num-1];
					totalMoney += price[num-1];
				}
				
				else if(money >= price[num-1]) {
					
					money = money - price[num-1];
					totalMoney += price[num-1];
					System.out.println(box[num-1] + " ��/�� ���Խ��ϴ�~");
				}
				
				else { 
					
					System.out.println("�ܾ��� �����մϴ�....");
				}
				

			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println();
			System.out.println("�ޡ�[�ܾ� : " + money +"��]�ߡ�");
			System.out.println();
			System.out.println("========================================================================");

			//����0���� �Ǹ� ���� ó������
			if(money == 0 ) {
				System.out.println();
				System.out.println("ȣ����~ �����մϴ�! �� �̿����ּ���~~~");
				first = true;
				continue;
			}

			//���� 0���� �ƴ϶�� ����
			System.out.println("[1] ��� �����ϱ� [2] �ݾ� �߰��ϱ� [3] �ܵ� ��ȯ�ϱ� [4] ����ġ��");
			System.out.print("��ȣ�� �Է��Ͻÿ� : ");
			int num1 = sc.nextInt();
			
			try {
				

			if(num1 ==1) {
				continue;
			}
			else if (num1 ==2) {
				System.out.println();
				System.out.print("�����̳� ���� �������ּ���(ī�����) : ");
				int extra = sc.nextInt();
				if(extra == 7777) {
	                admine();
	                return;
	            }
				money += extra;//����
				System.out.println();
				System.out.println("�ݾ��� �߰� �Ǿ����ϴ�! �ޡ߳��� �ܾ� : " + money + "���ߡ�");
				
			}
			
			
			else if(num1 == 3) {
				System.out.println();
				System.out.println("�ޡ߰Ž����� " + money + "���� ��ȯ�Ǿ����ϴ�.�ߡ�");
				System.out.println();
				//System.out.println("������ �� �̿����ּ���~~");
				first = true;
				
			} else if(num1 == 4) {
				System.out.println();
				System.out.println("�մ��� ���������Ƚ��ϴ�!!!!  �ܵ� ���� ��");
				System.exit(0);
			} else if(num1 != -1) {
				System.out.println();
				System.out.println("�߸������̽��ϴ�. �ٽ� ��ư�� ������ �����ϼ���");
			}
			
			}
			catch (InputMismatchException e) {
				System.out.println("�̻��Ѱ� �������� ���־��!!!");
				sc.nextLine();
				System.out.println("�����ǻ��� : ī������� �ΰ��� 150% �߰�!");
				System.out.print("�����̳� ���� �־��ּ���(ī�����): ");
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