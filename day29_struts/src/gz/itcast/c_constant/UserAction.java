package gz.itcast.c_constant;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	public String login() {
		System.out.println("UserAction.login()");
		//查看当前request的characterEncoding编码
		System.out.println(ServletActionContext.getRequest().getCharacterEncoding());
		return SUCCESS;
	}
	
	public String register() {
		//查看当前request的characterEncoding编码
		System.out.println("UserAction.register()");
		return SUCCESS;
	}
}
