package gz.itcast.b_ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport{
	//Action�Ĳ�������
	private User user = new User("jacky",30);
	
	private Book book  = new Book("java����");
	/**
	 * ���û�ÿ�η���action�����ҵ�񷽷�ʱ��struts2��ܻᴴ��ActiionContext���� ��  OgnlValueStack����  ��Action����  ��
	 */
	@Override
	public String execute() throws Exception {
		//1)��ȡActionContext����
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
		//�������������
		ac.getContextMap().put("request_data", "request_data");
		ac.getSession().put("session_data", "session_data");
		ac.getApplication().put("application_data", "application_data");
		
		
		//2)��ActionContext�����ȡOnglValueStack����
		ValueStack vs = ac.getValueStack();
		
		//3)�鿴OnglValueStack����Ľṹ
		
		//��OgnlValueStack�ĸ�����Listջ���������
		vs.push(user);//��Listջ ��ջ��
		vs.pop(); //��Listջ�� ȡ��Ԫ��(ջ��Ԫ��)
		
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
