package com.code.a_dom4j_write;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 写出一个xml文件
 * @author APPle
 *
 */
public class Demo1 {
	public static void main(String[] args) throws Exception {
		
		/**
		 * 修改xml信息的步骤
		 * 1）读取到原来的xml文件（document对象）
		 * 2）操作document对象，改变xml信息（docuement对象）
		 * 3）把修改后的document对象写出到xml文件中（覆盖原来的文件）
		 */
		
		
		Document doc = new SAXReader().read(new File("./src/contact.xml"));
		/**
		 * 输出流
		 * 	  字符输出流： 
		 * 		 Writer ->  FileWriter/BufferedWriter
		 * 				方法：
		 * 					write(char c)： 写出一个字符
		 * 					write(char[] data): 写出多个字符
		 * 					write(String str): 写出一个字符串  
		 * 	  字节输出流
		 * 		 OutputStream -> FileOutputStream/BufferedOutputStream/ObjectOutputStream
		 * 					write(byte) :写出一个字节
		 * 					write(byte[] data): 写出多个字节
		 */
		/**
		 * 把内存的document对象写出到硬盘的xml文件
		 */
		//创建输出流
		OutputStream outStream = new FileOutputStream("e:/contact.xml");
		//1)创建输出对象
		XMLWriter writer = new XMLWriter(outStream);
		//2)写出数据
		writer.write(doc);
	}
}
