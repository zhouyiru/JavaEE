package cn.itcast.b_tx_jdbc_anno;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	// 事务控制
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void insertLog() {
		jdbcTemplate.update("insert into t_log values('在插入部门....')");
	}
	
}
