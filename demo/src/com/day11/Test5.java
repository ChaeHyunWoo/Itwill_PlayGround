package com.day11;

import java.util.Scanner;

//인터페이스 - 다중 상속이 가능하다.
interface FruitA {
	
	String Won = "원";
	
	public int getPrice();
	public String getName();
}

interface ItemFruit extends Fruit { //인터페이스가 인터페이스를 상속받을 대는 extends를 쓴다.
	
	public String getItems();
	
}

class Orange implements ItemFruit {

	@Override
	public int getPrice() {
		return 1500;
	}

	@Override
	public String getName() {
		return "오렌지";
	}

	@Override
	public String getItems() {
		return "과일";
	}
	
}

class Apple implements ItemFruit {

	@Override
	public int getPrice() {
		return 2000;
	}

	@Override
	public String getName() {
		return "사과";
	}

	@Override
	public String getItems() {
		return "과일";
	}
	
}
public class Test5 {
	
	//ItemFruit ob = new Orange()
	//ItemFruit ob = new Apple()
	public void packing(ItemFruit ob) {	//아래 packing이 여기로 들어온다,
		
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);
		
	}

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		Test5 t = new Test5();
		
		System.out.print("1.오렌지  2.사과");// 1 or 2
		int n = sc.nextInt();
		//3단계
		if(n==1)
			t.packing(new Orange()); // t의 packing을 호출할건데 
		else if(n==2)
			t.packing(new Apple());
		/*2단계
		ItemFruit ob;
		// ItemFruit ob1 = new Orange(); 아래와 같다.
		//Orange ob1 = new Orange();
		ob = new Orange();
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);
		
		// ItemFruit ob2 = new Orange();
		//Apple ob2 = new Apple();
		ob = new Apple(); //
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);
		*/
		
		/* 1단계
		int a;
		a = 10;
		System.out.println(a); // 10
		
		int b;
		b = 20;
		System.out.println(b); // 20
		*/
		
		int a;
		a = 10;
		System.out.println(a); //10
		
		a = 20;
		System.out.println(a); // 20
	}

}
