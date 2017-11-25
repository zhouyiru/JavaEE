package cn.itcast.h_jdbc;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DeptDao implements IDeptDao {
	
	// 接收容器注入的JdbcTemplate对象
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	// 1. 原始jdbc代码
	public void save(Dept dept) {
		jdbcTemplate.update("insert into t_dept(deptName) values(?)", dept.getName());
	}


	@Override
	public void delete(Serializable id) {
		jdbcTemplate.update("delete from t_dept where id=?", id);
	}
	
	@Override
	public void update(Dept dept) {
		jdbcTemplate.update("update t_dept set deptName=? where id=?", dept.getName(),dept.getId());
	}


	@Override
	public Dept findById(Serializable id) {
		// queryForList 把每一行都封装为map对象，再添加到list中
//		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_dept");
		
		// 传入类型参数，表示查询的列的类型；  这里只能查询一列
//		List<String> list = jdbcTemplate.queryForList("select deptName from t_dept", String.class);

		 List<Dept> list = jdbcTemplate.query("select * from t_dept where id=?",  new MyRowMapper(), id);
		
		return (list!=null&&list.size()>0)?list.get(0):null;
	}


	@Override
	public List<Dept> getAll() {
		List<Dept> list = jdbcTemplate.query("select * from t_dept", new MyRowMapper());
		return list;
	}
	
	
	
	// 封装Springjdbc查询的结果集
	class MyRowMapper implements RowMapper<Dept>{
		
		// 如何解析一行
		@Override
		public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
			Dept dept = new Dept();
			dept.setId(rs.getInt("id"));
			dept.setName(rs.getString("deptName"));
			return dept;
		}
		
	}
	
}














