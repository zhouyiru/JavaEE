package cn.itcast.f_anno;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

//@Component("userAction")  // 加入IOC容器
//@Controller("userAction")  // 加入IOC容器
@Scope("prototype")		  // 指定加入ioc容器的对象为多例

@Controller
public class UserAction {
	
//	@Resource(name = "userService")  // ioc容器找名称是userService的对象并注入
	
	@Resource
	private IUserService userService;
	
	public String execute(){
		userService.save();
		return "success";
	}
}
