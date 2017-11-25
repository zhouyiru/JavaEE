package cn.itcast.c_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 封装用户信息
public class Users {

	private int id;
	private String name;
	/*
	 *  用户对应的多个地址
	 */
	// set集合
	private Set<String> addressSet;
	// list集合
	private List<String> addressList = new ArrayList<String>();
	// map集合
	private Map<String,String> addressMap = new HashMap<String,String>();
	
	
	
	public Map<String, String> getAddressMap() {
		return addressMap;
	}
	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}
	public List<String> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
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
	public Set<String> getAddressSet() {
		return addressSet;
	}
	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}
	
	
	
	
}














