package com.day15;

//���ͷ�Ʈ : �켱������ ���� ���α׷��� ���� �����Ű�� ���ƿ� - �˰� �ֱ� ������ ���� ����

class Mythread7 extends Thread {
	
	private Thread next;
	
	public void setNext(Thread next) {
		this.next = next;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<=20; i++) {
			
			try {
				sleep(2000);//2�� ���� ��´�
			} catch (Exception e) {
				
			}
			
			System.out.println(getName() + ":" + i);
			
			if(next.isAlive()) { //���࿡ �ڱ��ڽ��� ��������� �������Ѷ�
				next.interrupt(); // ���� �����带 �������ν� [���� �����带 ����] - ���罺���尡 ��������� ������Ų��
			}
		}
	}
}

public class Test7 {
	
	public static void main(String[] args) {
		
		Mythread7 t1 = new Mythread7();
		Mythread7 t2 = new Mythread7();
		Mythread7 t3 = new Mythread7();
		
		t1.setNext(t2); //t1�� ������ t2����
		t2.setNext(t3); // t2�� ���߰� t3�� �����ض�
		t3.setNext(t1); // t3�� ���߰� t1�� �����ض�
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.interrupt();//������� ����ǰԲ� ������ ������ �� �ִ�.
		
		try {
			
			t1.join();
			t2.join();
			t3.join();
			
		} catch (Exception e) {
			
		}
		
	}

}