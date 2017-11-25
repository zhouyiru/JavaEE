package gz.itcast.e_scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.ws.RequestWrapper;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 3��strus2�ṩ�ĵ�����ʹ�������ķ�������Action����ķ����Ƚ϶��ʱ���Ƽ�ʹ�����ַ�����
 *   ͨ��struts2�ṩ�Ľӿ�ע�뵽Action������
 *   	�ص�: 
 *   		1)��������struts2�ӿ�
 *   		2)������action���������ҵ�񷽷���ʹ��!!
 * @author APPle
 *
 */
public class UserAction2 extends BaseAction{

	
	public String list()throws Exception{
		
		//1)�����ݿ�õ�����
		List<String> list = new ArrayList<String>();
		list.add("eric");
		list.add("jacky");
		list.add("rose");
		
		//��request��������
		requestMap.put("request_list", list);
		//��session��������
		sessionMap.put("session_list", list);
		//��context��������
		contextMap.put("context_list", list);
		
		return "success";
		
	}
	

	

	

}
