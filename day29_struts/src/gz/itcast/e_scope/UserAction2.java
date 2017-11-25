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
 * 3）strus2提供的第三种使用域对象的方法（当Action对象的方法比较多的时候，推荐使用这种方法）
 *   通过struts2提供的接口注入到Action对象中
 *   	特点: 
 *   		1)必须依赖struts2接口
 *   		2)可以在action对象的所有业务方法中使用!!
 * @author APPle
 *
 */
public class UserAction2 extends BaseAction{

	
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
