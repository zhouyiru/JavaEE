package com.code.b_sax;


import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * 使用sax解析方式读取contact.xml文件内容，原封不动打印文件信息
 * @author APPle
 *
 */
public class Demo2 {

	public static void main(String[] args) throws Exception, SAXException {
		//1)创建SAXParser对象
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		
		//创建事件处理程序
		MyDefaultHandler2 handler2 = new MyDefaultHandler2();
		
		//2)读取xml文件
		parser.parse(new File("./src/contact.xml"), handler2);
		
		System.out.println(handler2.getContent());
	}
}

