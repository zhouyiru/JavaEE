package cn.itcast.c_composite;

import java.util.Date;

// 员工
public class Employee {

	 // 名称、地址、部门、年龄
	
	// 联合主键对象
	private CompositeKeys keys;
	private String dept;
	private Date birth;
	

	
	public CompositeKeys getKeys() {
		return keys;
	}
	public void setKeys(CompositeKeys keys) {
		this.keys = keys;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	
}
