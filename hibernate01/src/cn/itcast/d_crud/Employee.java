package cn.itcast.d_crud;

import java.util.Date;

// 员工
public class Employee {

	private int id;
	private String name;
	private String dept;
	private Date birth;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;	
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
	@Override
	public String toString() {
		return "Employee [birth=" + birth + ", dept=" + dept + ", id=" + id
				+ ", name=" + name + "]";
	}
  
	
	
}