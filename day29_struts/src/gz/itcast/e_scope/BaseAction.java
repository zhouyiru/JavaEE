package gz.itcast.e_scope;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 基础Action
 * 	在这个基础Action当前注入了三个域对象的操作Map集合
 * @author APPle
 *
 */
public class BaseAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{
	protected Map<String,Object> requestMap;
	protected Map<String,Object> sessionMap;
	protected Map<String,Object> contextMap;
	
	//struts2自动会把操作request域的map集合传入
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;
	}
	//struts2自动会把操作session域的map集合传入
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}
	//struts2自动会把操作context域的map集合传入
	public void setApplication(Map<String, Object> application) {
		this.contextMap = application;
	}
}
