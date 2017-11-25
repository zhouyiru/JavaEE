package cn.itcast.c_hql;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App_3_sqlquery {

	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)
			.addClass(Employee.class)
			.buildSessionFactory();
	}
	@Test
	public void test_criteria() {
		Session session = sf.openSession();
		session.beginTransaction();
		/*Query接口中方法
		Query q = session.createQuery("");
		q.list();
		q.uniqueResult();
		q.iterate();
		q.executeUpdate();
		q.setFirstResult(0);
		q.setMaxResults(0); */
		
		// 本地sql查询
		
//		SQLQuery q = session.createSQLQuery("select * from t_dept");
//		List<Object[]> list =  q.list();  // 把每一行数据封装为Object[] ，再添加到list集合
//		System.out.println(list);
		
		// 把查询到的结果，自动封装为对象 （对象必须有映射文件）
		SQLQuery q = session.createSQLQuery("select * from t_dept");
		q.addEntity(Dept.class);
		// 会自动封装对象
		List<Dept> list = q.list();
		System.out.println(list);
		
		
		//session.getNamedQuery("");
		
		session.getTransaction().commit(); 
		session.close();
		
	}
}












