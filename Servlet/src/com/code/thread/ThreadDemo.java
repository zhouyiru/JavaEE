package com.code.thread;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * servlet的多线程并发问题
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ThreadDemo extends HttpServlet {
	public ThreadDemo(){
		System.out.println("TheadDemo对象创建了");
	}

	//成员变量，那么该数据就可能被不同用户线程共享到。有可能引发多线程并发问题。
	static int count = 1;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		/**
		 * 1）同步代码块
		 * 给使用到共享数据的代码块添加同步锁
		 * 注意:同步锁必须多个线程唯一的
		 */
		synchronized (ThreadDemo.class) {
			response.getWriter().write("你当前是第"+count+"个访客！");   // A线程刚刚执行完这句代码，被B线程抢去了执行时机。
		
			//睡眠
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
	 * 2 ）同步方法
	 * @param response
	 */
	/*public synchronized static void method(HttpServletResponse response){
		try {
			response.getWriter().write("你当前是第"+count+"个访客！");
		} catch (IOException e1) {
			e1.printStackTrace();
		}   // A线程刚刚执行完这句代码，被B线程抢去了执行时机。
		
		//睡眠
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count++; 
	}*/

}
