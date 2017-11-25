package com.code.a_dom4j_read;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��dom4j��xml�ļ�����Ϣ��װ�ɶ���
 * @author APPle
 *
 */
public class Demo5 {

	public static void main(String[] args) throws Exception {
		//Ŀ�꣺ contact.xml��Ϣ -> List����
		//1����ȡxml�ļ�
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/contact.xml"));
		
		//2)����List����
		List<Contact> list = new ArrayList<Contact>(); // List�ӿ�-�� ArrayList/LinkedList/Vector
		
		
		//3)��xml��Ϣ->list����
		//3.1 ��ȡ������contact��ǩ
		@SuppressWarnings("unchecked")
		List<Element> conList = doc.getRootElement().elements("contact");
		for (Element elem : conList) {
			//3.2 ����Contact����
			Contact con = new Contact();
			
			//3.3 ��contact��ǩ���ݷ���contact������
			con.setId(elem.attributeValue("id"));
			con.setName(elem.elementText("name"));
			con.setGender(elem.elementText("gender"));
			con.setPhone(elem.elementText("phone"));
			con.setEmail(elem.elementText("email"));
			con.setAddress(elem.elementText("address"));
			
			//3.4 ��contact�������list����
			//��������   list.add(����)
			list.add(con);
		}
		
		//4)���
		for (Contact con : list) {
			System.out.println(con);
		}
	}
}
