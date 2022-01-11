package com.day15;

// ������ ����ȭ

class MyThread8 implements Runnable {
	
	private int bank = 10000; // �ܾ�
	
	//�ܾ��� �����ִ� getBank()
	private int getBank() { 
		return bank;
	}
	
	//��� drawMoney
	private int drawMoney(int m) {
		bank -= m; // bank = bank - m;
		return m; // ���� �ݾ�
	}

	@Override
	public void run() {
		
		int moneyNeed = 6000; // ������ �ݾ�
		int money;
		String msg = "";
		
		try {
			
			// ����ȭ ��
			synchronized (this) {
				
			if(getBank() >= moneyNeed) {
				
				money = drawMoney(moneyNeed);
				msg = "���� ����!!";
				
			} else {
				money = 0;
				msg = "���� ����!!������?";
				}
			}
			System.out.println(Thread.currentThread().getName() + msg + ", ����ݾ�:" + money + ",�ܰ�:" + getBank());
			
			
		} catch (Exception e) {
			
		}
	}
}
public class Test8 {

	public static void main(String[] args) {
		
		MyThread8 ob = new MyThread8(); //��ü ���� - ���⼭ ����
		
		
		//Thread t1 = new Thread(new MyThread5());
		//Thread t2 = new Thread(new MyThread5());  �Ʒ��� �ٸ���. ���� ���� ���� ����ϰ� �Ʒ��� ob�� ����
		Thread t1 = new Thread(ob);				
		Thread t2 = new Thread(ob);	// ex ) t1�� ob���� 3õ������ t2�� ob���� 4õ������
		
		t1.start();
		t2.start();
		

	}

}
