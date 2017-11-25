package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		//建立一个准备返回ModelAndView的对象
		//通常包含返回的视图，模型的名称以及模型对象
		ModelAndView mv = new ModelAndView();
		//添加模型数据
	    mv.addObject("message","Hello World");
		mv.setViewName("welcome.jsp");
		return mv;
	}

}
