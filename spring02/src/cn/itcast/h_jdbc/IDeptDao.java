package cn.itcast.h_jdbc;

import java.io.Serializable;
import java.util.List;

// 接口
public interface IDeptDao {

	public void save(Dept dept);
	public void update(Dept dept);
	public void delete(Serializable id);
	public Dept findById(Serializable id);
	public List<Dept> getAll();
	

}