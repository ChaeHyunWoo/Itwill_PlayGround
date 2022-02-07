package com.score6;
//여기서 나오는 추가수정삭제등 총6개 메서드는 꼭 외우기 엄청 중요함!!!!!
import java.util.Scanner;

//메뉴가 있는곳
public class ScoreMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Score ob = new Score(); //객체생성 - (포함관계)
		
		int ch;
		
		while(true) {
			
			do {
				System.out.print("1.추가 2.수정 3.삭제 4.전체출력 5.이름검색 6.학번검색 7.종료");
				ch = sc.nextInt();//값은 ch로 받을거다.
				
			} while(ch<1||ch>7);
			
			switch(ch) { //메뉴를 누르면 Score 의 insert가 실행되야하니 위에  Score 객체생성해주기
			
			case 1:
				ob.insert();
				break;
			case 2:
				ob.update();
				break;
			case 3:
				ob.delete();
				break;
			case 4:
				ob.selectAll();
				break;
			case 5:
				ob.searchName();
				break;
			case 6:
				ob.searchHak();
				break;
				
			default:
				System.exit(0);
			
			}
		} //여기까지 while(true)
		

	}
}