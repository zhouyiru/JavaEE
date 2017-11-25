package org.fkit.hrm.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fkit.hrm.dao.DeptDao;
import org.fkit.hrm.dao.DocumentDao;
import org.fkit.hrm.dao.EmployeeDao;
import org.fkit.hrm.dao.JobDao;
import org.fkit.hrm.dao.NoticeDao;
import org.fkit.hrm.dao.UserDao;
import org.fkit.hrm.domain.Dept;
import org.fkit.hrm.domain.Document;
import org.fkit.hrm.domain.Employee;
import org.fkit.hrm.domain.Job;
import org.fkit.hrm.domain.Notice;
import org.fkit.hrm.domain.User;
import org.fkit.hrm.service.HrmService;
import org.fkit.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService {
	
	/*�Զ�ע��Dao�����*/
	@Autowired
	private UserDao userDao;
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private JobDao jobDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private DocumentDao documentDao;
		
	@Override
	@Transactional(readOnly=true)
	public User login(String loginname, String password) {
		
		return userDao.selectByLoginnameAndPassword(loginname, password);
	}


	@Override
	public int saveUser(User user) {		
		return userDao.insertUser(user);
	}


	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	
	/**
	 * HrmServiceImpl�ӿ�findUser����ʵ��
	 * @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public List<User> findUser(User user,PageModel pageModel) {
		/** ��ǰ��Ҫ��ҳ������������  */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("user", user);
		System.out.println("ʵ�ֲ�user:"+user);
		int recordCount = userDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** ��ʼ��ҳ��ѯ���ݣ���ѯ�ڼ�ҳ������ */
		    params.put("pageModel", pageModel);
	    }
		List<User> users = userDao.selectByPage(params);
		 
		return users;
	}


	@Override
	public User selectUserByID(int id) {
		// TODO Auto-generated method stub
		return userDao.selectById(id);
	}


	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}


	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteUserById(id);
	}


	///////////////////////////////////////////////
	//���ŵ�ʵ�ֺ���
	///////////////////////////////////////////////
	@Override
	public void saveDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.save(dept);
	}


	@Override
	public void updateDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.update(dept);
	}


	@Override
	public void daleteDept(int id) {
		// TODO Auto-generated method stub
	   deptDao.deleteById(id);
	}


	@Override
	public List<Dept> findDept(Dept dept, PageModel pageModel) {
		/** ��ǰ��Ҫ��ҳ������������  */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("dept", dept);
		System.out.println("ʵ�ֲ�dept:"+dept);
		int recordCount = deptDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** ��ʼ��ҳ��ѯ���ݣ���ѯ�ڼ�ҳ������ */
		    params.put("pageModel", pageModel);
	    }
		List<Dept> depts = deptDao.selectByPage(params);
		 
		return depts;
	}


	@Override
	public Dept selectDeptByID(int id) {
		// TODO Auto-generated method stub
		return deptDao.selectById(id);
	}

	
    @Override
	public List<Dept> selectAllDepts() {
		// TODO Auto-generated method stub
		return deptDao.selectAllDept();
	}


	////////////////////////////////////////////////////
	//ְλ�����ʵ�ַ���                                                                                                            //
	////////////////////////////////////////////////////
	@Override
	public void saveJob(Job job) {
	    jobDao.save(job);
	}


	@Override
	public void updateJob(Job job) {
		jobDao.update(job);
	}


	@Override
	public void deleteJob(int id) {
        jobDao.deleteById(id);
	}


	@Override
	public List<Job> findJob(Job job, PageModel pageModel) {
		/** ��ǰ��Ҫ��ҳ������������  */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("job", job);
		System.out.println("ʵ�ֲ�job:"+job);
		int recordCount = jobDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** ��ʼ��ҳ��ѯ���ݣ���ѯ�ڼ�ҳ������ */
		    params.put("pageModel", pageModel);
	    }
		List<Job> jobs = jobDao.selectByPage(params);
		 
		return jobs;
	}


	@Override
	public Job selectJobByID(int id) {
		// TODO Auto-generated method stub
		return jobDao.selectById(id);
	}


	@Override
	public List<Job> selectAllJobs() {
		// TODO Auto-generated method stub
		return jobDao.selectAllJob();
	}

	
	///////////////////////////////////////////////////
	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.save(employee);
	}


	@Override
	public List<Employee> FindEmploy(Employee employee, PageModel pageModel) {
		
		/** ��ǰ��Ҫ��ҳ������������  */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("employee", employee);
		System.out.println("ʵ�ֲ�employee:"+employee);
		int recordCount = employeeDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** ��ʼ��ҳ��ѯ���ݣ���ѯ�ڼ�ҳ������ */
		    params.put("pageModel", pageModel);
	    }
		List<Employee> employees = employeeDao.selectByPage(params);
		 
		return employees;
	}


	@Override
	public void deleteEmployee(int id) {
		
		employeeDao.deleteById(id);
		
	}


	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	///////////////////////////////////////////////////
	
	@Override
	public void saveNotice(Notice notice) {
		noticeDao.save(notice);
	}


	@Override
	public List<Notice> FindNotice(Notice notice, PageModel pageModel) {
		/** ��ǰ��Ҫ��ҳ������������  */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("notice", notice);
		System.out.println("ʵ�ֲ�notice:"+notice);
		int recordCount = noticeDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** ��ʼ��ҳ��ѯ���ݣ���ѯ�ڼ�ҳ������ */
		    params.put("pageModel", pageModel);
	    }
		List<Notice> notices = noticeDao.selectByPage(params);
		 
		return notices;
	}


	@Override
	public void deleteNotice(int id) {
		noticeDao.deleteById(id);
	}


	@Override
	public void updateNotice(Notice notice) {
		noticeDao.update(notice);
		
	}
	@Override
	public Notice selectNoticeById(int id)
	{
		return noticeDao.selectById(id);
	}

////////////////////////////////////////////////////////////////////////
	@Override
	public void addDocument(Document document) {
		documentDao.save(document);
		
	}


	@Override
	public List<Document> findDocument(Document document, PageModel pageModel) {
		
		/** ��ǰ��Ҫ��ҳ������������  */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("document", document);
		System.out.println("ʵ�ֲ�document:"+document);
		int recordCount = documentDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** ��ʼ��ҳ��ѯ���ݣ���ѯ�ڼ�ҳ������ */
		    params.put("pageModel", pageModel);
	    }
		List<Document> documents = documentDao.selectByPage(params);
		 
		return documents;
	}


	@Override
	public void deleteDocument(int id) {		
		documentDao.deleteById(id);
		
	}


	@Override
	public Document findDocumentById(Integer id) {
		// TODO Auto-generated method stub
		return documentDao.selectById(id);
	}
	
}
