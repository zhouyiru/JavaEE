package cn.itcast.c_composite;

import java.io.Serializable;

/**
 * 联合主键对象, 必须要实现可课序列化标记！ 
 */
public class CompositeKeys implements Serializable{

	private String name;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
