package cn.it.dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.it.dao.utils.MybatisSessionFactory;
import cn.it.entity.Dept;

public class DeptDaoImpl {
	
	SqlSession session;
	/*
	 * 1.读取配置文件信息
	 * 2。构建session工厂
	 * 3。创建session
	 * 4.开启事务（可选）
	 * 5。处理数据
	 * 6。提交、回滚事务
	 * 7。关闭session 
	 * 
	 */
	/**
	 * @Title: save
	 * @auth:chufeng
	 * @Description: 添加部门信息
	 * @param @param dept
	 * @param @return
	 * @return int 返回类型
	*/ 
	public int save(Dept dept){
		int i =0;		
		try {

			session = MybatisSessionFactory.getSession();

			i = session.insert("cn.it.entity.DeptMapper.insertDept", dept);
			//提交事务
			 session.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.rollback();
		}finally{			
			try {
				MybatisSessionFactory.closeSession();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}
	
	//修改部门信息
	public int update(Dept dept){
		int i = 0 ;
		try {
			session=MybatisSessionFactory.getSession();
			i = session.update("cn.it.entity.DeptMapper.updateDept",dept);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.rollback();
		}finally{
			try {
				MybatisSessionFactory.closeSession();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return i;
	}
	
	//根据部门编号删除部门
	public int delete(Integer id){
		int i = 0 ;
		try {
			session=MybatisSessionFactory.getSession();
			i = session.delete("cn.it.entity.DeptMapper.deleteDept",id);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.rollback();
		}finally{
			try {
				MybatisSessionFactory.closeSession();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return i;
	}
	
	//根据部门编号查询单个部门
	public Dept selectOne(Integer id){
		Dept dept =null;
		try {
			session=MybatisSessionFactory.getSession();
			dept = session.selectOne("cn.it.entity.DeptMapper.selectDept",id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				MybatisSessionFactory.closeSession();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dept;
	}
	
	//根据部门地址查询多个部门
		public List<Dept> selectList(String deptAddress){
			List<Dept> depts =null;
			try {
				session=MybatisSessionFactory.getSession();
				depts = session.selectList("cn.it.entity.DeptMapper.selectList",deptAddress);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					MybatisSessionFactory.closeSession();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return depts;
		}

}
