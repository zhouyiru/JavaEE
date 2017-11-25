package org.fkit.hrm.controller;

import java.util.List;

import org.fkit.hrm.domain.Dept;
import org.fkit.hrm.domain.Employee;
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
import org.springframework.web.servlet.config.MvcNamespaceHandler;

@Controller
public class EmployeeController {

	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	@RequestMapping(value="/addEmployee")
	public String showAddEmployee(Model model)
	{
		List<Dept> depts=hrmService.selectAllDepts();
		List<Job> jobs=hrmService.selectAllJobs();
		model.addAttribute("depts", depts);
		model.addAttribute("jobs",jobs);
		System.out.println(depts);
		System.out.println(jobs);
		return "addEmployee";
	}
	
	
	/*doSaveEmployee*/
	@RequestMapping(value="doSaveEmployee")
	public String doSave(@ModelAttribute Employee employee,Model model,
			@RequestParam("job_id") Integer job_id,
			@RequestParam("dept_id") Integer dept_id)
	{
		System.out.println(employee);
		System.out.println(job_id);
		System.out.println(dept_id);
		this.genericAssciation(job_id, dept_id, employee);
		hrmService.saveEmployee(employee);
		System.out.println(employee);
		return "redirect:Employee";
	}
	
	@RequestMapping(value="/Employee")
	public String ShowEmpoyees( 
			   Integer pageIndex,
			   @ModelAttribute Employee employee,
			   Model model)
	{
		   System.out.println("employee:"+employee);
		   PageModel pageModel=new PageModel();
		   if(pageIndex!=null)
		   {
			   pageModel.setPageIndex(pageIndex);
		   }

		   /*查询部门信息*/
		   List<Employee> employees=hrmService.FindEmploy(employee, pageModel);
		   System.out.println(employee);
		   model.addAttribute("employees", employees);
		   model.addAttribute("pageModel",pageModel);
	       return "Employee";
	}
	
	
	
	@RequestMapping(value="/DeleteEmployee")
	String deleteEmployee(@RequestParam("id") int id)
	{
		hrmService.deleteEmployee(id);
		return "redirect:Employee";
	}
	
	/*
	 * 映射关系
	 * */
	private void genericAssciation(Integer job_id,Integer dept_id,Employee employee)
	{
		if(job_id!=null){
			Job job=new Job();
			job.setId(job_id);
			employee.setJob(job);
		}
		
		if(dept_id!=null)
		{
			Dept dept=new Dept();
			dept.setId(dept_id);
			employee.setDept(dept);
		}
	}
}
