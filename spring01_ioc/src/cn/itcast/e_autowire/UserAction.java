package cn.itcast.e_autowire;


public class UserAction {
	private IUserService userService;
	//接收IOC容器注入值
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public String execute(){
		userService.save();
		return "success";
	}
}
