package gz.itcast.a_action;

import com.opensymphony.xwork2.Action;
/**
 * �ڶ��ַ�ʽ��ʵ��Action�ӿ�
 * 	1)������Ĭ�ϵ�execute�����ı�׼
 *  2���ṩ����Ŀ�г��õ���ͼ���
 * @author APPle
 *
 */
public class UserAction implements Action {

	public String login() throws Exception {
		System.out.println("ִ����UserAction��login����");
		return SUCCESS;
	}

	public String execute() throws Exception {
		return null;
	}

}
