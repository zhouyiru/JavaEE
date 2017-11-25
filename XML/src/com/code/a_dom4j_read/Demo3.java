package com.code.a_dom4j_read;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��dom4j��ȡxml�ϵ�������Ϣ
 * @author APPle
 *
 */
public class Demo3 {

	public static void main(String[] args) throws Exception {
		//1)����xml������
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/contact.xml"));
		
		/**
		 * ��ȡ����
		 * ע�⣺��ȡ���ԣ������ȵõ��������ڵı�ǩ
		 */
		Element conElem = doc.getRootElement().element("contact");
		//1.1 �ڱ�ǩ�ϻ�ȡ����ֵ(�����������ƻ�ȡ��Ӧ������ֵ)
		String value = conElem.attributeValue("id");
		System.out.println(value);
		/**
		 * ��ϰ�� �õ�id=002����
		 */
		Element conElem2 = (Element)doc.getRootElement().elements().get(1);
		System.out.println(conElem2.attributeValue("id"));
		
		//1.2 �����������ƻ�ȡ���Զ���
		//�õ���ǩ����
		conElem = doc.getRootElement().element("contact");
		//�õ����Զ���
		Attribute idAttr = conElem.attribute("id");
		//ͨ�����Զ����õ� ������
		String idName = idAttr.getName();
		//ͨ�����Զ����õ� ����ֵ
		String idValue = idAttr.getValue();
		System.out.println(idName+"="+idValue);
		
		System.out.println("===============");
		
		//1.3 ��ȡ��ǩ���������Զ���
		conElem = doc.getRootElement().element("contact");
		@SuppressWarnings("unchecked")
		List<Attribute> attrList = conElem.attributes();
		for (Attribute attr : attrList) {
			System.out.println(attr.getName()+"="+attr.getValue());
		}
	}

}
