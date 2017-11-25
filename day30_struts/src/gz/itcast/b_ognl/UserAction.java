package gz.itcast.b_ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport{
	//Action的参数数据
	private User user = new User("jacky",30);
	
	private Book book  = new Book("java基础");
	/**
	 * 在用户每次访问action对象的业务方法时，struts2框架会创建ActiionContext对象 （  OgnlValueStack对象）  （Action对象）  ）
	 */
	@Override
	public String execute() throws Exception {
		//1)获取ActionContext对象
		ActionContext ac = ActionContext.getContext();
		
		List<User> list = new ArrayList<User>();
		list.add(new User("eric",20));
		list.add(new User("jacky",30));
		list.add(new User("rose",40));
		list.add(new User("lucy",50));
		ac.getContextMap().put("userList", list);
		
		Map<String,User> map = new HashMap<String,User>();
		map.put("100", new User("mark",20));
		map.put("101", new User("maxwell",30));
		map.put("102", new User("lily",40));
		ac.getContextMap().put("userMap", map);
		//往域对象存放数据
		ac.getContextMap().put("request_data", "request_data");
		ac.getSession().put("session_data", "session_data");
		ac.getApplication().put("application_data", "application_data");
		
		
		//2)从ActionContext对象获取OnglValueStack对象
		ValueStack vs = ac.getValueStack();
		
		//3)查看OnglValueStack对象的结构
		
		//往OgnlValueStack的根对象（List栈）存放数据
		vs.push(user);//往List栈 的栈顶
		vs.pop(); //从List栈中 取出元素(栈顶元素)
		
		vs.push(book);
		
		return SUCCESS;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}
}
