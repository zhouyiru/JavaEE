package gz.itcast.b_path;

import com.opensymphony.xwork2.ActionSupport;
/**
 * �û�ģ��
 * @author APPle
 *
 */
public class UserAction extends ActionSupport{
	//��¼����
	public String login()throws Exception{
		System.out.println("UserAction3.login()");
		return "login";
	}
	//ע�᷽��
	public String register()throws Exception{
		System.out.println("UserAction3.register()");
		return "register";
	}
	
	
}
