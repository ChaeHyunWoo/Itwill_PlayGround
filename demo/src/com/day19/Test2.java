package com.day19;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test2 {

	public static void main(String[] args) {

		try {
			
			//Dom Document 객체를 생성하기위해 팩토리 생성
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = f.newDocumentBuilder();
			
			//Dom 파서로부터 입력받은 파일을 파싱함
			Document xmlDoc = null;
			
			String url = "book.xml";
			
			if(url.indexOf("http://")!=-1) {
				
				URL u = new URL(url);
				InputStream is = u.openStream();
				xmlDoc = parser.parse(is);				
				
			}else {
				xmlDoc = parser.parse(url);
			}
			
			Element root = xmlDoc.getDocumentElement();
			NodeList books = root.getElementsByTagName("book");
			
			String out = "";
			String str;
			
			for(int i=0;i<books.getLength();i++) {
				
				Node book = books.item(i);
				str = book.getNodeName();
				
				out += "노드명: " + str;
				
				NamedNodeMap bookMap = book.getAttributes();
				str = bookMap.getNamedItem("kind").getNodeValue();
				
				out += ", kind: " + str;
				
				NodeList elementList = book.getChildNodes();
				
				for(int j=0;j<elementList.getLength();j++) {
					
					Node e = elementList.item(j);
					str = "";
					if(e.getNodeType()==Node.ELEMENT_NODE) {
						str = ", " + e.getNodeName();
						out += str + ":";
						out += e.getChildNodes().item(0).getNodeValue();
					}
					
				}
				out += "\n";
				
			}
			
			System.out.println(out);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}