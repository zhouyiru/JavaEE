package org.fkit.hrm.domain;


public class Notice implements java.io.Serializable{

	private Integer id;		// ���
	private String title;   // ����
	private String content; // ����
	private java.util.Date createDate;  // ��������
	private User user;		// ������
	// �޲���������
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	// setter��getter����
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return this.content;
	}
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate(){
		return this.createDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content
				+ ", createDate=" + createDate + ", user=" + user + "]";
	}
	
	

}