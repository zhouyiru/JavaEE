package cn.itcast.a_tx_jdbc;

public class DeptService implements IDeptService {

	// 注入dao
	private IDeptDao deptDao;
	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	public void save() {
		deptDao.save();
		int i = 1/0;
		deptDao.save();
	}
}
