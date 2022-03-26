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
	private static String[] fname = {"사하브라물고기", "피치드물고기", "티위르물고기", "퓨라기물고기", "미라다물고기",
			"놓침", "시프란물고기", "스프링물고기", "자바자바물고기", "리엑트물고기",
			"오라클물고기", "애프르물고기", "사므성물고기", "엘지르물고기", "헤프리물고기"};

	private String fish;
	Random rd;
	File f = new File("d:\\doc\\aquarium.txt");


	public void input() throws Exception {


		rd = new Random();
		FishingVO vo = new FishingVO();
		do {
			System.out.println();
			System.out.print("낚시대 하나를 고르세요! 1)셔흐르린 낚시대 2)잘자브린 낚시대 3)평버므한 낚시대");
			num = sc.nextInt();

		}while(num > 3 || num < 1);

		twinkle();
		
		
		dot();

		System.out.println();

		type =fname[rd.nextInt(15)];
		if(type == "놓침") {
			System.out.println("물고기가 도망갔습니다");
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
		System.out.println("★ ★ ★ ★ ★ ★ ★ ");
		System.out.println("물고기를 잡았습니다!");
		System.out.println("★ ★ ★ ★ ★ ★ ★ ");
		if(num == 1) {
			System.out.printf("%d번 낚시대를 고른 당신: %s \n", num,  type);
		}else if(num == 2) {
			System.out.printf("%d번 낚시대를 고른 당신: %s \n", num,  type);
		}else if(num == 3) {
			System.out.printf("%d번 낚시대를 고른 당신: %s \n", num,  type);
		}

		t.fish1();
	}

	public void dot() {

		Test t = new Test();

		int i = 0;
		System.out.print("물고기가 오기를 기다리는 중");

		while(i < 20) {

			System.out.print(".");

			try {
				sleep(100);
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			i++;
		}
		//Thread들어갈 자리
		System.out.println();
	}

	@Override
	public void run() {

		
		
	}



	public void aquarium() throws Exception {


		System.out.println();
		System.out.println("수족관으로 이동합니다");
		System.out.println();




		//파일 불러오기
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
				//불러온 파일 출력하기
				ch = 0;
				System.out.println("■■■■■■■■■■■■■■■■■■");
				System.out.println("~~~~~~^~~^~~~^~~~~~~^~~~~~~^~^~~^~~~");

				System.out.println("~~잡은 물고기 목록~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


				//System.out.println(vo.getAquaList());

				Iterator<FishingVO> it = lists.iterator();
				while(it.hasNext()) {

					FishingVO vo = it.next();
					System.out.println(vo.toString());
				}
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("■■■■■■■■■■■■■■■■■■");

				System.out.println();
				System.out.println("============수 족 관 메 뉴==============");
				System.out.println();
				System.out.print( "1. 먹기 2. 방생 3. 메인으로 돌아가기");

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


			System.out.print("어떤 물고기를 요리하시겠습니까?");
			fish = sc.next();



			if(!searchFish(fish)) {

				System.out.println("물고기가 없습니다");
				return;
			}


			System.out.printf(" %s 를(을) 요리중입니다\n",fish);
			Thread ob = new Thread();
			ob.start();
			try {
				ob.join();
			} catch (Exception e) {
				// TODO: handle exception
			}
			Cooking c = new Cooking();
			c.cooking();

			System.out.println("잘먹었습니다!");
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

			System.out.print("어떤 물고기를 놓아주시겠습니까?");
			fish = sc.next();

			if(!searchFish(fish)) {

				System.out.println("물고기가 없습니다");
				return;
			}
			System.out.println();
			System.out.printf("%s 를(을) 놓아주었습니다\n",fish);
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
		System.out.println("................................■............................");
		System.out.println("...............................■■............................");
		System.out.println("...............................■■............................");
		System.out.println("...............................■■............................");
	    System.out.println("...............................■■............................");
		System.out.println("...............................■■............................");
		System.out.println("..............................■■■............................");
		System.out.println("............................■■■■■..........................");
		System.out.println("..........................■■■■■■■........................");
		System.out.println(".........................■■■■■■■■.......................");
		System.out.println("...............................................................");
		System.out.println("..........................■■■■■■■........................");
		System.out.println("...........................■■■■■■.........................");
		System.out.println("............................■■■■■..........................");
		System.out.println(".............................■■■■..~~~~~~~~~...............");
		System.out.println(".....~~~~~~~~~~~~~~~~~~~~.....■■■.....~~~~~~~~~~~~~~~~.......");
		System.out.println("...........~~~~~~~~~~~~~~.......■....~~~~~~~~~~~~~~~~~........");
		System.out.println("..............~~~~~~~~~~~~~~~~~~~~.............................");
		System.out.println("..............................~~~~~~~~~~~~.....................");
		System.out.println("................................■.............................");
		System.out.println("...........~~~~~~~~~~~..........■.............................");
		System.out.println("................................■.......~~~~~~~~~~............");
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
		System.out.println("................................□............................");
		System.out.println("...............................□□............................");
		System.out.println("...............................□□............................");
		System.out.println("...............................□□............................");
	    System.out.println("...............................□□............................");
		System.out.println("...............................□□............................");
		System.out.println("..............................□□□............................");
		System.out.println("............................□□□□□..........................");
		System.out.println("..........................□□□□□□□........................");
		System.out.println(".........................□□□□□□□□.......................");
		System.out.println(".............................................................");
		System.out.println("..........................□□□□□□□........................");
		System.out.println("...........................□□□□□□.........................");
		System.out.println("............................□□□□□..........................");
		System.out.println(".............................□□□□...~~~...~~~...............");
		System.out.println("..............~~.....~~~~.....□□□.....~~......~~~~~~~~.......");
		System.out.println("...........~~~~~~~~~~~~~~.......□....~~~~~~~~~~~~~~~~~........");
		System.out.println("..............~~~~.......~~~~~~~~~...........................");
		System.out.println("..............................~~~~~~~~~~~~...................");
		System.out.println("................................□.............................");
		System.out.println("..............~~...~~~..........□.............................");
		System.out.println("................................□.........~~...~~~............");
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