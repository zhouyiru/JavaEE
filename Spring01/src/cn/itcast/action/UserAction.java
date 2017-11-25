package cn.itcast.action;

import java.util.Set;

import org.junit.Test;

import cn.itcast.service.UserService;

/*
 *  多例Action实例：   在访问的时候创建对象！
 */
public class UserAction {
	
	// 判断一个类是单例还是多例，主要看有没有维护成员变量、且对象成员变量进行修改！ 如果有，这个类就应该是多例！
	// 创建Service:   单例，  启动时候创建 
	private UserService userService ;//= new UserService();
	// 提供set方法，给外部容器注入
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute(){
		userService.save();
		return "success";
	}
}
