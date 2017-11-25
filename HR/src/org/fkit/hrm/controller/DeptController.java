package org.fkit.hrm.controller;

import java.util.List;

import org.fkit.hrm.domain.Dept;
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
public class DeptController {
	
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
   @RequestMapping(value="/Dept")
   public String ShowDept(
		   Integer pageIndex,
		   @ModelAttribute Dept dept,
		   Model model)
   {
	   System.out.println("dept:"+dept);
	   PageModel pageModel=new PageModel();
	   if(pageIndex!=null)
	   {
		   pageModel.setPageIndex(pageIndex);
	   }
	   /*查询部门信息*/
	   List<Dept> depts=hrmService.findDept(dept, pageModel);
	   System.out.println(dept);
	   model.addAttribute("depts", depts);
	   model.addAttribute("pageModel",pageModel);
	   return "Dept";
	   }
   
   //删除部门
   @RequestMapping(value="/DeleteDept")
   public String deleteDept(@RequestParam("id") int id)
   {
	   System.out.println(id);
	   hrmService.daleteDept(id);
	   return "redirect:Dept";
   }
   
   //绑定部门数据
   @RequestMapping(value="/ModifyDept")
   public String ModifyDept(Model model,@RequestParam("id") int id)
   {
	  Dept dept=hrmService.selectDeptByID(id); 
	  model.addAttribute("dept", dept);
	  return "ModifyDept";	  
   }
   
   //修改部门
   @RequestMapping(value="/doModifyDept")
   public String doModifyDept(
		   @ModelAttribute Dept dept)
   {
	   hrmService.updateDept(dept);
	   return "redirect:Dept";
   }
   
	/*doSaveDept*/
	@RequestMapping(value="doSaveDept")
	public String doSave(@ModelAttribute Dept dept,Model model)
	{
		System.out.println(dept);
		hrmService.saveDept(dept);
		return "redirect:Dept";
	}
	
}
