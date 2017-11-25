package cn.itcast.c_many2many;

import java.util.HashSet;
import java.util.Set;
// 开发人员
public class Person {

	private int personId;
	private String name;
	
	//参与的多个项目
	private Set<Project> projects = new HashSet<Project>();
	
	
	
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
