package com.day15;

import java.util.Random;
import java.util.Scanner;

class MyThread77 extends Thread {
	
	
	
	@Override
	public void run() {
		
		for(int i=1; i<=15; i++) {
			//반복 실행할 작업 "." 15번찍기
			System.out.print(".");
			
			try {
				sleep(100); //스레드는 sleep 필수 0.01초쉬자
			} catch (Exception e) {
			}
			
		}
	}
}

public class SelectMember extends MyThread77 {
	
	
	public static void main(String[] args) throws InterruptedException  {
		
		Scanner sc = new Scanner(System.in);//입력
		Random rd = new Random(); //랜덤
		MyThread77 t77 = new MyThread77();
		
		String[] name = {"전상원","박  범","김찬주","진현주","남승은",
				"박가윤","서동혁","양세리","김창훈","이주현",
				"왕혜민","이종원","장하은","김성재","채현우",
				"이윤재","전성덕","이나영","배승환","이한솔"};
		
		
		
		String [] presenter;	// presenter : 발표자
		
		int num, check; // num:발표자 인원 수 /
		int su = 0;
		
		do{
			System.out.print("발표자 인원수 : ");
			num = sc.nextInt();
		}while(num<1 || num>20);
		
		presenter = new String[num];//배열크기 지정
		
		while(su<num) {
			
			check = rd.nextInt(19)+1;
			presenter[su] = name[check];
			
			for(int i=0; i<su; i++) {		
				if(presenter[i].equals(presenter[su])) {
					su--;				
					break;				
				}						
			}
			su++;
			
		}
		System.out.print("고민중");
		t77.start();
		
		try {
			t77.join();  //t77끝날때까지 기다리기
		} catch (Exception e) {
		}
		
		System.out.println();
		System.out.print("축하합니다!!, 발표자 입니다\n");
		System.out.println("----------------------------------");
		
		int j = 1;
		//for(요소의 자료형 매개변수 : 배열명){  }
		for(String i:presenter) {
			
			
			System.out.printf("%d번째 발표자 : %s \n", j, i);
			j++;
			Thread.sleep(100);
		}
	
	}

}