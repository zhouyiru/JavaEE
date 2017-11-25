package com.code.b_sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * sax事件处理程序
 * @author APPle
 *
 */
public class MyDefaultHandler2 extends DefaultHandler{
	//存储contact.xml文件信息
	//当contact.xml读取完毕之后，这个变量就有了所有xml文件信息
	private StringBuffer sb = new StringBuffer();
	
	public String getContent(){
		return sb.toString();
	}
	
	//开始标签
	/**
	 * qName:开始标签的名称
	 * attributes： 属性列表
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		sb.append("<"+qName);
		//属性列表
		if(attributes!=null){
			//遍历属性
			for(int i=0;i<attributes.getLength();i++){
				String name = attributes.getQName(i);//属性名称
				String value = attributes.getValue(i);//属性值
				sb.append(" "+name+"=\""+value+"\"");
			}
		}
		sb.append(">");
	}
	
	//文本内容
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//当前文本内容
		String content = new String(ch,start,length);
		sb.append(content);
	}
	
	//结束标签
	//qName: 结束标签名称
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		sb.append("</"+qName+">");
	}
}
