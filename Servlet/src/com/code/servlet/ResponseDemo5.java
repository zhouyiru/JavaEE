package com.code.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ������Content-Disposition�� -- attachment; filename=aaa.zip   -- �����ط�ʽ����Դ
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ResponseDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File file = new File("e:/mm.jpg");
		/**
		 * ��������������صķ�����
		 */
		response.setHeader("content-disposition", "attachment;filename="+file.getName());
		
		/**
		 * �ļ�����
		 */
		//1)��ȡ�����ļ�
		FileInputStream in = new FileInputStream(file);
		
		//2)д���������(�ֽ�����)
		OutputStream out = response.getOutputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		//�߶���д
		while( (len=in.read(buf))!=-1  ){
			out.write(buf, 0, len);
		}
		
		//�ر�
		in.close();
		out.close();
		
		
	}

}
