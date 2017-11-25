package gz.itcast.c_modeldriver;

import gz.itcast.b_validate.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ʹ��ģ��������ʽ��ȡ��������
 * @author APPle
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//ע�⣺ʹ��ģ�������ķ�ʽ��������ݵ�ģ�����ò���Ϊ��
	private User user = new User();
	
	public String register() throws Exception {
		System.out.println("ע��ɹ�");
		System.out.println(user);
		
		/**
		 * �������ݵ�UIҳ��
		 */
		List<User> list = new ArrayList<User>();
		list.add(new User("eric","1234"));
		list.add(new User("jacky","5678"));
		list.add(new User("rose","4321"));
		
		ActionContext ac = ActionContext.getContext();
		ac.getContextMap().put("userList", list);
		
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("101", "eric");
		map.put("102", "mark");
		map.put("103", "maxwell");
		map.put("104", "rose");
		
		ac.getContextMap().put("userMap", map);
		
		
		ac.getContextMap().put("userName", "jacky");
		ac.getContextMap().put("userPwd", "123456");
		//return SUCCESS;
		return "ui";
	}
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * �÷���struts2���԰�ֵջ�е����������װ��User����
	 */
	public User getModel() {
		return user;
	}
	
}
