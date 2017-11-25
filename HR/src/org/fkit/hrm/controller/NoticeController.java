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
		   /*��ѯ������Ϣ*/
		   List<Notice> notices=hrmService.FindNotice(notice, pageModel);
		   System.out.println(notice);
		   model.addAttribute("notices", notices);
		   model.addAttribute("pageModel",pageModel);
		   return "Notice";
		   }
	
	
	//��ӹ���
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
	//ɾ������
	@RequestMapping(value="DeleteNotice")
	public String DeleteNotice(int id)
	{
		hrmService.deleteNotice(id);
		return "redirect:Notice";
	}
	
	
	
	//������
	@RequestMapping(value="ModifyNotice")
	public String doModifyNotice(Model model,@RequestParam("id") int id)
	{
		Notice notice=hrmService.selectNoticeById(id); 
		model.addAttribute("notice", notice);
		return "ModifyNotice";
		
	}
	
	//�޸Ĺ���
	@RequestMapping(value="doModifyNotice")
	String doModifyNotice(@ModelAttribute Notice notice)
	{
		hrmService.updateNotice(notice);
		return "redirect:Notice";
	}
	
	
	
}
