package a.project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Fishing extends Thread {

	public Fishing() {
		
	
	}

	
	ArrayList<FishingVO> lists = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	private int num;
	private int ch;
	private int cnt = 0;
	private String type;
	private static String[] fname = {"���Ϻ�󹰰��", "��ġ�幰���", "Ƽ���������", "ǻ��⹰���", "�̶�ٹ����",
			"��ħ", "�����������", "�����������", "�ڹ��ڹٹ����", "����Ʈ�����",
			"����Ŭ�����", "�����������", "��Ǽ������", "�����������", "�����������"};

	private String fish;
	Random rd;
	File f = new File("d:\\doc\\aquarium.txt");


	public void input() throws Exception {


		rd = new Random();
		FishingVO vo = new FishingVO();
		do {
			System.out.println();
			System.out.print("���ô� �ϳ��� ������! 1)���帣�� ���ô� 2)���ں기 ���ô� 3)������� ���ô�");
			num = sc.nextInt();

		}while(num > 3 || num < 1);

		twinkle();
		
		
		dot();

		System.out.println();

		type =fname[rd.nextInt(15)];
		if(type == "��ħ") {
			System.out.println("����Ⱑ ���������ϴ�");
			System.out.println();
			return;

		}
		vo.setAquaList(type);
		lists.add(vo);
		save();


		print();


	}

	public void print() throws Exception {

		Test t = new Test();
		System.out.println("�� �� �� �� �� �� �� ");
		System.out.println("����⸦ ��ҽ��ϴ�!");
		System.out.println("�� �� �� �� �� �� �� ");
		if(num == 1) {
			System.out.printf("%d�� ���ô븦 �� ���: %s \n", num,  type);
		}else if(num == 2) {
			System.out.printf("%d�� ���ô븦 �� ���: %s \n", num,  type);
		}else if(num == 3) {
			System.out.printf("%d�� ���ô븦 �� ���: %s \n", num,  type);
		}

		t.fish1();
	}

	public void dot() {

		Test t = new Test();

		int i = 0;
		System.out.print("����Ⱑ ���⸦ ��ٸ��� ��");

		while(i < 20) {

			System.out.print(".");

			try {
				sleep(100);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			i++;
		}
		//Thread�� �ڸ�
		System.out.println();
	}

	@Override
	public void run() {

		
		
	}



	public void aquarium() throws Exception {


		System.out.println();
		System.out.println("���������� �̵��մϴ�");
		System.out.println();




		//���� �ҷ�����
		try {

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);

			lists = (ArrayList<FishingVO>)ois.readObject();
			Iterator<FishingVO> it = lists.iterator();

			while(it.hasNext()) {

				FishingVO vo3 = it.next();
			}


		} catch (Exception e) {
			// TODO: handle exception
		}


		while(true) {

			do {
				//�ҷ��� ���� ����ϱ�
				ch = 0;
				System.out.println("�������������������");
				System.out.println("~~~~~~^~~^~~~^~~~~~~^~~~~~~^~^~~^~~~");

				System.out.println("~~���� ����� ���~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


				//System.out.println(vo.getAquaList());

				Iterator<FishingVO> it = lists.iterator();
				while(it.hasNext()) {

					FishingVO vo = it.next();
					System.out.println(vo.toString());
				}
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("�������������������");

				System.out.println();
				System.out.println("============�� �� �� �� ��==============");
				System.out.println();
				System.out.print( "1. �Ա� 2. ��� 3. �������� ���ư���");

				ch = sc.nextInt();

				switch(ch) {
				case 1 : eat(); break;
				case 2 : release();  break;
				case 3 : return;
				}


			}while(ch<1||ch>3);
		}
	}




	public void eat() {

		try {


			System.out.print("� ����⸦ �丮�Ͻðڽ��ϱ�?");
			fish = sc.next();



			if(!searchFish(fish)) {

				System.out.println("����Ⱑ �����ϴ�");
				return;
			}


			System.out.printf(" %s ��(��) �丮���Դϴ�\n",fish);
			Thread ob = new Thread();
			ob.start();
			try {
				ob.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
			Cooking c = new Cooking();
			c.cooking();

			System.out.println("�߸Ծ����ϴ�!");
			System.out.println();

			Iterator<FishingVO> it = lists.iterator();
			while(it.hasNext()) {

				FishingVO v = it.next();
				if(fish.equals(v.getAquaList())) {
					lists.remove(v);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}


	}


	public void release() {

		Test t = new Test();
		try {

			System.out.print("� ����⸦ �����ֽðڽ��ϱ�?");
			fish = sc.next();

			if(!searchFish(fish)) {

				System.out.println("����Ⱑ �����ϴ�");
				return;
			}
			System.out.println();
			System.out.printf("%s ��(��) �����־����ϴ�\n",fish);
			t.fishRelease();
			System.out.println();

			Iterator<FishingVO> it = lists.iterator();
			while(it.hasNext()) {

				FishingVO v2 = it.next();
				if(fish.equals(v2.getAquaList())) {
					lists.remove(v2);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}


	public boolean searchFish(String fish) {

		Iterator<FishingVO> it = lists.iterator();
		while(it.hasNext()) {

			FishingVO v2 = it.next();
			if(fish.equals(v2.getAquaList())) {
				return true;
			}


		}


		return false;
	}
	public void save() {


		try {

			FileOutputStream fos = new FileOutputStream("d:\\doc\\aquarium.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(lists);
			oos.close();
			fos.close();


		} catch (Exception e) {

		}

	}
	
	
	
	public void twinkle() {
		try {
			
			for(int i=0;i<10;i++) {
			twin();
			TimeUnit.MILLISECONDS.sleep(100);
			twin1();
			TimeUnit.MILLISECONDS.sleep(100);
			twin();
			TimeUnit.MILLISECONDS.sleep(100);
			twin1();
			TimeUnit.MILLISECONDS.sleep(100);
			twin();
			TimeUnit.MILLISECONDS.sleep(100);
			twin1();
			TimeUnit.MILLISECONDS.sleep(100);
			twin();
			TimeUnit.MILLISECONDS.sleep(100);
			twin1();
			TimeUnit.MILLISECONDS.sleep(100);
			
			
			}
			} catch (Exception e) {
				// TODO: handle exception
			}
	}


	public void twin() {
	
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("..............................................................");
		System.out.println("..............................waiting.........................");
		System.out.println("..............................................................");
		System.out.println("................................��............................");
		System.out.println("...............................���............................");
		System.out.println("...............................���............................");
		System.out.println("...............................���............................");
	    System.out.println("...............................���............................");
		System.out.println("...............................���............................");
		System.out.println("..............................����............................");
		System.out.println("............................������..........................");
		System.out.println("..........................��������........................");
		System.out.println(".........................���������.......................");
		System.out.println("...............................................................");
		System.out.println("..........................��������........................");
		System.out.println("...........................�������.........................");
		System.out.println("............................������..........................");
		System.out.println(".............................�����..~~~~~~~~~...............");
		System.out.println(".....~~~~~~~~~~~~~~~~~~~~.....����.....~~~~~~~~~~~~~~~~.......");
		System.out.println("...........~~~~~~~~~~~~~~.......��....~~~~~~~~~~~~~~~~~........");
		System.out.println("..............~~~~~~~~~~~~~~~~~~~~.............................");
		System.out.println("..............................~~~~~~~~~~~~.....................");
		System.out.println("................................��.............................");
		System.out.println("...........~~~~~~~~~~~..........��.............................");
		System.out.println("................................��.......~~~~~~~~~~............");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
	 }
	
	public void twin1() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("..............................................................");
		System.out.println("..............................waiting.........................");
		System.out.println("..............................................................");
		System.out.println("................................��............................");
		System.out.println("...............................���............................");
		System.out.println("...............................���............................");
		System.out.println("...............................���............................");
	    System.out.println("...............................���............................");
		System.out.println("...............................���............................");
		System.out.println("..............................����............................");
		System.out.println("............................������..........................");
		System.out.println("..........................��������........................");
		System.out.println(".........................���������.......................");
		System.out.println(".............................................................");
		System.out.println("..........................��������........................");
		System.out.println("...........................�������.........................");
		System.out.println("............................������..........................");
		System.out.println(".............................�����...~~~...~~~...............");
		System.out.println("..............~~.....~~~~.....����.....~~......~~~~~~~~.......");
		System.out.println("...........~~~~~~~~~~~~~~.......��....~~~~~~~~~~~~~~~~~........");
		System.out.println("..............~~~~.......~~~~~~~~~...........................");
		System.out.println("..............................~~~~~~~~~~~~...................");
		System.out.println("................................��.............................");
		System.out.println("..............~~...~~~..........��.............................");
		System.out.println("................................��.........~~...~~~............");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
	}


}