package gz.itcast.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
/**
 * ��¼�߼���Action
 * @author APPle
 *
 */
public class LoginAction implements Action{
	//Ĭ�Ϸ���
	public String execute() throws Exception {
		System.out.println("ִ����LoginAction��execute����");
		//��request�������
		ServletActionContext.getRequest().setAttribute("name", "eric");
		
		
		return "success";
	}

	public String login() throws Exception {
		System.out.println("ִ����LoginAction��login����");
		//��request��ȡ����
		String name = (String)ServletActionContext.getRequest().getAttribute("name");
		System.out.println("name="+name);
		return "login";
	}
}
