package gz.itcast.b_path;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ͼ��ģ��
 * @author APPle
 *
 */
public class BookAction extends ActionSupport{
	//��ӷ���
	public String add()throws Exception{
		System.out.println("BookAction.add()");
		return "add";
	}
	//��ѯ����
	public String list()throws Exception{
		System.out.println("BookAction.list()");
		return "list";
	}
	
	
}
