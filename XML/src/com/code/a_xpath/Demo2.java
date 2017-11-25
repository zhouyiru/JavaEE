package com.code.a_xpath;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * 			/   ����·��    б������ǰ�棬����xml�ļ��ĸ���б�����м䣬��ʾ��Ԫ�ء�
			//  ���·��    ѡ����Ԫ�أ����ֲ�νṹ��
			*   ͨ��			ѡ������Ԫ��
			[ ]   ����        ѡ��ʲô�����µ�Ԫ�ء����� /AAA/BBB[1] ѡ���һ��BBB��Ԫ��
			@   ����         ѡȡ����
			=    ���� ��ֵ��  

 * @author APPle
 *
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		//1����ȡxml�ļ�
		Document doc = new SAXReader().read(new File("./src/contact.xml"));
		
		//2)����xpath������ѯxml�ļ�
		String xpath = "";
		
		//2.1    / 
		xpath = "/contact-list"; //����ǩcontact-list
		xpath = "/contact-list/contact"; //contact-list����ǩ�µ�contact�ӱ�ǩ
		
		
		//2.2   // 
		xpath = "//contact"; //ѡ������contact��ǩ�����ֲ�Σ�
		xpath = "//contact/name"; //ѡ�����и���ǩ��contact��name��ǩ
		
		//2.3   *
		xpath = "/contact-list/*"; //ѡ����ݱ�ǩcontact-list�µ������ӱ�ǩ
		xpath = "/contact-list//*"; //ѡ�����ǩcontact-list�µ����к����ǩ�����ֲ�νṹ��
		
		
		//2.4 [ ]
		xpath = "//contact[1]";// ��һ��contact��ǩ
		xpath = "//contact[last()]";//���һ��contact��ǩ
		
		//2.5 @ 
		xpath = "//@id"; // ѡ������id����
		xpath = "//contact[@id]"; //ѡ�����а���id���Ե�contact��ǩ
		
		
		//2.6 = 
		xpath = "//contact[@id='002']"; //ѡ��id����ֵΪ002��contact��ǩ
		
		//2.7 and  �߼���
		//ѡȡid����Ϊ002,��name����Ϊeric��contact��ǩ
		xpath = "//contact[@id='002' and @name='eric']";
		
		//2.8   text()   ѡȡ�ı�
		xpath = "//contact[@id='001']/name[1]/text()";//ѡ���һ��name��ǩ���ı�
		xpath = "//name[text()='����']";//�ı�����Ϊ����������name��ǩ
		
		
		@SuppressWarnings("unchecked")
	List<Node> list = doc.selectNodes(xpath);
		for (Node node : list) {
			System.out.println(node);
		}
		
		
		
		
		
		
	}
}
