package cn.itcast.b_tx_jdbc_anno;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptService implements IDeptService {

	@Resource
	private IDeptDao deptDao;
	
	@Resource
	private LogService logService;
	
	// 当前方法应用事务
	@Transactional(
			readOnly=false,      // 读写的事务，当修改数据时候用；如果查询就设置为true
			isolation=Isolation.DEFAULT,  // 事务隔离级别
			timeout=-1,			// 事务执行的超时时间, -1 表示不超时
			//noRollbackFor=ArithmeticException.class,   // 遇到指定的异常不回滚
			propagation=Propagation.REQUIRED      // 事务传播行为
	)
	public void save() {
		// 插入日志
		logService.insertLog();
		
		int i = 1/0;
		
		// 插入部门
		deptDao.save();
	}
}





