package com.code.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RequestDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String params = request.getQueryString();
		System.out.println(params);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		ServletInputStream in = request.getInputStream();
		byte[] buf = new byte[1024];
		int length = 0;
		while((length=in.read(buf))!=-1){
			String s = new String(buf,0,length);
			System.out.println(s);
		}
		
		String name = request.getParameter("name");
		System.out.println(name);
		
		Enumeration<String> enums = request.getParameterNames();
		while(enums.hasMoreElements()){
			String paramName = enums.nextElement();
			String paramValue = request.getParameter(paramName);
			System.out.println(paramValue);
		}
		Map<String, String[]> map = request.getParameterMap();
		Set<Entry<String, String[]>> entry = map.entrySet();//entrySet
        for (Entry<String, String[]> entry2 : entry) {
			String key = entry2.getKey();
			String[] value = entry2.getValue();
			System.out.println(key+"="+value[0]);
		}
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
			String[] value = map.get(key);
			System.out.println(key+"="+value[0]);
		}
        Collection<String[]> values = map.values();
     for (String[] value : values) {
    	 System.out.println(value[0]);
		
	}
	}
	
	

}
