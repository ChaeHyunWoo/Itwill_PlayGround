package com.day11;

import java.util.Scanner;

//�������̽� - ���� ����� �����ϴ�.
interface FruitA {
	
	String Won = "��";
	
	public int getPrice();
	public String getName();
}

interface ItemFruit extends Fruit { //�������̽��� �������̽��� ��ӹ��� ��� extends�� ����.
	
	public String getItems();
	
}

class Orange implements ItemFruit {

	@Override
	public int getPrice() {
		return 1500;
	}

	@Override
	public String getName() {
		return "������";
	}

	@Override
	public String getItems() {
		return "����";
	}
	
}

class Apple implements ItemFruit {

	@Override
	public int getPrice() {
		return 2000;
	}

	@Override
	public String getName() {
		return "���";
	}

	@Override
	public String getItems() {
		return "����";
	}
	
}
public class Test5 {
	
	//ItemFruit ob = new Orange()
	//ItemFruit ob = new Apple()
	public void packing(ItemFruit ob) {	//�Ʒ� packing�� ����� ���´�,
		
		System.out.println(ob.getItems());
		System.out.println(ob.getName());
		System.out.println(ob.getPrice() + FruitA.Won);
		
	}

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		Test5 t = new Test5();
		
		System.out.print("1.������  2.���");// 1 or 2
		int n = sc.nextInt();
		//3�ܰ�
		if(n==1)
			t.packing(new Orange()); // t�� packing�� ȣ���Ұǵ� 
		else if(n==2)
			t.packing(new Apple());
		/*2�ܰ�
		ItemFruit ob;
		// ItemFruit ob1 = new Orange(); �Ʒ��� ����.
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
		
		/* 1�ܰ�
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
