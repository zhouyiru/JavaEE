package com.code.b_sax;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * sax解析事件处理程序（类似于事件的监听器）
 * @author APPle
 *
 */
public class MyDefaultHandler1 extends DefaultHandler{
	
	/**
	 * 遇到xml文档的开始位置触发此方法
	 */
	@Override
	public void startDocument() throws SAXException {
		System.out.println("MyDefaultHandler1.startDocument()");
	}
	
	

	/**
	 * 遇到每个开始标签触发次方法
	 * @param qName: 表示当前读到的开始标签名称
	 * @param attributes : 属性列表
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("MyDefaultHandler1.startElement()->"+qName);
	}
	
	/**
	 * 遇到每个结束标签时触发此方法
	 * @param qName: 当前读到的结束标签名称
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("MyDefaultHandler1.endElement()->"+qName);
	}
	
	/**
	 * 遇到文本内容触发此方法
	 * 如何获取当前读到的内容？
	 *   char[]: 表示到目前为止读到的文本内容
	 *   start: 表示当前内容的起始位置
	 * 	 length: 表示当前内容的长度
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		/**
		 * char[]内容：              张三               男                 1341111122222
		 */               
		//获取当前读到的内容
		String content = new String(ch,start,length);
		System.out.println("MyDefaultHandler1.characters()->"+content);
	}
	
	
	/**
	 * 遇到xml文档 的结尾
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("MyDefaultHandler1.endDocument()");
	}

	
}
