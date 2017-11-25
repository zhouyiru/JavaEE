package com.code.a_xpath;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 	xpath案例- 可以把标准的html当前xml解析
 * @author APPle
 *
 */
public class Demo4 {
	public static void main(String[] args) throws Exception {
		Document doc = new SAXReader().read(new File("./src/personList.html"));
		System.out.println(doc);
		
		//获取title标签文本
		Element titleElem = (Element)doc.selectSingleNode("//title");
		System.out.println(titleElem.getText());
		
		
		//获取table的内容，以下列各式输入:
		/**
		 *  编号  姓名 性别 年龄 地址 电话
		 *  1  xx  xx xx xxx  xx
		 *  2  xx xxx xx  xx xx  
		 */
		//获取tbody中所有的tr
		@SuppressWarnings("unchecked")
		List<Element> trList = (List<Element>)doc.selectNodes("//tbody/tr");
		System.out.println("编号\t姓名\t性别\t年龄\t地址\t\t电话");
		for(Element e:trList){
			//获取td内容
			//((Element)e.elements("td").get(0)).getText();
			String id = e.selectSingleNode("td[1]").getText();
			String name = e.selectSingleNode("td[2]").getText();
			String gender = e.selectSingleNode("td[3]").getText();
			String age = e.selectSingleNode("td[4]").getText();
			String address = e.selectSingleNode("td[5]").getText();
			String phone = e.selectSingleNode("td[6]").getText();
			
			System.out.println(id+"\t"+name+"\t"+gender+"\t"+age+"\t"+address+"\t"+phone);
		}
		
		
		
		
		
	}
}
