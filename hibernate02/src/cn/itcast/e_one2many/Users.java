package cn.itcast.e_one2many;

import java.util.HashSet;
import java.util.Set;

// 用户
public class Users {

	private int id;
	private String name;
	private int age;
	// 用户与地址，是一对多的关系  【注意一定要用接口接收！】
	private Set<Address> address = new HashSet<Address>();
	
	
	
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
