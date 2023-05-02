package com.day16;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Map;

//객체의 직렬화
//메모리에 생성된 클래스 객체의 인스턴스변수의 현재 상태를
//그대로 파일에 저장하거나 네트워크를 통해서 전달 할 수있는 기능
//오로지 바이트 단위로만 데이터를 송수신 할 수 있다.

//장점은 객체의 내용을 입출력 형식에 구애 받지 않고 객체를 파일에 저장함으로써
//영속성을 제공할 수 있고, 객체 자체를 네트워크를 통해 손쉽게 교환할 수 있게 된다.

//implements Serializable
// 메서드가 없다.

public class Test15 {

	public static void main(String[] args) throws Exception {
		
		// Hashtable이 Map하고 Serializable를 이미 구현해놓음
		Map<String, String> h = new Hashtable<>();
		
		h.put("1", "배수지");
		h.put("2", "유인나");
		h.put("3", "정인성");
		
		//직렬화 된 데이터를 저장
		FileOutputStream fos = new FileOutputStream("c:\\doc\\out.txt");
		//ObjectOutputStream으로 감싸서 
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//ObjectOutputStream : 메모리상에 올라온 것을 저장하는것 - writeObject까지 해줘야 저장이 된다.
		//FileOutputStream :  메모리상에 올리는거
		oos.writeObject(h);
		oos.close();
		oos.close();
		
		System.out.println("직렬화 데이터 저장 성공!!");
		
	}

}