package com.code.a_dom4j_write;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * д��xml�ļ���ϸ��
 * @author APPle
 *
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		Document doc = new SAXReader().read(new File("./src/contact.xml"));
		
		//���������
		OutputStream outStream = new FileOutputStream("e:/contact.xml");
		//һ����������ĸ�ʽ
		//OutputFormat format = OutputFormat.createCompactFormat();//���յĸ�ʽ.�ո�ͻ���ȥ���ˣ��� ϵͳ������ʹ��
		OutputFormat format = OutputFormat.createPrettyPrint();//Ư���ĸ�ʽ�������ո�ͻ��С� ����ʱʹ��
		
		//���� ��������ı����ʽ
		/**���ã�
		 * 1)Ӱ����xml���ĵ�������encoding����
		 * 2)Ӱ����xml���ݱ���ı���
		 */
		format.setEncoding("gbk");
		
		//1)�����������
		XMLWriter writer = new XMLWriter(outStream,format);
		//2)д������
		writer.write(doc);
	}
}
