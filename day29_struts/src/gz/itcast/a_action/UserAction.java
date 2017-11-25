package gz.itcast.a_action;

import com.opensymphony.xwork2.Action;
/**
 * 第二种方式：实现Action接口
 * 	1)定义了默认的execute方法的标准
 *  2）提供了项目中常用的视图标记
 * @author APPle
 *
 */
public class UserAction implements Action {

	public String login() throws Exception {
		System.out.println("执行了UserAction的login方法");
		return SUCCESS;
	}

	public String execute() throws Exception {
		return null;
	}

}
