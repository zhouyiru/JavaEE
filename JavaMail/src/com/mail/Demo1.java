package com.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * ��һ��javamail�����ʼ��İ���
 * @author APPle
 *
 */
public class Demo1 {

	public static void main(String[] args) throws Exception, MessagingException {
		//1)����һ��Session����,���Ӻ͵�¼������
		/**
		 * ����һ�� �������ӵ����á�
		 * �������� ���ض��û���������base64���ܵĶ���a
		 */
		Properties props = new Properties();
		//1.1���ӵķ��ʼ��ķ�������ַ
		props.setProperty("mail.host", "smtp.qq.com");
		//1.2 ָ��������֤��¼
		props.setProperty("mail.smtp.auth", "true");
		
		Session  session = Session.getDefaultInstance(props, new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("1558107134@qq.com","qqqzyr0771106754");
					}
		});
		//�򿪵���
		session.setDebug(true);
		
		//2)�ڱ��������ϣ� ����һ���ʼ�
		MimeMessage mail = new MimeMessage(session);
		
		//3�������ʼ�����
		///3.1 ���÷�����
		mail.setFrom(new InternetAddress("1558107134@qq.com"));
		
		//3.2 �����ռ���
		/**
		 * ����һ�� ���ͷ���
		 * 		���ͣ� TO    A->B
		 *      ���ͣ� CC    A->B  C
		 *      ���ͣ� BCC   A->B  C
		 *  �������� ���͵ĵ�ַ
		 */
		mail.setRecipient(RecipientType.TO, new InternetAddress("1094254814@qq.com"));
		
		//3.3 ��������
		mail.setSubject("��ӭ���롤�����ˡ�������̳");
		
		//3.4 ��������
		/**
		 * �������� �ʼ������ݸ�ʽ���� ��ͨ�ı���html��ʽ
		 */
		mail.setContent("<font color='red'>�����ʼ�����������</font><br/><a href='http://127.0.0.1:8080/User/Login.jsp'>������������̳</a>", "text/html;charset=utf-8");
		
		//4)�����ʼ�
		Transport.send(mail);
		
	}
}

