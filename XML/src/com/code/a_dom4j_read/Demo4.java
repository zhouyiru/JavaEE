package com.code.a_dom4j_read;

import java.io.File;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��dom4j��ȡxml���ı���Ϣ
 * @author APPle
 *
 */
public class Demo4 {
	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/contact.xml"));
		
		/**
		 * ע�⣺
		 *     ��xml�ļ��У��ո�ͻ��л���Ϊxml�����ݱ���������
		 *     xml�пո�ͻ��к�java�����пո��в�һ����
		 *     java�����еĿո�ͻ�����û����ģ�Ϊ�˴���ĸ�ʽ��ʽ�ÿ����ѡ�
		 */
		Element con = doc.getRootElement().element("contact");
		System.out.println(con.getText());
		
		
		/**
		 * ��ȡ�ı���
		 * 	ע�⣺ ��ȡ�ı���Ҫ�Ȼ�ȡ�ı����ڵı�ǩ����
		 */
		//1.1 �õ����ڱ�ǩ�ϵ��ı�����
		Element nameElem = doc.getRootElement().
						element("contact").element("name");
		String content = nameElem.getText();
		System.out.println(content);
		
		
		//1.2 ͨ������ǩ��ȡָ���ӱ�ǩ���ı�����
		Element conElem = doc.getRootElement().element("contact");
	    content = conElem.elementText("gender");
	    System.out.println(content);
	}
}
