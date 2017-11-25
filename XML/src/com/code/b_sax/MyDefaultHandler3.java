package com.code.b_sax;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * sax事件处理程序
 * @author APPle
 *
 */
public class MyDefaultHandler3 extends DefaultHandler{
	//用于存储所有Contact对象信息
	private List<Contact> conList = new ArrayList<Contact>();
	//用于存储一个contact标签中的信息 
	private Contact contact = null;
	//返回封装好的List对象
	public List<Contact> getList(){
		return conList;
	}
	
	//用于记录当前标签是哪个
	private String curTag;
	
	/**
	 * 思路：
	 * 	1）创建一个新的Contact对象，用于封装contact标签信息
	 *  2) 把当前读到的这个contact标签的信息封装到Contact对象中
	 *  3）把封装好的Contact对象放入List中
	 */
	
	//开始标签
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//1)在读到contact的开始标签时创建Contact对象
		if(qName.equals("contact")){
			//创建Contact对象
			contact = new Contact();
			//封装id属性
			String id = attributes.getValue("id");
			contact.setId(id);
		}
	}
	//文本内容(注意：包含换行和空格)
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//2)把contact子标签中的文本内容封装到Contact对象中
		String content = new String(ch,start,length);
		
		//如果当前标签是name
		if("name".equals(curTag)){
			contact.setName(content);
		}
		//如果当前标签是phone
		if("phone".equals(curTag)){
			contact.setPhone(content);
		}
		//如果当前标签是email
		if("email".equals(curTag)){
			contact.setEmail(content);
		}
		//如果当前标签是address
		if("address".equals(curTag)){
			contact.setAddress(content);
		}
		//如果当前标签是gender
		if("gender".equals(curTag)){
			contact.setGender(content);
		}
		
	}
	//结束标签
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//把curTag置空
		curTag = null;
		//3)在读到contact结束标签时把Contact对象放入List中
		if(qName.equals("contact")){
			conList.add(contact);
		}
	}
	
}
