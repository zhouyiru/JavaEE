package com.code.b_sax;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * sax�¼��������
 * @author APPle
 *
 */
public class MyDefaultHandler3 extends DefaultHandler{
	//���ڴ洢����Contact������Ϣ
	private List<Contact> conList = new ArrayList<Contact>();
	//���ڴ洢һ��contact��ǩ�е���Ϣ 
	private Contact contact = null;
	//���ط�װ�õ�List����
	public List<Contact> getList(){
		return conList;
	}
	
	//���ڼ�¼��ǰ��ǩ���ĸ�
	private String curTag;
	
	/**
	 * ˼·��
	 * 	1������һ���µ�Contact�������ڷ�װcontact��ǩ��Ϣ
	 *  2) �ѵ�ǰ���������contact��ǩ����Ϣ��װ��Contact������
	 *  3���ѷ�װ�õ�Contact�������List��
	 */
	
	//��ʼ��ǩ
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//1)�ڶ���contact�Ŀ�ʼ��ǩʱ����Contact����
		if(qName.equals("contact")){
			//����Contact����
			contact = new Contact();
			//��װid����
			String id = attributes.getValue("id");
			contact.setId(id);
		}
	}
	//�ı�����(ע�⣺�������кͿո�)
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//2)��contact�ӱ�ǩ�е��ı����ݷ�װ��Contact������
		String content = new String(ch,start,length);
		
		//�����ǰ��ǩ��name
		if("name".equals(curTag)){
			contact.setName(content);
		}
		//�����ǰ��ǩ��phone
		if("phone".equals(curTag)){
			contact.setPhone(content);
		}
		//�����ǰ��ǩ��email
		if("email".equals(curTag)){
			contact.setEmail(content);
		}
		//�����ǰ��ǩ��address
		if("address".equals(curTag)){
			contact.setAddress(content);
		}
		//�����ǰ��ǩ��gender
		if("gender".equals(curTag)){
			contact.setGender(content);
		}
		
	}
	//������ǩ
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//��curTag�ÿ�
		curTag = null;
		//3)�ڶ���contact������ǩʱ��Contact�������List��
		if(qName.equals("contact")){
			conList.add(contact);
		}
	}
	
}
