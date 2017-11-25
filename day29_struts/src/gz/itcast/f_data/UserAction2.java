package gz.itcast.f_data;

import com.opensymphony.xwork2.ActionSupport;
/**
 *  2)第二种方式: 直接把参数赋值给一个javabean对象(推荐使用这种)
 * 请求参数的赋值
 * @author APPle
 *
 */
public class UserAction2 extends ActionSupport{
	//使用一个javabean对象接收
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String register() throws Exception{
		//使用表单的数据
		System.out.println(user);
		return SUCCESS;
	}
}
