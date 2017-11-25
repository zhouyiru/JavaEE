package com.code.a_dom4j_read;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用dom4j获取xml上的属性信息
 * @author APPle
 *
 */
public class Demo3 {

	public static void main(String[] args) throws Exception {
		//1)创建xml解析器
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/contact.xml"));
		
		/**
		 * 读取属性
		 * 注意：获取属性，必须先得到属性所在的标签
		 */
		Element conElem = doc.getRootElement().element("contact");
		//1.1 在标签上获取属性值(根据属性名称获取对应的属性值)
		String value = conElem.attributeValue("id");
		System.out.println(value);
		/**
		 * 练习： 拿到id=002属性
		 */
		Element conElem2 = (Element)doc.getRootElement().elements().get(1);
		System.out.println(conElem2.attributeValue("id"));
		
		//1.2 根据属性名称获取属性对象
		//拿到标签对象
		conElem = doc.getRootElement().element("contact");
		//拿到属性对象
		Attribute idAttr = conElem.attribute("id");
		//通过属性对象拿到 属性名
		String idName = idAttr.getName();
		//通过属性对象拿到 属性值
		String idValue = idAttr.getValue();
		System.out.println(idName+"="+idValue);
		
		System.out.println("===============");
		
		//1.3 获取标签的所有属性对象
		conElem = doc.getRootElement().element("contact");
		@SuppressWarnings("unchecked")
		List<Attribute> attrList = conElem.attributes();
		for (Attribute attr : attrList) {
			System.out.println(attr.getName()+"="+attr.getValue());
		}
	}

}
