package com.code.a_xpath;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 模拟用户登录
 * @author APPle
 *
 */
public class Demo3 {
	public static void main(String[] args) throws Exception {
		//1)获取用户输入的用户名和密码
		//注意： System.in是字节流，BufferedReader是字符流，字节流转字符流需要使用转换流
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("请输入用户名：");
		String name = br.readLine();
		
		System.out.println("请输入密码：");
		String password = br.readLine();
		
		
		//2)在user.xml中查询  
	//name标签文本为’rose‘,password标签文本为’123456‘的user标签
		Document doc = new SAXReader().read(new File("./src/user.xml"));
		
		//查询  文本为’xxx‘的name标签
		Element nameElem = (Element)doc.selectSingleNode("//user/name[text()='"+name+"']");
		
		//判断name标签是否存在
		if(nameElem!=null){
			//存在
			//判断密码是否正确
			Element userElem = nameElem.getParent();
			//判断password子标签的文本内容
			String dbpwd = userElem.elementText("password");
			//数据库的密码和用户输入的密码匹配
			if(password.equals(dbpwd)){
				System.out.println("登录成功");
			}else{
				//不正确
				System.out.println("密码错误，请重新输入！");
			}
		}else{
			//不存在
			System.out.println("该用户名不存在的！");
		}
	
	}
}
