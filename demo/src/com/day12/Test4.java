package com.day12;

//4. ����Ŭ����(�͸���, ������, AnonymousŬ����)
public class Test4 {
	
	public Object getTitle() {
		
		return new Object() { 
			
			@Override
			public String toString() {//�������
				return "�͸��� Ŭ����";
			}
		};// �̰� ��ȯ���� �ȴ�. -> �������
	}

	public static void main(String[] args) {
		
		Test4 ob = new Test4();
			
			Object str = ob.getTitle();//Object�� �޾Ƽ� ��´�.
			
			System.out.println(str);
					
	}

}