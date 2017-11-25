package cn.itcast.b_api;

/**
 *  javabean对象
 * @author AdminTH
 *
 */
public class Users {

	private int userId;
	private String userName;
	private int age;
	private String desc;  // 增加描述字段
	
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Users [age=" + age + ", userId=" + userId + ", userName="
				+ userName + "]";
	}
	
	
}
