package com.code.a_dom4j_read;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用dom4j读取xml的标签
 *      getRootElement(): 获取根标签
 *      getName(): 获取标签名称
 *      element("名称")： 获取第一个指定名称的子标签
 *      elements("名称"): 获取指定名称的所有的子标签
 *      elements(): 获取所有子标签
 * 
 * @author APPle
 *
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		//1)创建xml解析器对象
		SAXReader reader = new SAXReader(); // ctrl+2 放手  +l
		//2)读取xml文件
		Document doc = reader.read(new File("./src/contact.xml"));
		
		/**
		 * 读取标签
		 */
		//1.1 读取根标签
		Element rootElem = doc.getRootElement();
		System.out.println(rootElem);
		//1.2 获取标签名称
		System.out.println(rootElem.getName());
		
		//1.3 获取第一个子标签(根据指定的名称获取第一个子标签)
		Element conElem = rootElem.element("contact");
		System.out.println(conElem);
		
		System.out.println("==============");
		//1.4 获取所有子标签（根据指定的名称获取所有同名子标签）
		@SuppressWarnings("unchecked")
		List<Element> list = rootElem.elements("contact");
		//遍历List
		//几种方式?
		//1)传统for循环
		/*for(int i=0;i<list.size();i++){
			list.get(i); //根据角标获取指定对象
		}*/
		
		//2)for-each循环
		for(Element e: list){
			System.out.println(e);
		}
		
		//3)迭代器
		/*Iterator it = list.iterator();
		while(it.hasNext()){ //hasNext(): 判断是否有下一个元素
			it.next(); //next():取出当前对象
		}*/
		
		System.out.println("================");
		
		//1.4 获取所有子标签（不指定名称）
		@SuppressWarnings("unchecked")
		List<Element> eList = rootElem.elements();
		for(Element e:eList){
			System.out.println(e);
		}
		System.out.println("===========");
		
		/**
		 * 注意，如果需要获取孙标签，首先得拿到子标签，再从子标签来获取孙标签！！！
		 */
		Element nameElem  = rootElem.element("contact").element("name");
		System.out.println(nameElem);
		
		
		
	}
}
