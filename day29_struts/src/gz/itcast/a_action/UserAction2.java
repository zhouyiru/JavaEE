package gz.itcast.a_action;
/**
 * 第一种方式：不需要实现或继承任何接口或类
 * @author APPle
 *
 */
public class UserAction2 {

	public String login()throws Exception{
		System.out.println("UserAction2.login()");
		return "success";
	}
	
}
