package org.fkit.hrm.domain;



public class Job implements java.io.Serializable{

	private Integer id;			// id
	private String name;		// ְλ����
	private String remark;		// ��ϸ����
	// �޲���������
	public Job() {
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
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return this.remark;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}

}