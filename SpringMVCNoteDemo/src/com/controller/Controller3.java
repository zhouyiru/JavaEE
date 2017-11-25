package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;

@Controller
@RequestMapping("user")
public class Controller3 {

	@ModelAttribute
	public void userModel(String name,String pwd,ModelAndView mv){
		User user = new User();
	    user.setName(name);
	    user.setPwd(pwd);
	    mv.addObject("user", user);
	}
	@RequestMapping(value="login3")
    public ModelAndView login3(ModelAndView mv){
		User user = (User) mv.getModel().get("user");
		user.setName("ModelAndView");
		mv.setViewName("view");
		return mv;
		
	}
}
