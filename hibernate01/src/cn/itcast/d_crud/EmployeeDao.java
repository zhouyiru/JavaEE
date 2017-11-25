package cn.itcast.d_crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDao implements IEmployeeDao {

	@Override
	public void delete(Serializable id) {
		Session session = null;
		try {
			// 创建session
			session = HibernateUtils.getSession();
			// 开启事务
			Transaction tx = session.beginTransaction();
			// -- 先查询， 再删除 ---
			Object obj = session.get(Employee.class, id);
			// 判断
			if (obj != null) {
				session.delete(obj);
			}
			
			// 提交事务
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭session
			session.close();
		}
		

	}

	@Override
	public Employee findById(Serializable id) {
		Session session = null;
		Employee emp = null;
		try {
			session = HibernateUtils.getSession();
			Transaction tx = session.beginTransaction();
			//-- 主键查询 --
			emp = (Employee) session.get(Employee.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return emp;
	}

	@Override
	public List<Employee> getAll() {
		Session session = null;
		List<Employee> list = null;
		try {
			session = HibernateUtils.getSession();
			Transaction tx = session.beginTransaction();
			list = session.createQuery("from Employee").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Employee> getAll(int index, int count) {
		Session session = null;
		List<Employee> list = null;
		try {
			session = HibernateUtils.getSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("from Employee");

			// --- 获取总记录数相关代码 ----
			ScrollableResults r = q.scroll(); // 获取结果集
			r.last();		// 滚动到结果集的最后一行
			int totalCount = r.getRowNumber() + 1;
			System.out.println("总记录数: " + totalCount);

			q.setFirstResult(index);
			// 设置查询返回行数
			q.setMaxResults(count);
			
			
			// 执行查询
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void save(Employee emp) {
		
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			Transaction tx = session.beginTransaction();
			// -- 保存 -- 
			session.save(emp);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭session
			session.close();
		}
	}

	@Override
	public void update(Employee emp) {

		Session session = null;
		try {
			session = HibernateUtils.getSession();
			Transaction tx = session.beginTransaction();
			// -- 保存 -- 
			session.update(emp);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭session
			session.close();
		}

	}

}
