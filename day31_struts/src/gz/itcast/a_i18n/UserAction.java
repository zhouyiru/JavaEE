package gz.itcast.a_i18n;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		//��ȡ��Դ��������
		String name = super.getText("user");
		System.out.println(name);
		
		
		
		return super.execute();
	}
}
