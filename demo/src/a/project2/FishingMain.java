package a.project2;

import java.util.Scanner;

public class FishingMain {

	public static void main(String[] args) throws Exception {

		Test t = new Test();
		Thread ob = new Fishing();
		Fishing f = new Fishing();
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		
		
		//���� ȭ��
		t.mainImage();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//�޴�
		while(true) {
			
			do {

				System.out.print("======1. ���� ���� 2. ������ 3. ����=====");
				ch = sc.nextInt();
				switch(ch) {
				case 1: 
					f.input();
						
				break;
				case 2:	f.aquarium();break;
				case 3: f.save();
				
				System.exit(0);
				}
				
				System.out.println("---------------------------------------");
				System.out.println();

			}while(ch<1||ch>3 );
			
		}

	}

}