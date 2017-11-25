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

public class BookAction extends BaseAction{
	
	public String list()throws Exception{
		
		//1)从数据库得到数据
		List<String> list = new ArrayList<String>();
		list.add("eric");
		list.add("jacky");
		list.add("rose");
		
		//往request域存放数据
		requestMap.put("request_list", list);
		//往session域存放数据
		sessionMap.put("session_list", list);
		//往context域存放数据
		contextMap.put("context_list", list);
		
		return "success";
		
	}
	

	

	

}
