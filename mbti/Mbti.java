package mbti;

import java.util.Scanner;

public class Mbti {

	int i, j, inwon;
	RecordM[] r;
	Scanner sc = new Scanner(System.in);

	public void set() {

		do {
			System.out.print("인원수?");// 3
			inwon = sc.nextInt();
		} while (inwon < 1 || inwon > 10);

		r = new RecordM[inwon];

	}

	public void input() {
		
		//String[] a = { "내향", "직관", "감정", "인식" }; // =1		0/0 내향 0/1은 외향
		//String[] b = { "외향", "감각", "사고", "판단" }; // =2
		

		for (i = 0; i < inwon; i++) {

			
			r[i] = new RecordM(); //객체 생성
			

			System.out.print("이름?");
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