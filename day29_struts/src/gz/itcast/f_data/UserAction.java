package gz.itcast.f_data;

import com.opensymphony.xwork2.ActionSupport;
/**
 *  1)��һ�ַ�ʽ: ֱ�ӰѲ�����ֵ��һ��������
 * ��������ĸ�ֵ
 * @author APPle
 *
 */
public class UserAction extends ActionSupport{
	//������ֵ��ע�뷽ʽ��
	private String name;
	private String password;
	private String gender;
	private String[] hobit;
	//����ͨ�����set����ע�뵽Action��
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setHobit(String[] hobit) {
		this.hobit = hobit;
	}


	public String register() throws Exception{
		//ʹ�ñ�������
		System.out.println(name);
		System.out.println(password);
		System.out.println(gender);
		System.out.println(hobit);
		return SUCCESS;
	}
}
