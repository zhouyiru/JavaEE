package gz.itcast.c_constant;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	public String login() {
		System.out.println("UserAction.login()");
		//�鿴��ǰrequest��characterEncoding����
		System.out.println(ServletActionContext.getRequest().getCharacterEncoding());
		return SUCCESS;
	}
	
	public String register() {
		//�鿴��ǰrequest��characterEncoding����
		System.out.println("UserAction.register()");
		return SUCCESS;
	}
}
