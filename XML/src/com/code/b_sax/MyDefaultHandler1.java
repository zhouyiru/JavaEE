package com.code.b_sax;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * sax�����¼���������������¼��ļ�������
 * @author APPle
 *
 */
public class MyDefaultHandler1 extends DefaultHandler{
	
	/**
	 * ����xml�ĵ��Ŀ�ʼλ�ô����˷���
	 */
	@Override
	public void startDocument() throws SAXException {
		System.out.println("MyDefaultHandler1.startDocument()");
	}
	
	

	/**
	 * ����ÿ����ʼ��ǩ�����η���
	 * @param qName: ��ʾ��ǰ�����Ŀ�ʼ��ǩ����
	 * @param attributes : �����б�
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("MyDefaultHandler1.startElement()->"+qName);
	}
	
	/**
	 * ����ÿ��������ǩʱ�����˷���
	 * @param qName: ��ǰ�����Ľ�����ǩ����
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("MyDefaultHandler1.endElement()->"+qName);
	}
	
	/**
	 * �����ı����ݴ����˷���
	 * ��λ�ȡ��ǰ���������ݣ�
	 *   char[]: ��ʾ��ĿǰΪֹ�������ı�����
	 *   start: ��ʾ��ǰ���ݵ���ʼλ��
	 * 	 length: ��ʾ��ǰ���ݵĳ���
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		/**
		 * char[]���ݣ�              ����               ��                 1341111122222
		 */               
		//��ȡ��ǰ����������
		String content = new String(ch,start,length);
		System.out.println("MyDefaultHandler1.characters()->"+content);
	}
	
	
	/**
	 * ����xml�ĵ� �Ľ�β
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("MyDefaultHandler1.endDocument()");
	}

	
}
