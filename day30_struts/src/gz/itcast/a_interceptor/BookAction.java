package gz.itcast.a_interceptor;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String list() throws Exception {
		System.out.println("ִ����BookAction����");
		System.out.println("name="+name);
		return super.execute();
	}
}
