package com.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;

//自动注解控制器,bean注册
@Controller
//层次目录test/hello
@RequestMapping(value="user")
public class Controller1 {

	//自动注解模块属性
	@ModelAttribute
	public void userModel(String name,String pwd,Model model){
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		model.addAttribute("user",user);
	}
	//自动映射方法
	@RequestMapping(value="hello")
	public ModelAndView hello(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","hello");
		mv.setViewName("view");
		return mv;
	}

	@RequestMapping(value="test")
	public ModelAndView test(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("test");
		return mv;
	}
	
	@RequestMapping(value="helloworld")
	public String helloworld(Model model,HttpSession session){
		System.out.println(session.getAttribute("test"));
		model.addAttribute("hello", "hello world");
		return "test";//返回的是视图
	}
	@RequestMapping(value="login")
	public String login(Model model){
       User user = (User) model.asMap().get("user");
       user.setName("qingjue");
		return "view";
	}

}
