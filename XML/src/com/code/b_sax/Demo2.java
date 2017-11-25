package com.code.b_sax;


import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * ʹ��sax������ʽ��ȡcontact.xml�ļ����ݣ�ԭ�ⲻ����ӡ�ļ���Ϣ
 * @author APPle
 *
 */
public class Demo2 {

	public static void main(String[] args) throws Exception, SAXException {
		//1)����SAXParser����
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		
		//�����¼��������
		MyDefaultHandler2 handler2 = new MyDefaultHandler2();
		
		//2)��ȡxml�ļ�
		parser.parse(new File("./src/contact.xml"), handler2);
		
		System.out.println(handler2.getContent());
	}
}

