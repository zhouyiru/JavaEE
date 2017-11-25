package org.fkit.hrm.controller;

import java.util.List;

import javax.persistence.Id;
import javax.servlet.http.HttpSession;

import org.fkit.hrm.domain.Dept;
import org.fkit.hrm.domain.Notice;
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

@Controller
public class NoticeController {

	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	@RequestMapping(value="Notice")
	   public String ShowNotice(
			   Integer pageIndex,
			   @ModelAttribute Notice notice,
			   Model model)
	   {
		   System.out.println("notice:"+notice);
		   PageModel pageModel=new PageModel();
		   if(pageIndex!=null)
		   {
			   pageModel.setPageIndex(pageIndex);
		   }
		   /*查询公告信息*/
		   List<Notice> notices=hrmService.FindNotice(notice, pageModel);
		   System.out.println(notice);
		   model.addAttribute("notices", notices);
		   model.addAttribute("pageModel",pageModel);
		   return "Notice";
		   }
	
	
	//添加公告
	/*doSaveNotice*/
	@RequestMapping(value="doSaveNotice")
	public String doSave(@ModelAttribute Notice notice,Model model,HttpSession session)
	{
		System.out.println(notice);
		User user=(User)(session.getAttribute("user"));
		notice.setUser(user);
		hrmService.saveNotice(notice);
		return "redirect:Notice";
	}
	//删除公告
	@RequestMapping(value="DeleteNotice")
	public String DeleteNotice(int id)
	{
		hrmService.deleteNotice(id);
		return "redirect:Notice";
	}
	
	
	
	//绑定数据
	@RequestMapping(value="ModifyNotice")
	public String doModifyNotice(Model model,@RequestParam("id") int id)
	{
		Notice notice=hrmService.selectNoticeById(id); 
		model.addAttribute("notice", notice);
		return "ModifyNotice";
		
	}
	
	//修改公告
	@RequestMapping(value="doModifyNotice")
	String doModifyNotice(@ModelAttribute Notice notice)
	{
		hrmService.updateNotice(notice);
		return "redirect:Notice";
	}
	
	
	
}
