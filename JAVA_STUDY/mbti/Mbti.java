package mbti;

import java.util.Scanner;

public class Mbti {

	int i, j, inwon;
	RecordM[] r;
	Scanner sc = new Scanner(System.in);

	public void set() {

		do {
			System.out.print("�ο���?");// 3
			inwon = sc.nextInt();
		} while (inwon < 1 || inwon > 10);

		r = new RecordM[inwon];

	}

	public void input() {
		
		//String[] a = { "����", "����", "����", "�ν�" }; // =1		0/0 ���� 0/1�� ����
		//String[] b = { "����", "����", "���", "�Ǵ�" }; // =2
		

		for (i = 0; i < inwon; i++) {

			
			r[i] = new RecordM(); //��ü ����
			

			System.out.print("�̸�?");
			r[i].name = sc.next();

			j = 0;
			for (j = 0; j < 4; j++) {
				
				

				//System.out.printf("%s(1)?, %s(2)?", a[j], b[j]);
				System.out.printf("%s(1)?,%s(2)?", r[i].a[j], r[i].b[j]);
				r[i].t[j] = sc.nextInt();

			
			}
		}
	}

	public void print() {

		for (int i = 0; i < inwon; i++) {

			System.out.printf("%6s", r[i].name);

			for (int j = 0; j < 4; j++) {

				if (r[i].t[j] == 1) {
					System.out.printf("%3s",r[i].b[j]);
				} else if (r[i].t[j] == 2) {
					System.out.printf("%3s",r[i].b[j]);
				}
			}
		}
	}
}