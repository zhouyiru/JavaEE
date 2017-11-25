package cn.itcast.h_query;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)
			.addClass(Employee.class)
			.buildSessionFactory();
	}
	
	// 	A. 保存
	@Test
	public void test_save() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 保存的时候，最后通过的一方维护关联关系！ 这样可以少生产sql update语句
		
		// 部门
		Dept dept = new Dept();
		dept.setDeptName("应用开发部");
		
		// 员工
		Employee emp1 = new Employee();
		emp1.setName("王晓杰");
		
		Employee emp2 = new Employee();
		emp2.setName("赵欢");
		// 关系
		dept.getEmployees().add(emp1);
		dept.getEmployees().add(emp2);
		
		// 保存 
		session.save(dept);  // cascade="save-update" 设置后，保存对象，会保存关联的对象！
//		session.save(emp1);
//		session.save(emp2);  // 保存的时候，会保存关联的对象！
		
		session.getTransaction().commit();
		session.close();
	}
	
	/*
	 *  查询
	 */
	@Test
	public void query() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 1. 主键查询
		Dept dept = (Dept) session.get(Dept.class, 3);
		// 2. 对象导航
		System.out.println(dept.getEmployees());
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void hql_1() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//3. hql查询
		// a. 查询所有列
//		Query q = session.createQuery("from Dept");
//		Query q = session.createQuery("from Dept d");
		// 错误，hql不能用 *
		//Query q = session.createQuery("select * from Dept");
		// 可以这样写
		//Query q = session.createQuery("select d from Dept d");
		
		// b. 查询指定的列
		// 注意： 一旦指定了查询的列，返回的就不是对象了！
		Query q = session.createQuery("select d.id,d.deptName from Dept d");
		List<Object[]> list = q.list();
		// 迭代
		for (Object[] obj : list) {
			//System.out.println(Arrays.toString(obj));
			System.out.print(obj[0]);
			System.out.println(obj[1]);
		}
		System.out.println("===========");
		
		// c. 查询指定的列，自动封装为对象
		q = session.createQuery("select new Dept(d.id,d.deptName) from Dept d");
		System.out.println(q.list());
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void hql_condition() {
		// 查询条件
		String name = "应用开发部";
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 条件查询
		//Query q = session.createQuery("from Dept where deptName='"+name+"'");
		
		// 占位符
//		Query q = session.createQuery("from Dept where deptName=?");
//		q.setParameter(0, name);  // jdbc参数是从1开始，这里从0开始！
		
		// 命名参数查询
//		Query q = session.createQuery("from Dept where deptName = :name_");
//		q.setParameter("name_", name);
		
		// 从配置文件中，读取hql，便于后期维护
		Query q = session.getNamedQuery("my_hql_select");
		//q.setParameter("name_", name);
		
		
		System.out.println(q.list());
		
		session.getTransaction().commit();
		session.close();
	}
}












