package org.fkit.hrm.controller;

import java.util.List;

import javax.persistence.Id;
import javax.servlet.http.HttpSession;

import org.fkit.hrm.domain.User;
import org.fkit.hrm.service.HrmService;
import org.fkit.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class UserController {
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	
	@RequestMapping("/login")
	public String login(
	@RequestParam("loginname") String loginname,
	@RequestParam("password") String password,			
	HttpSession session,
	Model model)
	{
		System.out.println(loginname);
		System.out.println(password);
		User user=hrmService.login(loginname, password);
		if(user!=null)
		{
			session.setAttribute("user", user);
		    return "main";
		}
		else {
			model.addAttribute("message", "login error");
		    return "loginForm";
		}
	}


	/*doSave*/
	@RequestMapping(value="doSave")
	public String doSave(@ModelAttribute User user,Model model)
	{
		System.out.println(user);
		hrmService.saveUser(user);
		return "redirect:User";
	}
	
   @RequestMapping(value="/User")
   public String ShowUser(
		   Integer pageIndex,
		   @ModelAttribute User user,
		   Model model)
   {
	   System.out.println("user:"+user);
	   PageModel pageModel=new PageModel();
	   if(pageIndex!=null)
	   {
		   pageModel.setPageIndex(pageIndex);
	   }
	   /*查询用户信息*/
	   List<User> users=hrmService.findUser(user, pageModel);
	   System.out.println(user);
	   model.addAttribute("users", users);
	   model.addAttribute("pageModel",pageModel);
	   return "User";
   }
   
   //绑定用户数据
   @RequestMapping(value="/ModifyUser")
   public String ModifyUser(Model model,@RequestParam("id") int id)
   {
	  User user=hrmService.selectUserByID(id); 
	  model.addAttribute("user", user);
	  return "ModifyUser";	  
   }
   
   //修改用户
   @RequestMapping(value="/doModifyUser")
   public String doModifyUser(
		   @ModelAttribute User user)
   {
	   hrmService.updateUser(user);
	   return "redirect:User";
   }
   
   //删除用户
   @RequestMapping(value="/DeleteUser")
   public String deleteUser(@RequestParam("id") int id)
   {
	   System.out.println(id);
	   hrmService.deleteUser(id);
	   return "redirect:User";
   }
}
