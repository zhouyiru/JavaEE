package gz.itcast.e_scope;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ����Action
 * 	���������Action��ǰע�������������Ĳ���Map����
 * @author APPle
 *
 */
public class BaseAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{
	protected Map<String,Object> requestMap;
	protected Map<String,Object> sessionMap;
	protected Map<String,Object> contextMap;
	
	//struts2�Զ���Ѳ���request���map���ϴ���
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;
	}
	//struts2�Զ���Ѳ���session���map���ϴ���
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}
	//struts2�Զ���Ѳ���context���map���ϴ���
	public void setApplication(Map<String, Object> application) {
		this.contextMap = application;
	}
}
