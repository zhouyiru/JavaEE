package cn.itcast.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.dao.IDeptDao;
import cn.itcast.entity.Dept;

// dao 实现
public class DeptDao extends HibernateDaoSupport implements IDeptDao {


	@Override
	public Long getTotalCount() {
		return getHibernateTemplate().execute(new HibernateCallback<Long>() {
			@Override
			public Long doInHibernate(Session session)
					throws HibernateException, SQLException {
				Long num = 
					(Long) session.createQuery("select count(*) from Dept").uniqueResult();
				return num;
			}
		});
	}
	
	@Override
	public void delete(Serializable id) {
		getHibernateTemplate().bulkUpdate("delete from Dept where id=" + id);
	}
	
	@Override
	public List<Dept> getAll(final int index, final int count) {
		List<Dept> list = getHibernateTemplate().execute(new HibernateCallback<List<Dept>>() {

			@Override
			public List<Dept> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session.createQuery("from Dept");
				q.setFirstResult(index);
				q.setMaxResults(count);
				return q.list();
			}
		});
		return list;
	}
	

	@Override
	public Dept findById(Serializable id) {
		return getHibernateTemplate().get(Dept.class, id);
	}

	@Override
	public List<Dept> getAll() {
		return getHibernateTemplate().loadAll(Dept.class); // 也可以用hql查询
	}

	@Override
	public void save(Dept dept) {
		getHibernateTemplate().save(dept);
	}

	@Override
	public void update(Dept dept) {
		getHibernateTemplate().update(dept);
	}

}
