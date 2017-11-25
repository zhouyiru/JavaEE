package com.code.a_dom4j_read;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��dom4j��ȡxml�ı�ǩ
 *      getRootElement(): ��ȡ����ǩ
 *      getName(): ��ȡ��ǩ����
 *      element("����")�� ��ȡ��һ��ָ�����Ƶ��ӱ�ǩ
 *      elements("����"): ��ȡָ�����Ƶ����е��ӱ�ǩ
 *      elements(): ��ȡ�����ӱ�ǩ
 * 
 * @author APPle
 *
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		//1)����xml����������
		SAXReader reader = new SAXReader(); // ctrl+2 ����  +l
		//2)��ȡxml�ļ�
		Document doc = reader.read(new File("./src/contact.xml"));
		
		/**
		 * ��ȡ��ǩ
		 */
		//1.1 ��ȡ����ǩ
		Element rootElem = doc.getRootElement();
		System.out.println(rootElem);
		//1.2 ��ȡ��ǩ����
		System.out.println(rootElem.getName());
		
		//1.3 ��ȡ��һ���ӱ�ǩ(����ָ�������ƻ�ȡ��һ���ӱ�ǩ)
		Element conElem = rootElem.element("contact");
		System.out.println(conElem);
		
		System.out.println("==============");
		//1.4 ��ȡ�����ӱ�ǩ������ָ�������ƻ�ȡ����ͬ���ӱ�ǩ��
		@SuppressWarnings("unchecked")
		List<Element> list = rootElem.elements("contact");
		//����List
		//���ַ�ʽ?
		//1)��ͳforѭ��
		/*for(int i=0;i<list.size();i++){
			list.get(i); //���ݽǱ��ȡָ������
		}*/
		
		//2)for-eachѭ��
		for(Element e: list){
			System.out.println(e);
		}
		
		//3)������
		/*Iterator it = list.iterator();
		while(it.hasNext()){ //hasNext(): �ж��Ƿ�����һ��Ԫ��
			it.next(); //next():ȡ����ǰ����
		}*/
		
		System.out.println("================");
		
		//1.4 ��ȡ�����ӱ�ǩ����ָ�����ƣ�
		@SuppressWarnings("unchecked")
		List<Element> eList = rootElem.elements();
		for(Element e:eList){
			System.out.println(e);
		}
		System.out.println("===========");
		
		/**
		 * ע�⣬�����Ҫ��ȡ���ǩ�����ȵ��õ��ӱ�ǩ���ٴ��ӱ�ǩ����ȡ���ǩ������
		 */
		Element nameElem  = rootElem.element("contact").element("name");
		System.out.println(nameElem);
		
		
		
	}
}
