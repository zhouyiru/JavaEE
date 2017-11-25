package com.code.a_dom4j_read;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用dom4j把xml文件的信息封装成对象
 * @author APPle
 *
 */
public class Demo5 {

	public static void main(String[] args) throws Exception {
		//目标： contact.xml信息 -> List集合
		//1）读取xml文件
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/contact.xml"));
		
		//2)创建List对象
		List<Contact> list = new ArrayList<Contact>(); // List接口-》 ArrayList/LinkedList/Vector
		
		
		//3)把xml信息->list对象
		//3.1 读取到所有contact标签
		@SuppressWarnings("unchecked")
		List<Element> conList = doc.getRootElement().elements("contact");
		for (Element elem : conList) {
			//3.2 创建Contact对象
			Contact con = new Contact();
			
			//3.3 把contact标签数据放入contact对象中
			con.setId(elem.attributeValue("id"));
			con.setName(elem.elementText("name"));
			con.setGender(elem.elementText("gender"));
			con.setPhone(elem.elementText("phone"));
			con.setEmail(elem.elementText("email"));
			con.setAddress(elem.elementText("address"));
			
			//3.4 把contact对象放入list对象
			//保存数据   list.add(对象)
			list.add(con);
		}
		
		//4)输出
		for (Contact con : list) {
			System.out.println(con);
		}
	}
}
