package com.code.b_sax;


import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * sax解析入门
 * @author APPle
 *
 */
public class Demo1 {

		public static void main(String[] args) throws Exception, SAXException {
			//1)创建SAXParser解析对象
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			
			//2)解析xml文件
			/**
			 * 参数一： 需要解析的xml文件
			 * 参数二： 指定的DefaultHandler
			 */
			/**
			 * 事件编程模式三要求：
			 *   事件源：xml文件 
			 *   事件：解析到开始标签（包含属性），解析到结束标签，解析文本内容
			 *   监听器：DefaultHandler
			 */
			//类似于注册监听器
			parser.parse(new File("./src/contact.xml"), new MyDefaultHandler1());
			
		}
}
