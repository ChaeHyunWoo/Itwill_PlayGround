package com.day19;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Test1 {

	public static void main(String[] args) {

		try {
			
			//Dom Document 객체를 생성하기 위해 팩토리 생성.
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = f.newDocumentBuilder();
			
			//Dom parser로 부터 입력받은 파일을 파싱함.
			Document xmlDoc = null;
			
			String url = "book.xml"; //데모에있는 book.xml을 읽어온다.
			
			if(url.indexOf("http://")!=-1) { //없지않으면 ,있으면 이라는뜻 //내pc 외부에있으면 읽어오고
				
				URL u = new URL(url);
				InputStream is = u.openStream();
				xmlDoc = parser.parse(is);
				
			}else {//내 pc 내부에 있으면 읽어와라.
				xmlDoc = parser.parse(url); //parser를 가지고 파싱해서 url을 만들어라.			
			}
			
			//Element : xml문서의 요소를 표현하기 위해 사용한다.
			Element root = xmlDoc.getDocumentElement(); //읽어오기
			
			System.out.println(root.getTagName());
			
			//첫번째 book
			//Node : 각 요소를 읽기위해 사용한다.
			Node book1 = root.getElementsByTagName("book").item(0);
			System.out.println(((Element)book1).getAttribute("kind"));
			
			Node title = book1.getFirstChild();
			//System.out.println(title);
			Node title1 = title.getNextSibling();
			System.out.println(title1.getNodeName());
			Node title1_1 = title1.getFirstChild();
			System.out.println(title1_1.getNodeValue());
		} catch (Exception e) {
			
		}
		
	}

}
