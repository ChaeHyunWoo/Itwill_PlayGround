package com.day11;

interface Test {
	
	public int total();
	public void write();
	
}

class TestImpl implements Test { //�������̽�
	
	private String hak, name;
	private int kor, eng;
	
	public TestImpl() { // �⺻ ������ - �⺻�����ڴ� �ڵ��� ����.
		//�⺻�����ڸ� ���� �޼ҵ带 ���� �ʱ�ȭ �ϴ� ���
	}
	
	public TestImpl(String hak, String name, int kor, int eng) { // �����ε��� ������
		//�����ε��� �����ڸ� ���� �����ڸ��� �ʱ�ȭ
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		
	}
	
	public void set(String hak, String name, int kor, int eng) {
		//�⺻�����ڸ� ���� �޼ҵ带 ���� �ʱ�ȭ �ϴ� ���
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
 
	@Override
	public int total() {
		return kor + eng;
	}

	@Override
	public void write() {
		
		System.out.println(hak + "," + name + "," + total());
	}
	
	@Override // �޼��� �̸��� �Ἥ ����� override�� ���� �Ƚᵵ �ȴ�.
	public boolean equals(Object ob) {	// ob1.equals(ob2), TestImpl // Object�� equals�� override�Ѵ�. �̷��� 
						//Object ob = ob2 -> upcast (upcast �ֺ����� Object�� �ִ�.)
		boolean flag = false;
		
		if(ob instanceof TestImpl) { //instanceof������
			
			TestImpl t = (TestImpl)ob; // downcast
			
			// - Upcast : ��Ӱ��迡�� �ڽ�Ŭ������ ��ü�� �θ�Ŭ������ ����ȯ

			// - Downcast : ��Ӱ��迡�� �θ�Ŭ������ ��ü�� �ڽ�Ŭ������ ����ȯ
			
			if(this.hak.equals(t.hak) && t.name.equals(this.name)) {
				flag = true;			
			}
		}
		
		return flag;
	}
	
	
}
public class Test4 {

	public static void main(String[] args) {
		
		// TestImpl ��� Test�� �ᵵ�ȴ�. why? �θ���� or �������̽� �����̱� ����
		// TestImpl ob1 = new TestImpl("111", "�����", 80, 90);
		Test ob1 = new TestImpl("111", "�����", 80, 90);
		TestImpl ob2 = new TestImpl("111", "�����", 100, 100);
		
		if(ob1.equals(ob2)) {
			System.out.println("ob1�� ob2�� �����ι�!");
		} else {
			System.out.println("ob1�� ob2�� �����ι� x ");
		}
		
		ob1.write();
		ob2.write();
	}

}
