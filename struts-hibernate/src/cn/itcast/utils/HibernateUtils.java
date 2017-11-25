package cn.itcast.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {

	// 创建sessionFactory
	public static SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	// 返回连接
	public static Session getSession() {
		// 线程方式创建连接对象，要进行配置
		return sf.getCurrentSession();
	}
}
