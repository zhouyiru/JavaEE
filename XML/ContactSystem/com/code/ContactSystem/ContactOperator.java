package com.code.ContactSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.*;

public class ContactOperator {
	
	

	
	
	public void addContact(Contact contact) {
		try {
			//把联系人信息保存到xml文件中去
			/**
			 * <contact id="001">
				<name>张三</name>
				<gender>男</gender>
				<phone>13411112222</phone>
				<email>zs@qq.com</email>
				<address>广州天河</address>
			  </contact>
			 */
			//1)读取原来的xml文件,返回document对象
			Document doc = xmlutil.getDocument();
			
			//2)修改document对象
			Element rootElem = doc.getRootElement();
			//添加标签
			Element conElem = rootElem.addElement("contact");
			//添加属性
			//编号使用UUID算法生成一个随机且唯一的字符串
			conElem.addAttribute("id", UUID.randomUUID().toString());
			//添加子标签
			conElem.addElement("name").setText(contact.getName());
			conElem.addElement("gender").setText(contact.getGender());
			conElem.addElement("phone").setText(contact.getPhone());
			conElem.addElement("email").setText(contact.getEmail());
			conElem.addElement("address").setText(contact.getAddress());
			
			//3)把修改后的document对象写出到原来的xml文件中（覆盖原来的xml）
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
		List<Element> conList = (List<Element>)doc.getRootElement().elements("contact");//找出所有的标签
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


