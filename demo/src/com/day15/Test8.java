package com.day15;

// 스레드 동기화

class MyThread8 implements Runnable {
	
	private int bank = 10000; // 잔액
	
	//잔액을 보여주는 getBank()
	private int getBank() { 
		return bank;
	}
	
	//출금 drawMoney
	private int drawMoney(int m) {
		bank -= m; // bank = bank - m;
		return m; // 인출 금액
	}

	@Override
	public void run() {
		
		int moneyNeed = 6000; // 인출할 금액
		int money;
		String msg = "";
		
		try {
			
			// 동기화 블럭
			synchronized (this) {
				
			if(getBank() >= moneyNeed) {
				
				money = drawMoney(moneyNeed);
				msg = "인출 성공!!";
				
			} else {
				money = 0;
				msg = "인출 실패!!거지냐?";
				}
			}
			System.out.println(Thread.currentThread().getName() + msg + ", 인출금액:" + money + ",잔고:" + getBank());
			
			
		} catch (Exception e) {
			
		}
	}
}
public class Test8 {

	public static void main(String[] args) {
		
		MyThread8 ob = new MyThread8(); //객체 생성 - 여기서 시작
		
		
		//Thread t1 = new Thread(new MyThread5());
		//Thread t2 = new Thread(new MyThread5());  아래랑 다르다. 여긴 각자 만들어서 사용하고 아래는 ob를 공유
		Thread t1 = new Thread(ob);				
		Thread t2 = new Thread(ob);	// ex ) t1로 ob에서 3천원빼고 t2로 ob에서 4천원빼기
		
		t1.start();
		t2.start();
		

	}

}
