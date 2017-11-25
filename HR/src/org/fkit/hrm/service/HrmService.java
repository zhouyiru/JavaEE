package org.fkit.hrm.service;

import java.util.List;

import org.fkit.hrm.domain.Dept;
import org.fkit.hrm.domain.Document;
import org.fkit.hrm.domain.Employee;
import org.fkit.hrm.domain.Job;
import org.fkit.hrm.domain.Notice;
import org.fkit.hrm.domain.User;
import org.fkit.hrm.util.tag.PageModel;

public interface HrmService {
	
    /////////////////////////////////////////////
	//用户管理服务层方法                                                                                     //
	////////////////////////////////////////////
	User login(String loginname,String password);
	
    int saveUser(User user); 
    
    List<User> selectAll();
    
    List<User> findUser(User user,PageModel pageModel);
    
    User selectUserByID(int id);
    
    int updateUser(User user);
    
    int deleteUser(int id);
    
    //////////////////////////////////////////////////////
	//部门管理服务层方法                                                                                                                 //
    //////////////////////////////////////////////////////
    void saveDept(Dept dept);
    void updateDept(Dept dept);
    void daleteDept(int id);   
    List<Dept> findDept(Dept dept,PageModel pageModel);   
    Dept selectDeptByID(int id);   
    List<Dept> selectAllDepts();
    
    
    ////////////////////////////////////////////////////////////////
    //职位服务层方法                                                                                                                                                      //
    ///////////////////////////////////////////////////////////////
    void saveJob(Job job);
    void updateJob(Job job);
    void deleteJob(int id);   
    List<Job> findJob(Job job,PageModel pageModel);   
    Job selectJobByID(int id);  
    List<Job> selectAllJobs();
    
    ////////////////////////////////////////////////////////////////
    //员工服务层方法                                                                                                                                                      //
    ///////////////////////////////////////////////////////////////   
    void saveEmployee(Employee employee);
    List<Employee> FindEmploy(Employee employee,PageModel pageModel);
    void deleteEmployee(int id);
    void updateEmployee(Employee employee);
    
    ////////////////////////////////////////////////////////////////
    //公告服务层方法                                                                                                                                                      //
    ///////////////////////////////////////////////////////////////     
    void saveNotice(Notice notice);
    List<Notice> FindNotice(Notice notice,PageModel pageModel);
    void  deleteNotice(int id);
    void updateNotice(Notice notice);
    Notice selectNoticeById(int id);
    
    
    ////////////////////////////////////////////////////////////////
    //文件服务层方法                                                                                                                                                      //
    ///////////////////////////////////////////////////////////////  
    void addDocument(Document document);
    List<Document> findDocument(Document document,PageModel pageModel);
    void deleteDocument(int id);
    Document findDocumentById(Integer id);
    
}
