package com.code.a_dom4j_read;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();//����xml������
		Document doc = reader.read(new File("./src/contact.xml"));//��ȡxml
        System.out.println(doc);
	}

}
