package com.code.ContactSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.*;

public class ContactOperator {
	
	

	
	
	public void addContact(Contact contact) {
		try {
			//����ϵ����Ϣ���浽xml�ļ���ȥ
			/**
			 * <contact id="001">
				<name>����</name>
				<gender>��</gender>
				<phone>13411112222</phone>
				<email>zs@qq.com</email>
				<address>�������</address>
			  </contact>
			 */
			//1)��ȡԭ����xml�ļ�,����document����
			Document doc = xmlutil.getDocument();
			
			//2)�޸�document����
			Element rootElem = doc.getRootElement();
			//��ӱ�ǩ
			Element conElem = rootElem.addElement("contact");
			//�������
			//���ʹ��UUID�㷨����һ�������Ψһ���ַ���
			conElem.addAttribute("id", UUID.randomUUID().toString());
			//����ӱ�ǩ
			conElem.addElement("name").setText(contact.getName());
			conElem.addElement("gender").setText(contact.getGender());
			conElem.addElement("phone").setText(contact.getPhone());
			conElem.addElement("email").setText(contact.getEmail());
			conElem.addElement("address").setText(contact.getAddress());
			
			//3)���޸ĺ��document����д����ԭ����xml�ļ��У�����ԭ����xml��
			xmlutil.writeXML(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
       


	public void updateContact(Contact contact){
		try {
			Document doc = xmlutil.getDocument();
			Element conElem = (Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
			conElem.element("name").setText(contact.getName());
			conElem.element("gender").setText(contact.getGender());
			conElem.element("phone").setText(contact.getPhone());
			conElem.element("email").setText(contact.getEmail());
			conElem.element("address").setText(contact.getAddress());
			xmlutil.writeXML(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteContact(String id){
		Document doc = xmlutil.getDocument();
		Element conElem = (Element)doc.selectSingleNode("//contact[@id='"+id+"']");
		conElem.detach();
		xmlutil.writeXML(doc);
	}

	public List<Contact> findAll(){
		Document doc = xmlutil.getDocument();
		@SuppressWarnings("unchecked")
		List<Element> conList = (List<Element>)doc.getRootElement().elements("contact");//�ҳ����еı�ǩ
		List<Contact> list = new ArrayList<Contact>();
		for (Element conElem : conList) {
			Contact contact = new Contact();
			contact.setId(conElem.attributeValue("id"));
			contact.setName(conElem.elementText("name"));
			contact.setGender(conElem.elementText("gender"));
			contact.setPhone(conElem.elementText("phone"));
			contact.setEmail(conElem.elementText("email"));
			contact.setAddress(conElem.elementText("address"));
			list.add(contact);
		}
		return list;
	}
	
	
}


