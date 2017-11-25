package cn.itcast.b_tx_jdbc_anno;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository    // 当期类加入ioc容器
public class DeptDao implements IDeptDao {

	// 注入JdbcTemplate对象
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void save() {
		jdbcTemplate.update("insert into t_dept(deptName)values('test..')");
	}
}
