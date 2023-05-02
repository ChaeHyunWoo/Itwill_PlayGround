package com.day16;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Hashtable;
import java.util.Iterator;

public class Test16 {

	public static void main(String[] args) throws Exception {
		
		//역 직렬화 
		
		FileInputStream fis = new FileInputStream("c:\\doc\\out.txt");
		//이 파일을 fis가 열기만 해주고
		ObjectInputStream ois = new ObjectInputStream(fis);
		//ois가 읽어준다.
		
		//원래의 데이터 타입은 해쉬테이블이였다.
		Hashtable<String, String> h = (Hashtable<String, String>)ois.readObject(); // 근처에 object가 있으면 upcast
		
		//꺼낸 데이터가 오브젝트가 형변환으로 해쉬태이블로 변경해준다.
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