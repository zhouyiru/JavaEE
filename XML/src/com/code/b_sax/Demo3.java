package com.code.b_sax;


import java.io.File;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * 使用sax解析把contact.xml文件信息封装成List对象
 * @author APPle
 *
 */
public class Demo3 {
	public static void main(String[] args) throws Exception, SAXException {
		//1)读取contact.xml文件
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		//创建事件处理程序
		MyDefaultHandler3 handler3 = new MyDefaultHandler3();
		//解析xml文件
		parser.parse(new File("./src/contact.xml"), handler3);
		//获取到封装好的List对象
		List<Contact> conList = handler3.getList();
		//打印
		for (Contact contact : conList) {
			System.out.println(contact);
		}
		
		
	}
}
