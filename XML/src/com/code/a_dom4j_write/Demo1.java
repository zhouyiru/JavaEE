package com.code.a_dom4j_write;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * д��һ��xml�ļ�
 * @author APPle
 *
 */
public class Demo1 {
	public static void main(String[] args) throws Exception {
		
		/**
		 * �޸�xml��Ϣ�Ĳ���
		 * 1����ȡ��ԭ����xml�ļ���document����
		 * 2������document���󣬸ı�xml��Ϣ��docuement����
		 * 3�����޸ĺ��document����д����xml�ļ��У�����ԭ�����ļ���
		 */
		
		
		Document doc = new SAXReader().read(new File("./src/contact.xml"));
		/**
		 * �����
		 * 	  �ַ�������� 
		 * 		 Writer ->  FileWriter/BufferedWriter
		 * 				������
		 * 					write(char c)�� д��һ���ַ�
		 * 					write(char[] data): д������ַ�
		 * 					write(String str): д��һ���ַ���  
		 * 	  �ֽ������
		 * 		 OutputStream -> FileOutputStream/BufferedOutputStream/ObjectOutputStream
		 * 					write(byte) :д��һ���ֽ�
		 * 					write(byte[] data): д������ֽ�
		 */
		/**
		 * ���ڴ��document����д����Ӳ�̵�xml�ļ�
		 */
		//���������
		OutputStream outStream = new FileOutputStream("e:/contact.xml");
		//1)�����������
		XMLWriter writer = new XMLWriter(outStream);
		//2)д������
		writer.write(doc);
	}
}
