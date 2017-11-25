package cn.it.dao.impl;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.it.entity.Dept;

public class DeptDaoImpl {
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
	public int save(Dept dept){
		int i =0;
		String path="myBatis-config.xml";
		SqlSession session = null;
		Reader reader = null;
		try {
			//获取配置文件的信息
			reader = Resources.getResourceAsReader(path);
			//构建sessionfactory
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//创建session
			session = sessionFactory.openSession();
			//启用事务，这里默认已启用
			//执行数据处理,第一个参数用“命名空间+sql id"来定位sql,第二个参数用来给sql传参数
			i = session.insert("cn.it.entity.DeptMapper.insertDept", dept);
			//提交事务
			 session.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.rollback();
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(session!=null){
				session.close();
			}
			
		}
		return i;
	}

}
