package gz.itcast.f_data;

import com.opensymphony.xwork2.ActionSupport;
/**
 *  2)�ڶ��ַ�ʽ: ֱ�ӰѲ�����ֵ��һ��javabean����(�Ƽ�ʹ������)
 * ��������ĸ�ֵ
 * @author APPle
 *
 */
public class UserAction2 extends ActionSupport{
	//ʹ��һ��javabean�������
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public String register() throws Exception{
		//ʹ�ñ�������
		System.out.println(user);
		return SUCCESS;
	}
}
