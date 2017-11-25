package com.code.a_xpath;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 	xpath����- ���԰ѱ�׼��html��ǰxml����
 * @author APPle
 *
 */
public class Demo4 {
	public static void main(String[] args) throws Exception {
		Document doc = new SAXReader().read(new File("./src/personList.html"));
		System.out.println(doc);
		
		//��ȡtitle��ǩ�ı�
		Element titleElem = (Element)doc.selectSingleNode("//title");
		System.out.println(titleElem.getText());
		
		
		//��ȡtable�����ݣ������и�ʽ����:
		/**
		 *  ���  ���� �Ա� ���� ��ַ �绰
		 *  1  xx  xx xx xxx  xx
		 *  2  xx xxx xx  xx xx  
		 */
		//��ȡtbody�����е�tr
		@SuppressWarnings("unchecked")
		List<Element> trList = (List<Element>)doc.selectNodes("//tbody/tr");
		System.out.println("���\t����\t�Ա�\t����\t��ַ\t\t�绰");
		for(Element e:trList){
			//��ȡtd����
			//((Element)e.elements("td").get(0)).getText();
			String id = e.selectSingleNode("td[1]").getText();
			String name = e.selectSingleNode("td[2]").getText();
			String gender = e.selectSingleNode("td[3]").getText();
			String age = e.selectSingleNode("td[4]").getText();
			String address = e.selectSingleNode("td[5]").getText();
			String phone = e.selectSingleNode("td[6]").getText();
			
			System.out.println(id+"\t"+name+"\t"+gender+"\t"+age+"\t"+address+"\t"+phone);
		}
		
		
		
		
		
	}
}
