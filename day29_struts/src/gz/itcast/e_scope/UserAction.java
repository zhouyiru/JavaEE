package gz.itcast.e_scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	//�����÷�������!!��ΪActionContext����Ĺ�����ͨ��������������,����������ִ�����ڴ���UserAction֮��
	/*ActionContext ac = null;
		
	public UserAction(){
		ac = ActionContext.getContext();
	}*/
	
	//ҵ�񷽷�����������֮��ִ�е�,����ActionContext���������ɹ��Ĵ�����
	public String list()throws Exception{
		
		//1)�����ݿ�õ�����
		List<String> list = new ArrayList<String>();
		list.add("eric");
		list.add("jacky");
		list.add("rose");
		
		//2) ��request��session��context���������������
		/**
		 * 1)strus2�ṩ�ĵ�һ��ʹ�������ķ���(���������ʹ�����������ȡ���� �����Ƽ�ʹ�����ַ�ʽ)
		 * 	     ServletActionContext����:������struts2��action������ʹ�������
		 *    �ص㣺 ����servletԭ����api
		 */
		/*//��ȡrequest�����
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("request_list", list);
		//��ȡsession�����
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		session.setAttribute("session_list", list);
		//��ȡServletContext�����
		ServletContext context = ServletActionContext.getServletContext();
		context.setAttribute("context_list", list);*/
		
		//�õ��ͻ���������������
		/**
		 * ע��: ����õ���request/session/servletcontext�����еĳ���ȡ��������������������ͱ����ʹ��ServletActionContext
		 *     ����ȡ���ݡ�
		 */
		ServletActionContext.getRequest().getMethod();
		
		
		
		/*ActionContext ac = ActionContext.getContext();
		*//**
		 * 2)strus2�ṩ�ĵڶ���ʹ�������ķ���(Action���󷽷��ٵ�ʱ��,����ʹ�����ַ�ʽ)
		 *     ActionContext����: action�������Ķ���,�����ActionContext�������ṩ������ͬ��������ݵ�Map����
		 *     
		 *     �ص㣺
		 *     1) ������servletԭ����api,�������
		 *     2)ֻ����action��ĳ��ҵ�񷽷���ʹ��	
		 *//*
		
		
		//�õ�����request���map����(�������Map���Ͼ͵�ͬ�ڲ�����request�������)
		Map<String,Object> requestMap = ac.getContextMap();
		requestMap.put("request_list", list); //��ŵ�request����
		//�õ�����session���map����
		Map<String,Object> sessionMap = ac.getSession();
		sessionMap.put("session_list", list);
		//�õ�����context���map����
		Map<String, Object> contextMap = ac.getApplication();
		contextMap.put("context_list", list);*/
		
		
		return "success";
		
	}

}
