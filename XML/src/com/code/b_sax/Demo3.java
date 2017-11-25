package com.code.b_sax;


import java.io.File;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * ʹ��sax������contact.xml�ļ���Ϣ��װ��List����
 * @author APPle
 *
 */
public class Demo3 {
	public static void main(String[] args) throws Exception, SAXException {
		//1)��ȡcontact.xml�ļ�
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		//�����¼��������
		MyDefaultHandler3 handler3 = new MyDefaultHandler3();
		//����xml�ļ�
		parser.parse(new File("./src/contact.xml"), handler3);
		//��ȡ����װ�õ�List����
		List<Contact> conList = handler3.getList();
		//��ӡ
		for (Contact contact : conList) {
			System.out.println(contact);
		}
		
		
	}
}
