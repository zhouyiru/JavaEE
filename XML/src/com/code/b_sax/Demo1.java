package com.code.b_sax;


import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * sax��������
 * @author APPle
 *
 */
public class Demo1 {

		public static void main(String[] args) throws Exception, SAXException {
			//1)����SAXParser��������
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			
			//2)����xml�ļ�
			/**
			 * ����һ�� ��Ҫ������xml�ļ�
			 * �������� ָ����DefaultHandler
			 */
			/**
			 * �¼����ģʽ��Ҫ��
			 *   �¼�Դ��xml�ļ� 
			 *   �¼�����������ʼ��ǩ���������ԣ���������������ǩ�������ı�����
			 *   ��������DefaultHandler
			 */
			//������ע�������
			parser.parse(new File("./src/contact.xml"), new MyDefaultHandler1());
			
		}
}
