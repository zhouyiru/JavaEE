package gz.itcast.b_path;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 用户模块
 * @author APPle
 *
 */
public class UserAction extends ActionSupport{
	//登录方法
	public String login()throws Exception{
		System.out.println("UserAction3.login()");
		return "login";
	}
	//注册方法
	public String register()throws Exception{
		System.out.println("UserAction3.register()");
		return "register";
	}
	
	
}
