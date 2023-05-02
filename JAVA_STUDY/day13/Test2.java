package com.day13;

import java.util.Hashtable;
import java.util.Iterator;

//Map(I) - Hashtable(C), HashMap(C)
//Hashtable : Vector�� ����
//HashMap : ArrayList�� ����

//Map<key, value>
//Ű�� �ߺ����� ������ ����.(key:Set)
//Ű�� �ߺ��Ǹ� ������ ���� ����ȴ�.(����)
//Map�� Iterator�� ����.
//put(Ű, ��) : �߰�
//get(Ű, ��) : �б�
public class Test2 {
	
	//key
	public static final String[] tel = { "11-111", "222-222", "333-333", "1111-111", "444-444"};
	
	//value
	public static final String[] name = {"�����", "���γ�", "���μ�", "��������", "���ξ�"};

	public static void main(String[] args) {
		
		//������ Ÿ���� �� String�̶� Ȯ�ΰ����ϴ�
		Hashtable<String, String> h = new Hashtable<>();
		
		for(int i=0; i<name.length; i++) {
			h.put(tel[i], name[i]);
		}
		
		System.out.println(h);
		
		String str;
		
		//key�� �ָ� value�� �����´�
		str = h.get("111-111");
		
		
		if(str==null || str.equals("")) { //if(str==null)
			System.out.println("�ڷ����!");
		} else {
			System.out.println(str);
		}
		
		//���� �����ϴ��� �˻�
		if(h.containsKey("222-222")) {
			System.out.println("222-222�� ����");
		}
		
		//���� �����ϴ��� �˻�
		if(h.containsKey("���γ�")) {
			System.out.println("���γ� ���� �־��~");
		
		}
		
		
		//����
		h.remove("222-222");
		if(h.containsKey("222-222")) {
			System.out.println("222-222�� ����");
		} else {
			System.out.println("222-222�� ����x ");
		}
		
		//Map�� key�ڷ����� set�̴�
		Iterator<String> it = h.keySet().iterator();
		while(it.hasNext()) {
			
			String key = it.next(); //key�� ����
			String value = h.get(key); // value�� ���� - key�� value���� �ָ� ���� �о�´�.
			
			System.out.println(key + ":" + value);
		}

	}
}