package com.code.a_dom4j_read;

import java.io.File;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用dom4j获取xml的文本信息
 * @author APPle
 *
 */
public class Demo4 {
	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/contact.xml"));
		
		/**
		 * 注意：
		 *     在xml文件中，空格和换行会作为xml的内容被解析到。
		 *     xml中空格和换行和java代码中空格换行不一样。
		 *     java代码中的空格和换行是没意义的，为了代码的格式格式好看而已。
		 */
		Element con = doc.getRootElement().element("contact");
		System.out.println(con.getText());
		
		
		/**
		 * 读取文本：
		 * 	注意： 获取文本，要先获取文本所在的标签对象
		 */
		//1.1 拿到所在标签上的文本内容
		Element nameElem = doc.getRootElement().
						element("contact").element("name");
		String content = nameElem.getText();
		System.out.println(content);
		
		
		//1.2 通过父标签获取指定子标签的文本内容
		Element conElem = doc.getRootElement().element("contact");
	    content = conElem.elementText("gender");
	    System.out.println(content);
	}
}
