package com.crotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.User;

@Controller
@SessionAttributes("user")
public class SessionAttributeController {

	@RequestMapping(value="login")
	public String login(@RequestParam("name") String name,@RequestParam("pwd") String pwd,Model model){
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		model.addAttribute("user", user);
		return "test";
	}
}
