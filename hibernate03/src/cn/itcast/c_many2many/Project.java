package cn.itcast.c_many2many;

import java.util.HashSet;
import java.util.Set;

// 项目
public class Project {

	private int id;
	private String name;
	
	// 保存多个开发人员
	private Set<Person> person = new HashSet<Person>();
	
	
	
	
	public Set<Person> getPerson() {
		return person;
	}
	public void setPerson(Set<Person> person) {
		this.person = person;
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
	
}
