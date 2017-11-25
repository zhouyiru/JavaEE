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
 * xpath����
 * @author APPle
 *
 */
public class Demo1 {

	
	public static void main(String[] args) throws Exception {
		/**
		 * ���� ɾ��contact.xml��id����ֵΪ002��contact��ǩ
		 */
		//1)��ȡcontact.xml�ļ�
		Document doc = new SAXReader().read(new File("e:/contact.xml"));
		
		//2)ɾ��id=002��contact��ǩ
		/*List<Element> conList = doc.getRootElement().elements("contact");
		for(Element e:conList){
			if(e.attributeValue("id").equals("002")){
				//ɾ��
				e.detach();
				break;
			}
		}*/
		
		//��ѯ��id����ֵΪ002��contact��ǩ
		Element conElem = (Element)doc.selectSingleNode("//contact[@id='002']");
		conElem.detach();
		
		
		//3)���޸ĺ��documentд����Ӳ�̵�xml�ļ���
		OutputStream out = new FileOutputStream("e:/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		//�ر�
		writer.close();
	}

}
