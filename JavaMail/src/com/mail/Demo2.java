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
 * 带多个附件的邮件
 * @author APPle
 *
 */
public class Demo2 {

	public static void main(String[] args) throws Exception, MessagingException {
		//1)创建一个Session对象,连接和登录服务器
		/**
		 * 参数一： 本次连接的配置。
		 * 参数二： 返回对用户名和密码base64加密的对象
		 */
		Properties props = new Properties();
		//1.1连接的发邮件的服务器地址
		props.setProperty("mail.host", "smtp.163.com");
		//props.setProperty("mail.host", "smtp.qq.com");
		//1.2 指定进行验证登录
		props.setProperty("mail.smtp.auth", "true");
		
		Session  session = Session.getDefaultInstance(props, new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						//163和126邮箱授权码
						return new PasswordAuthentication("zyr40318076@163.com","zyr40318076");
						//qq邮箱授权码
						//return new PasswordAuthentication("1558107134@qq.com","vkpqgcwvtwugbabh");
						
					}
		});
		//打开调用
		session.setDebug(true);
		
		//2)在本次连接上， 创建一封邮件
		MimeMessage mail = new MimeMessage(session);
		
		//3）设置邮件内容
		///3.1 设置发件人
		mail.setFrom(new InternetAddress("zyr40318076@163.com"));
		
		//3.2 设置收件人
		/**
		 * 参数一： 发送方法
		 * 		发送： TO    A->B
		 *      抄送： CC    A->B  C
		 *      密送： BCC   A->B  C
		 *  参数二： 发送的地址
		 */
		mail.setRecipient(RecipientType.TO, new InternetAddress("zyr40318076@126.com"));
		
		//3.3 设置主题
		mail.setSubject("意中人·相亲论坛");
		
		//3.4 设置内容
		mail.setContent("<font color='red'>这是邮件的正文内容</font></br><a href='http://127.0.0.1:8080/User/Login.jsp'>意中人相亲论坛</a>","text/html;charset=utf-8");

//		/**
//		 * 内容包含附件
//		 */
//		//一个附件对象
//		//1)创建一个MimeBodyPart对象
//		File file = new File("f:/3.png");
//		MimeBodyPart part  = new MimeBodyPart();
//		DataSource source = new FileDataSource(file);
//		DataHandler handler = new DataHandler(source);
//		part.setDataHandler(handler);
//		//设置文件名,并设置中文编码
//		part.setFileName(file.getName());
//		
//	
//		//该对象用于封装多个附件对象
//		//把MimeBodyPart对象放入MimeMultipart
//		MimeMultipart multipart = new MimeMultipart();
//		//添加一个附件
//		multipart.addBodyPart(part);
//		
//		//把MimeMultipart对象放入MimeMessage
//		mail.setContent(multipart);
		
		
		//4)发送邮件
		Transport.send(mail);
		
	}
}

