package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.User;

@Controller
public class Crotroller4 {

	@RequestMapping(value="login4")
	public String login4(@RequestParam("name")String name,@RequestParam("pwd")String pwd,Model model){
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		model.addAttribute("user", user);
		return "view";
	}
}
