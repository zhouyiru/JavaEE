package com.code.a_dom4j_write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * �޸�xml�ļ���
 * 		��ӣ� �ĵ�   ��ǩ   ����   
 * 		�޸ģ� ����ֵ���ı�����
 * 		ɾ���� ��ǩ  ���� 
 * @author APPle
 *
 */
public class Demo3 {
	public static void main(String[] args) throws  Exception {
		//add();		
		
		//edit();
		
		
		Document doc = new SAXReader().read(new File("./src/contact.xml"));
		/**
		 * ɾ��
		 */
		/*//1.1 ɾ����ǩ
		Element conElem = doc.getRootElement().element("contact");
		//conElem.detach(); //��ɱ
		conElem.getParent().remove(conElem); //��ɱ
*/		

		//1.2 ɾ������
		Attribute idAttr = doc.getRootElement().element("contact").attribute("id");
		idAttr.detach();
		
		
		//1.2 ���ĵ�д����xml�ļ���
		OutputStream out = new FileOutputStream("e:/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
	}

	@SuppressWarnings("unused")
	private static void edit() throws DocumentException, FileNotFoundException,	UnsupportedEncodingException, IOException {
		Document doc = new SAXReader().read(new File("./src/contact.xml"));
		/**
		 * �޸�
		 */
		//�޸�����
		//1.1 �ȵõ����Զ����ٵ��÷����޸�����ֵ
		/*Element conElem = doc.getRootElement().element("contact");
		Attribute idAttr = conElem.attribute("id");
		idAttr.setValue("003");*/
		
		
		//1.2 �ڱ�ǩ�����ͬ�������ԣ���������ֵ
		Element conElem = doc.getRootElement().element("contact");
		conElem.addAttribute("id", "004");
		
		//�޸��ı�
		Element nameElem = doc.getRootElement().element("contact").element("name");
		nameElem.setText("����");

		
		//1.2 ���ĵ�д����xml�ļ���
		OutputStream out = new FileOutputStream("e:/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
	}

	/**
	 * ���
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private static void add() throws FileNotFoundException,UnsupportedEncodingException, IOException {
		/**
		 * ���
		 */
		//1.1 ��ӿ��ĵ�
		Document doc = DocumentHelper.createDocument();
		
		//1.2 ��ӱ�ǩ
		Element conListElem = doc.addElement("contact-list");
		//doc.addElement("contact-list"); //���������������ǩ������

		Element conElem = conListElem.addElement("contact");
		conElem.addElement("name");
		
		//1.3 �������
		conElem.addAttribute("id", "001");
		conElem.addAttribute("name","eric");
		
		//1.2 ���ĵ�д����xml�ļ���
		OutputStream out = new FileOutputStream("e:/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
	}
}
