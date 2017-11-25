package org.fkit.hrm.domain;

import java.io.Serializable;
import java.net.PasswordAuthentication;
import java.sql.Date;

public class User implements Serializable{

	private Integer id;
	private String username;
	private String loginname;
	private String password;
	private Integer status;
	private Date createdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", loginname="
				+ loginname + ", password=" + password + ", status=" + status
				+ ", createdate=" + createdate + "]";
	}
	
	
}
