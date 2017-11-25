package com.code.b_sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * sax�¼��������
 * @author APPle
 *
 */
public class MyDefaultHandler2 extends DefaultHandler{
	//�洢contact.xml�ļ���Ϣ
	//��contact.xml��ȡ���֮�������������������xml�ļ���Ϣ
	private StringBuffer sb = new StringBuffer();
	
	public String getContent(){
		return sb.toString();
	}
	
	//��ʼ��ǩ
	/**
	 * qName:��ʼ��ǩ������
	 * attributes�� �����б�
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		sb.append("<"+qName);
		//�����б�
		if(attributes!=null){
			//��������
			for(int i=0;i<attributes.getLength();i++){
				String name = attributes.getQName(i);//��������
				String value = attributes.getValue(i);//����ֵ
				sb.append(" "+name+"=\""+value+"\"");
			}
		}
		sb.append(">");
	}
	
	//�ı�����
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//��ǰ�ı�����
		String content = new String(ch,start,length);
		sb.append(content);
	}
	
	//������ǩ
	//qName: ������ǩ����
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		sb.append("</"+qName+">");
	}
}
