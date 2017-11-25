package cn.itcast;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {
	
	//获取当前时间
	public static String getCurrentTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String async = request.getParameter("async");//true 表示异步，其它情况为同步
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if ("true".equals(async)) {//异步请求
			PrintWriter writer = response.getWriter();
			writer.write(getCurrentTime());
			writer.flush();
			writer.close();
		} else {//同步请求
			request.setAttribute("currentTime", getCurrentTime());
			request.getRequestDispatcher("/showTime.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
