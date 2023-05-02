package com.day15;
//Thread(������)- Ŭ������ Thread�� ����� ���

// �Ϲ� Ŭ�����ε� �� Ŭ������ Thread�� ����� �־��ٰŴ�.
// Thread�� ��� �޴´�. 
class MyThread1 extends Thread { // �θ𲨴� ������.(�ڽ��� �θ� ��� ����)
	
	private int num;
	private String name;
	
	//�����ڸ� ����Ͽ� �ʱ�ȭ
	public MyThread1(int num, String name) {
		
		this.num = num;
		this.name = name;
	}
	
	
	//Thread�� �ݵ�� run�� �ʿ� - ������ ������ �ҽ� - �������̵� - run()����
	
	@Override
	public void run() {	//(4) t1�� ���� �ͼ� �����带 ����(Thread-0)����. 99���� ��� (6) t2�� �ö�ͼ� ������ ����
		
		//������ �޼���(java�� VM�� ȣ��) - ������ ȣ���ϴ� �Ǿƴϰ� start ��ɾ ����� star��ɾ�� main������ ��
		int i=0;
		
		while(i<num) {
			System.out.println(this.getName() + ":" + name + i); // getName : �������� �̸��� ������
			i++;
			
			
			// try catch�� ��� �����ư��鼭 ��Ƽ�½����� ��. �Ⱦ��� ���� �ּ� ó�� ������.(t1������ t2)
			// ������1�� 0.01�� ���µ���  ������2�� ����ȴ�.������2�� ���µ��� ������1 �� ����.
			try {
				sleep(100); // 0.01�� ���� ��� �� - ������� sleep�� �ݵ�� �ʿ��ϴ�.�ʼ�!!!!!
				
			} catch (Exception e) {
				
			}
		}
		
		
	}
	
	
	
	
	
}


public class Test1 {
						//main���� ������� - main������
	public static void main(String[] args) {
		
		System.out.println("main ����...");// ������� 1
		
		MyThread1 t1 = new MyThread1(100, "ù��° : ");// ������� 2
		MyThread1 t2 = new MyThread1(200, "�ι�° : ");// ������� 2
		
		//������� ������ٰ� �����°� �ƴϰ� start�� �������
		t1.start();// �������3 ���� �ö󰣴�
		t2.start();// �������5 ���� �ö󰣴�
		
		
		System.out.println("main ����...");

	}

}
