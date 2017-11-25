package com.code.a_xpath;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/**
 * xpath入门
 * @author APPle
 *
 */
public class Demo1 {

	
	public static void main(String[] args) throws Exception {
		/**
		 * 需求： 删除contact.xml中id属性值为002的contact标签
		 */
		//1)读取contact.xml文件
		Document doc = new SAXReader().read(new File("e:/contact.xml"));
		
		//2)删除id=002的contact标签
		/*List<Element> conList = doc.getRootElement().elements("contact");
		for(Element e:conList){
			if(e.attributeValue("id").equals("002")){
				//删除
				e.detach();
				break;
			}
		}*/
		
		//查询到id属性值为002的contact标签
		Element conElem = (Element)doc.selectSingleNode("//contact[@id='002']");
		conElem.detach();
		
		
		//3)把修改后的document写出到硬盘的xml文件中
		OutputStream out = new FileOutputStream("e:/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		//关闭
		writer.close();
	}

}
