package cn.itcast;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CityServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String country = request.getParameter("country");
		String dataType = request.getParameter("dataType");
		String sendType = request.getParameter("sendType");
		if (!"post".equals(sendType)) {
			country = new String(request.getParameter("country").getBytes("ISO-8859-1"), "utf-8");
		}
		
		StringBuffer sb = new StringBuffer("");
		if (!"json".equals(dataType)) {
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>");
			if ("中国".equals(country)) {
				sb.append("<city>北京</city>").append("<city>上海</city>").append("<city>广州</city>").append("<city>深圳</city>");
			} else if ("美国".equals(country)) {
				sb.append("<city>华盛顿特区</city>").append("<city>纽约</city>").append("<city>洛杉矶</city>").append("<city>芝加哥</city>");
			}
			sb.append("</root>");
			response.setContentType("text/xml;charset=utf-8");
		} else {
			sb.append("{");
			sb.append("\"cities\":[");
			if ("中国".equals(country)) {
				sb.append("{\"city\":\"北京\"},{\"city\":\"上海\"},{\"city\":\"广州\"},{\"city\":\"深圳\"}");
			} else if ("美国".equals(country)) {
				sb.append("{\"city\":\"华盛顿特区\"},{\"city\":\"纽约\"},{\"city\":\"洛杉矶\"},{\"city\":\"芝加哥\"}");
			}
			sb.append("]}");
			response.setContentType("text/html;charset=utf-8");
		}
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
