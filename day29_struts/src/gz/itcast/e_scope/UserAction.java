package gz.itcast.e_scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	//这种用法有问题!!因为ActionContext对象的构造是通过拦截器创建的,而拦截器的执行是在创建UserAction之后
	/*ActionContext ac = null;
		
	public UserAction(){
		ac = ActionContext.getContext();
	}*/
	
	//业务方法是在拦截器之后被执行的,所有ActionContext被拦截器成功的创建。
	public String list()throws Exception{
		
		//1)从数据库得到数据
		List<String> list = new ArrayList<String>();
		list.add("eric");
		list.add("jacky");
		list.add("rose");
		
		//2) 用request，session，context域对象来共享数据
		/**
		 * 1)strus2提供的第一种使用域对象的方法(如果单纯的使用域对象来存取数据 ，不推荐使用这种方式)
		 * 	     ServletActionContext对象:可以在struts2的action方法中使用域对象
		 *    特点： 依赖servlet原生的api
		 */
		/*//获取request域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("request_list", list);
		//获取session域对象
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		session.setAttribute("session_list", list);
		//获取ServletContext域对象
		ServletContext context = ServletActionContext.getServletContext();
		context.setAttribute("context_list", list);*/
		
		//得到客户的请求的相关数据
		/**
		 * 注意: 如果用到了request/session/servletcontext对象中的除存取数据以外的其他方法，就必须得使用ServletActionContext
		 *     来获取数据。
		 */
		ServletActionContext.getRequest().getMethod();
		
		
		
		/*ActionContext ac = ActionContext.getContext();
		*//**
		 * 2)strus2提供的第二种使用域对象的方法(Action对象方法少的时候,可以使用这种方式)
		 *     ActionContext对象: action的上下文对象,在这个ActionContext对象中提供操作不同域对象数据的Map集合
		 *     
		 *     特点：
		 *     1) 不依赖servlet原生的api,方便测试
		 *     2)只能在action的某个业务方法中使用	
		 *//*
		
		
		//得到操作request域的map集合(操作这个Map集合就等同于操作了request域的数据)
		Map<String,Object> requestMap = ac.getContextMap();
		requestMap.put("request_list", list); //存放到request域中
		//得到操作session域的map集合
		Map<String,Object> sessionMap = ac.getSession();
		sessionMap.put("session_list", list);
		//得到操作context域的map集合
		Map<String, Object> contextMap = ac.getApplication();
		contextMap.put("context_list", list);*/
		
		
		return "success";
		
	}

}
