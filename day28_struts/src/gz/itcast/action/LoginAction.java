package gz.itcast.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
/**
 * 登录逻辑的Action
 * @author APPle
 *
 */
public class LoginAction implements Action{
	//默认方法
	public String execute() throws Exception {
		System.out.println("执行了LoginAction的execute方法");
		//往request存放数据
		ServletActionContext.getRequest().setAttribute("name", "eric");
		
		
		return "success";
	}

	public String login() throws Exception {
		System.out.println("执行了LoginAction的login方法");
		//从request获取数据
		String name = (String)ServletActionContext.getRequest().getAttribute("name");
		System.out.println("name="+name);
		return "login";
	}
}
