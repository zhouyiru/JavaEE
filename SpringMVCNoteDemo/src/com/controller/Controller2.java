package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;

@Controller
@RequestMapping(value="user")
public class Controller2 {

	@ModelAttribute
	public void userModel(String name,String pwd,ModelMap modelMap){
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		modelMap.addAttribute("user2", user);
	}
	@RequestMapping(value="login2")
	public String login2(ModelMap modelMap){
		User user = (User) modelMap.get("user2");
		user.setName("map zhouyiru");
		return "view";
	}
}
