package com.code.a_xpath;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * 			/   绝对路径    斜杠在最前面，代表xml文件的根。斜杠在中间，表示子元素。
			//  相对路径    选择后代元素（不分层次结构）
			*   通配			选择所有元素
			[ ]   条件        选择什么条件下的元素。例如 /AAA/BBB[1] 选择第一个BBB子元素
			@   属性         选取属性
			=    内容 （值）  

 * @author APPle
 *
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		//1）读取xml文件
		Document doc = new SAXReader().read(new File("./src/contact.xml"));
		
		//2)利用xpath方法查询xml文件
		String xpath = "";
		
		//2.1    / 
		xpath = "/contact-list"; //根标签contact-list
		xpath = "/contact-list/contact"; //contact-list根标签下的contact子标签
		
		
		//2.2   // 
		xpath = "//contact"; //选择所有contact标签（不分层次）
		xpath = "//contact/name"; //选择所有父标签是contact的name标签
		
		//2.3   *
		xpath = "/contact-list/*"; //选择根据标签contact-list下的所有子标签
		xpath = "/contact-list//*"; //选择根标签contact-list下的所有后代标签（不分层次结构）
		
		
		//2.4 [ ]
		xpath = "//contact[1]";// 第一个contact标签
		xpath = "//contact[last()]";//最后一个contact标签
		
		//2.5 @ 
		xpath = "//@id"; // 选择所有id属性
		xpath = "//contact[@id]"; //选择所有包含id属性的contact标签
		
		
		//2.6 = 
		xpath = "//contact[@id='002']"; //选择id属性值为002的contact标签
		
		//2.7 and  逻辑与
		//选取id属性为002,且name属性为eric的contact标签
		xpath = "//contact[@id='002' and @name='eric']";
		
		//2.8   text()   选取文本
		xpath = "//contact[@id='001']/name[1]/text()";//选择第一个name标签的文本
		xpath = "//name[text()='陈六']";//文本内容为”陈六“的name标签
		
		
		@SuppressWarnings("unchecked")
	List<Node> list = doc.selectNodes(xpath);
		for (Node node : list) {
			System.out.println(node);
		}
		
		
		
		
		
		
	}
}
