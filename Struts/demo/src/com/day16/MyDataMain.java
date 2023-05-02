package com.day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyDataMain {

	public static void main(String[] args) throws Exception {
		
		//여기로 데이터를 내보낼거다. - 위에 예외처리 해줘야함
		FileOutputStream fos = new FileOutputStream("c:\\doc\\data.txt");
		
		// 이걸로 감싸준다.
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(new MyDataVO("suzi", 30));
		oos.writeObject(new MyDataVO("inna", 40));
		oos.writeObject(new MyDataVO("insun", 27));
		oos.writeObject(new MyDataVO("jihae", 30));
		oos.writeObject(new MyDataVO("gemma", 32));
		
		oos.close();
		fos.close(); // 직렬화 끝
		
		//역직렬화
		FileInputStream fis = new FileInputStream("c:\\doc\\data.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//밖에 VO를 만든 이유는 출력만 하면 끝이기 때문에 데이터는 VO에 저장되어있고 공용으로 사용하기 위해
		MyDataVO ob = null; // null로 초기화
		
		try {
			
			//메모장에 데이터가 얼마나 있는지 모르기에 while문 무한루프로 돌린다.
			while(true) {
				
				//Object로 되어 있으니 MyDataVO로 형변환 해줌
				ob = (MyDataVO)ois.readObject();
				
				//ob == null은 데이터가 없다. 없으면 break로 빠져나와라
				if(ob == null) {
					break;
				}
				
				System.out.println(ob.toString());
			}
			
			
		} catch (Exception e) {
			
		}
		
		ois.close();
		fis.close();
		

	}

}