package cn.itcast.d_crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// 工具类
public class HibernateUtils {

	private static SessionFactory sessionFactory;
	static {
		sessionFactory = new Configuration()//
				.configure()//
				.buildSessionFactory();
	}
	
	/**
	 * 创建Session
	 */
	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
