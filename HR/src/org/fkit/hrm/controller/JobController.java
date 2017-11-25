package org.fkit.hrm.controller;

import java.util.List;

import org.fkit.hrm.domain.Dept;
import org.fkit.hrm.domain.Job;
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
public class JobController {

	
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
   @RequestMapping(value="/Job")
   public String ShowJob(
		   Integer pageIndex,
		   @ModelAttribute Job job,
		   Model model)
   {
	   System.out.println("job:"+job);
	   PageModel pageModel=new PageModel();
	   if(pageIndex!=null)
	   {
		   pageModel.setPageIndex(pageIndex);
	   }
	   /*��ѯ������Ϣ*/
	   List<Job> jobs=hrmService.findJob(job, pageModel);
	   System.out.println(job);
	   model.addAttribute("jobs", jobs);
	   model.addAttribute("pageModel",pageModel);
	   return "Job";
	   }
   
   //ɾ��ְλ
   @RequestMapping(value="/DeleteJob")
   public String deleteJob(@RequestParam("id") int id)
   {
	   System.out.println(id);
	   hrmService.deleteJob(id);
	   return "redirect:Job";
   }
   
   //�󶨲�������
   @RequestMapping(value="/ModifyJob")
   public String ModifyDept(Model model,@RequestParam("id") int id)
   {
	  Job job=hrmService.selectJobByID(id); 
	  model.addAttribute("job", job);
	  return "ModifyJob";	  
   }
   
   //�޸�ְλ
   @RequestMapping(value="/doModifyJob")
   public String doModifyJob(
		   @ModelAttribute Job job)
   {
	   hrmService.updateJob(job);
	   return "redirect:Job";
   }
   
	/*doSaveJob*/
	@RequestMapping(value="doSaveJob")
	public String doSave(@ModelAttribute Job job,Model model)
	{
		System.out.println(job);
		hrmService.saveJob(job);
		return "redirect:Job";
	}
		
}
