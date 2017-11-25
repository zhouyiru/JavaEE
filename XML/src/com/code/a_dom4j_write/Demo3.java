package com.code.a_dom4j_write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 修改xml文件：
 * 		添加： 文档   标签   属性   
 * 		修改： 属性值，文本内容
 * 		删除： 标签  属性 
 * @author APPle
 *
 */
public class Demo3 {
	public static void main(String[] args) throws  Exception {
		//add();		
		
		//edit();
		
		
		Document doc = new SAXReader().read(new File("./src/contact.xml"));
		/**
		 * 删除
		 */
		/*//1.1 删除标签
		Element conElem = doc.getRootElement().element("contact");
		//conElem.detach(); //自杀
		conElem.getParent().remove(conElem); //他杀
*/		

		//1.2 删除属性
		Attribute idAttr = doc.getRootElement().element("contact").attribute("id");
		idAttr.detach();
		
		
		//1.2 把文档写出到xml文件中
		OutputStream out = new FileOutputStream("e:/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
	}

	@SuppressWarnings("unused")
	private static void edit() throws DocumentException, FileNotFoundException,	UnsupportedEncodingException, IOException {
		Document doc = new SAXReader().read(new File("./src/contact.xml"));
		/**
		 * 修改
		 */
		//修改属性
		//1.1 先得到属性对象，再调用方法修改属性值
		/*Element conElem = doc.getRootElement().element("contact");
		Attribute idAttr = conElem.attribute("id");
		idAttr.setValue("003");*/
		
		
		//1.2 在标签中添加同名的属性，覆盖属性值
		Element conElem = doc.getRootElement().element("contact");
		conElem.addAttribute("id", "004");
		
		//修改文本
		Element nameElem = doc.getRootElement().element("contact").element("name");
		nameElem.setText("王五");

		
		//1.2 把文档写出到xml文件中
		OutputStream out = new FileOutputStream("e:/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
	}

	/**
	 * 添加
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private static void add() throws FileNotFoundException,UnsupportedEncodingException, IOException {
		/**
		 * 添加
		 */
		//1.1 添加空文档
		Document doc = DocumentHelper.createDocument();
		
		//1.2 添加标签
		Element conListElem = doc.addElement("contact-list");
		//doc.addElement("contact-list"); //不能添加两个根标签！！！

		Element conElem = conListElem.addElement("contact");
		conElem.addElement("name");
		
		//1.3 添加属性
		conElem.addAttribute("id", "001");
		conElem.addAttribute("name","eric");
		
		//1.2 把文档写出到xml文件中
		OutputStream out = new FileOutputStream("e:/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
	}
}
