package a.test;

import java.util.Random;
import java.util.Scanner;

public class VendingVO  {

	public int MAX = 10;
	String[] box = new String[MAX];
	int[] price = new int[MAX];
	int count = 10;
	Random rd = new Random();
	int admin = 7777; // ������ �޴��� ���� ��й�ȣ
	//int extra = 7777;
	int totalMoney = 0; // �� ����


	Scanner sc = new Scanner(System.in);

	public void list() {

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

		box[6] = "���� ������";
		price[6] = 900;

		box[7] = "������ ������";
		price[7] = 1700;

		box[8] = "�ݼ����� ��";
		price[8] = 50000;

		box[9] = "�����̱�";
		price[9] = 3000;


	}


	public void admine() {


		//user();

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



	public void user () {


		Boolean first = true;
		int money = 0; //ó�� ���Ǳ� �ݾ� �ʱ�ȭ

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
					System.out.print("[" + (i+1) + "] :" + box[i] + "(" + price[i] + "��) ");
				}

				if(first) {

					System.out.println();
					System.out.println("==================================================================================");
					System.out.println("�����ǻ��� : ī������� �ΰ��� 150% �߰�!");
					System.out.print("�����̳� ���� �־��ּ��� : ");
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


			System.out.println();
			System.out.println("==================================================================================");
			System.out.print("�޴� �Է� : ");
			int num = sc.nextInt();

			Test t = new Test();

			try {

				//t.drinkCan(); 

				if(num > 10) {
					System.out.println();
					System.out.println("�߸������̽��ϴ�. �ٽ� ��ư�� ������ �����ϼ���");
					continue;
				}

				if(money < price[num-1]) {
					System.out.println("�ܾ��� �����մϴ�....");
					System.out.println("[[�ܾ� : " + money +"��]]");
					continue;
				}

				t.drinkCan(); 
				//���� �������
				if(num == 10 && money >= price[num-1]) {

					int rand = (int)(Math.random()*8) + 1;
					System.out.println("(" + box[rand] + " ) ��/�� ���Խ��ϴ�~");
					money = money - price[num-1];
					totalMoney += price[num-1];
				} 

				else if(money >= price[num-1]) {

					money = money - price[num-1];
					totalMoney += price[num-1];
					System.out.println("(" + box[num-1] + " ) ��/�� ���Խ��ϴ�~");
				}




			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println();
			System.out.println("[[�ܾ� : " + money +"��]]");
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
			System.out.println("[1] ��� �����ϱ� [2] �ݾ� �߰��ϱ� [3] �ܵ� ��ȯ�ϱ� [4] ����ġ��  [5] ������");
			System.out.println();
			System.out.print("��ȣ�� �Է��Ͻÿ� : ");
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
					System.out.print("�����̳� ���� �������ּ���(ī�����) : ");
					int extra = sc.nextInt();
					money += extra;//����
					System.out.println();
					System.out.println("�ݾ��� �߰� �Ǿ����ϴ�! [ ���� �ܾ� : " + money + "�� ]");
					System.out.println("======================================================================");

				}

				else if(num1 == 3) {
					System.out.println();
					System.out.println("[ �Ž����� " + money + "���� ��ȯ�Ǿ����ϴ�. ]");
					System.out.println();
					//System.out.println("������ �� �̿����ּ���~~");
					first = true;
				}



				else if(num1 == 4) {
					System.out.println();
					System.out.println("�մ��� ���������Ƚ��ϴ�!!!!" + money + "�� ���� ��");
					System.exit(0);
				} 

				else if(num1 == 5) {

					admine();
					return;
				}

				else if(num1 != -1) {
					System.out.println();
					System.out.println("�߸������̽��ϴ�. ������ �����ϼ��� *^^*");
				}


			}
			catch (Exception e) {
				System.out.println("�̻��Ѱ� �������� ���־��!!!");
				sc.nextLine();
				System.out.println("�����ǻ��� : ī������� �ΰ��� 150% �߰�!");
				System.out.print("�����̳� ���� �־��ּ���(ī�����): ");
				money = sc.nextInt();
			}
		}

	}
}
