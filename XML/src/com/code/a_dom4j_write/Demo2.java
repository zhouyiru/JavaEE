package com.code.a_dom4j_write;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 写出xml文件的细节
 * @author APPle
 *
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		Document doc = new SAXReader().read(new File("./src/contact.xml"));
		
		//创建输出流
		OutputStream outStream = new FileOutputStream("e:/contact.xml");
		//一、设置输出的格式
		//OutputFormat format = OutputFormat.createCompactFormat();//紧凑的格式.空格和换行去掉了！！ 系统上线了使用
		OutputFormat format = OutputFormat.createPrettyPrint();//漂亮的格式。包含空格和换行。 测试时使用
		
		//二、 设置输出的编码格式
		/**作用：
		 * 1)影响了xml的文档声明的encoding编码
		 * 2)影响了xml内容保存的编码
		 */
		format.setEncoding("gbk");
		
		//1)创建输出对象
		XMLWriter writer = new XMLWriter(outStream,format);
		//2)写出数据
		writer.write(doc);
	}
}
