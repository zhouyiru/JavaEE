package com.mail;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 * ������������ʼ�
 * @author APPle
 *
 */
public class Demo2 {

	public static void main(String[] args) throws Exception, MessagingException {
		//1)����һ��Session����,���Ӻ͵�¼������
		/**
		 * ����һ�� �������ӵ����á�
		 * �������� ���ض��û���������base64���ܵĶ���
		 */
		Properties props = new Properties();
		//1.1���ӵķ��ʼ��ķ�������ַ
		props.setProperty("mail.host", "smtp.163.com");
		//props.setProperty("mail.host", "smtp.qq.com");
		//1.2 ָ��������֤��¼
		props.setProperty("mail.smtp.auth", "true");
		
		Session  session = Session.getDefaultInstance(props, new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						//163��126������Ȩ��
						return new PasswordAuthentication("zyr40318076@163.com","zyr40318076");
						//qq������Ȩ��
						//return new PasswordAuthentication("1558107134@qq.com","vkpqgcwvtwugbabh");
						
					}
		});
		//�򿪵���
		session.setDebug(true);
		
		//2)�ڱ��������ϣ� ����һ���ʼ�
		MimeMessage mail = new MimeMessage(session);
		
		//3�������ʼ�����
		///3.1 ���÷�����
		mail.setFrom(new InternetAddress("zyr40318076@163.com"));
		
		//3.2 �����ռ���
		/**
		 * ����һ�� ���ͷ���
		 * 		���ͣ� TO    A->B
		 *      ���ͣ� CC    A->B  C
		 *      ���ͣ� BCC   A->B  C
		 *  �������� ���͵ĵ�ַ
		 */
		mail.setRecipient(RecipientType.TO, new InternetAddress("zyr40318076@126.com"));
		
		//3.3 ��������
		mail.setSubject("�����ˡ�������̳");
		
		//3.4 ��������
		mail.setContent("<font color='red'>�����ʼ�����������</font></br><a href='http://127.0.0.1:8080/User/Login.jsp'>������������̳</a>","text/html;charset=utf-8");

//		/**
//		 * ���ݰ�������
//		 */
//		//һ����������
//		//1)����һ��MimeBodyPart����
//		File file = new File("f:/3.png");
//		MimeBodyPart part  = new MimeBodyPart();
//		DataSource source = new FileDataSource(file);
//		DataHandler handler = new DataHandler(source);
//		part.setDataHandler(handler);
//		//�����ļ���,���������ı���
//		part.setFileName(file.getName());
//		
//	
//		//�ö������ڷ�װ�����������
//		//��MimeBodyPart�������MimeMultipart
//		MimeMultipart multipart = new MimeMultipart();
//		//���һ������
//		multipart.addBodyPart(part);
//		
//		//��MimeMultipart�������MimeMessage
//		mail.setContent(multipart);
		
		
		//4)�����ʼ�
		Transport.send(mail);
		
	}
}

