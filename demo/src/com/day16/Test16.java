package com.day16;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Hashtable;
import java.util.Iterator;

public class Test16 {

	public static void main(String[] args) throws Exception {
		
		//�� ����ȭ 
		
		FileInputStream fis = new FileInputStream("c:\\doc\\out.txt");
		//�� ������ fis�� ���⸸ ���ְ�
		ObjectInputStream ois = new ObjectInputStream(fis);
		//ois�� �о��ش�.
		
		//������ ������ Ÿ���� �ؽ����̺��̿���.
		Hashtable<String, String> h = (Hashtable<String, String>)ois.readObject(); // ��ó�� object�� ������ upcast
		
		//���� �����Ͱ� ������Ʈ�� ����ȯ���� �ؽ����̺�� �������ش�.
		Iterator<String> it = h.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = h.get(key);
			
			System.out.println(key + ":" + value);
		}
		
		ois.close();
		fis.close();
		
		

	}

}