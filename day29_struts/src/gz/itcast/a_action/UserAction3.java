package gz.itcast.a_action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * �����ַ�ʽ�� �̳�ActionSupport��(�Ƽ�ʹ��)
 * 		�ô��� 
 * 			1���ṩ�˳��õ���ͼ���
 * 			2���ṩ������У�鹦��
 * 
 * @author APPle
 *
 */
public class UserAction3 extends ActionSupport{

	public String login()throws Exception{
		System.out.println("UserAction3.login()");
		return SUCCESS;
	}
}
