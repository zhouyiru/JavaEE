package com.code.thread;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * servlet�Ķ��̲߳�������
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ThreadDemo extends HttpServlet {
	public ThreadDemo(){
		System.out.println("TheadDemo���󴴽���");
	}

	//��Ա��������ô�����ݾͿ��ܱ���ͬ�û��̹߳������п����������̲߳������⡣
	static int count = 1;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		/**
		 * 1��ͬ�������
		 * ��ʹ�õ��������ݵĴ�������ͬ����
		 * ע��:ͬ�����������߳�Ψһ��
		 */
		synchronized (ThreadDemo.class) {
			response.getWriter().write("�㵱ǰ�ǵ�"+count+"���ÿͣ�");   // A�̸߳ո�ִ���������룬��B�߳���ȥ��ִ��ʱ����
		
			//˯��
			/*try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			count++;  
		}
		
		//method(response);
		
	}
	
	/**
	 * 2 ��ͬ������
	 * @param response
	 */
	/*public synchronized static void method(HttpServletResponse response){
		try {
			response.getWriter().write("�㵱ǰ�ǵ�"+count+"���ÿͣ�");
		} catch (IOException e1) {
			e1.printStackTrace();
		}   // A�̸߳ո�ִ���������룬��B�߳���ȥ��ִ��ʱ����
		
		//˯��
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count++; 
	}*/

}
