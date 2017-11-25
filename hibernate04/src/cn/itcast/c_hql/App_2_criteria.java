package cn.itcast.c_hql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class App_2_criteria {

	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)
			.addClass(Employee.class)
			.buildSessionFactory();
	}
	//1. QBC 查询
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
		
		// 获取Criteria查询接口
		Criteria c = session.createCriteria(Dept.class);
		// 1. 主键条件
		//c.add(Restrictions.idEq(1));
		
		// 2. 等值条件查询
		//c.add(Restrictions.eq("deptName", "hr"));
		
		// 3. 模糊查询
		//c.add(Restrictions.like("deptName", "%h%"));

		// 4. map 作为条件，map的key就是bean的属性
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("deptName", "hr");
//		map.put("id", 100);
//		c.add(Restrictions.allEq(map));
		
		// 5. example 查询
		Dept dept = new Dept();
		//dept.setId(1000); // 不起作用
		dept.setDeptName("hr");
		// 把对象的非主键属性作为条件  （自动把对象的非空属性值作为查询条件）
		c.add(Example.create(dept));
		
		
		
		// 查询全部
		List<Dept> list = c.list();
		System.out.println(list);
		
		session.getTransaction().commit(); 
		session.close();
		
	}
}












