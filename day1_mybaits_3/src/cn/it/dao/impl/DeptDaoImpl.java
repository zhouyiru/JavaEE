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

	// 使用if动态生成sql
	public List<Dept> selectListUseIf(Dept dept) {
		List<Dept> depts = null;
		try {
			session = MybatisSessionFactory.getSession();
			depts = session.selectList(
					"cn.it.entity.DeptMapper.selectListUseIf", dept);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				MybatisSessionFactory.closeSession();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return depts;
	}

	// 使用where动态生成sql
	public List<Dept> selectListUseWhere(Dept dept) {
		List<Dept> depts = null;
		try {
			session = MybatisSessionFactory.getSession();
			depts = session.selectList(
					"cn.it.entity.DeptMapper.selectListUseWhere", dept);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				MybatisSessionFactory.closeSession();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return depts;
	}

	// 使用choose动态生成sql
	public List<Dept> selectListUseChoose(Dept dept) {
		List<Dept> depts = null;
		try {
			session = MybatisSessionFactory.getSession();
			depts = session.selectList(
					"cn.it.entity.DeptMapper.selectListUseChoose", dept);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				MybatisSessionFactory.closeSession();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return depts;
	}
	// 使用Set动态生成sql
	public int updateDeptUseChoose(Dept dept) {
		int  i =0;
		try {
			session = MybatisSessionFactory.getSession();
			i = session.update("cn.it.entity.DeptMapper.updateDeptUseSet", dept);
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.rollback();
		} finally {
			try {
				MybatisSessionFactory.closeSession();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return i;
	}
	
	// 使用foreach动态生成sql
	public List<Dept> selectListUseForeach(List<Integer> deptIds) {
		List<Dept> depts = null;
		try {
			session = MybatisSessionFactory.getSession();
			depts = session.selectList(
					"cn.it.entity.DeptMapper.selectListUseForeach", deptIds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				MybatisSessionFactory.closeSession();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return depts;
	}
	
	// 使用include动态生成sql
		public int insertDeptUseInclude(Dept dept) {
			int  i =0;
			try {
				session = MybatisSessionFactory.getSession();
				i = session.insert("cn.it.entity.DeptMapper.insertDeptUseInclude", dept);
				session.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.rollback();
			} finally {
				try {
					MybatisSessionFactory.closeSession();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return i;
		}

}
