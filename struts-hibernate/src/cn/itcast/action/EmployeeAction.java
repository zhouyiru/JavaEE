package cn.itcast.action;

import java.util.Map;

import cn.itcast.entity.Employee;
import cn.itcast.service.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {

	private int id;
	public void setId(int id) {
		this.id = id;
	}
	
	// Service对象
	private EmployeeService employeeService = new EmployeeService();
	
	public String execute() {
		// 主键查询
		Employee emp = employeeService.findById(id);
		// 保存request域
		Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("employee", emp);
		
		
		return SUCCESS;
	}
}














