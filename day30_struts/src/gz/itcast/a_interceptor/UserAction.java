package gz.itcast.a_interceptor;

import gz.itcast.b_ognl.User;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	
	public UserAction(){
		System.out.println("3)������UserAction����");
	}

	public String register() throws Exception {
		
		System.out.println("5)������UserAction�ķ���");
		
		return SUCCESS;
	}

}
