package com.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport {

	
	private String username;
	private String password;

	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
 
	/**
	 * 校验并提示错误信息
	 */
	@Override
	public void validate() {
         
		if(username==null||username.equals("")||!username.equals("admin")){
			addFieldError("username", getText("error.user"));
	
		}if(password==null||password.equals("")||password.length()>5){
			addFieldError("password", getText("error.pwd"));
	
		}
		
		
	}
   /**
    * 登陆方法
    * @return
    * @throws Exception
    */
	public String login() throws Exception {
		
		Map<String,Object> map;
		if(username.equals("admin")){
			map = ActionContext.getContext().getSession();
			map.put("username", username);
			return SUCCESS;
		}else{
			return INPUT;
		}
		
	}
	/**
	 * 安全退出方法
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception{
		Map<String,Object> map;
			map = ActionContext.getContext().getSession();
			map.remove("username");
			return INPUT;
		
	}
	
	
}
