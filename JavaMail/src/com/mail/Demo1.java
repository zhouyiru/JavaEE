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
 * 第一个javamail发送邮件的案例
 * @author APPle
 *
 */
public class Demo1 {

	public static void main(String[] args) throws Exception, MessagingException {
		//1)创建一个Session对象,连接和登录服务器
		/**
		 * 参数一： 本次连接的配置。
		 * 参数二： 返回对用户名和密码base64加密的对象a
		 */
		Properties props = new Properties();
		//1.1连接的发邮件的服务器地址
		props.setProperty("mail.host", "smtp.qq.com");
		//1.2 指定进行验证登录
		props.setProperty("mail.smtp.auth", "true");
		
		Session  session = Session.getDefaultInstance(props, new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("1558107134@qq.com","qqqzyr0771106754");
					}
		});
		//打开调用
		session.setDebug(true);
		
		//2)在本次连接上， 创建一封邮件
		MimeMessage mail = new MimeMessage(session);
		
		//3）设置邮件内容
		///3.1 设置发件人
		mail.setFrom(new InternetAddress("1558107134@qq.com"));
		
		//3.2 设置收件人
		/**
		 * 参数一： 发送方法
		 * 		发送： TO    A->B
		 *      抄送： CC    A->B  C
		 *      密送： BCC   A->B  C
		 *  参数二： 发送的地址
		 */
		mail.setRecipient(RecipientType.TO, new InternetAddress("1094254814@qq.com"));
		
		//3.3 设置主题
		mail.setSubject("欢迎进入·意中人·相亲论坛");
		
		//3.4 设置内容
		/**
		 * 参数二： 邮件的内容格式。如 普通文本，html方式
		 */
		mail.setContent("<font color='red'>这是邮件的正文内容</font><br/><a href='http://127.0.0.1:8080/User/Login.jsp'>意中人相亲论坛</a>", "text/html;charset=utf-8");
		
		//4)发送邮件
		Transport.send(mail);
		
	}
}

