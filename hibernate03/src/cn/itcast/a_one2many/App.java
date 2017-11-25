package cn.itcast.a_one2many;

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
		
		/*
		 * 关系, 通过一的一方维护 （不推荐）
		 */
//		dept.getEmployees().add(emp1);
//		dept.getEmployees().add(emp2);
//		// 保存
//		session.save(emp1);
//		session.save(emp2);
//		session.save(dept);
		
		/*
		 * 关系，通过多的一方维护
		 */
//		emp1.setDept(dept);
//		emp2.setDept(dept);
		// 保存
		session.save(dept);
		session.save(emp1);
		session.save(emp2);  // 保存的时候，会保存关联的对象！
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	// B. 通过其中一方获取另外一方
	@Test
	public void test_get() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, 2);
		System.out.println(dept.getDeptName());
		System.out.println(dept.getEmployees());
		
		session.getTransaction().commit();
		session.close();
	}
	
	// C. 解除关系
	@Test
	public void test_releaseRelation() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 主键查询
		//Dept dept = (Dept) session.get(Dept.class, 1);
		// 解除关系
		//dept.getEmployees().clear();
		//session.update(dept);
		
		
		Employee emp = (Employee) session.get(Employee.class, 1);
		// 解除员工与部门的关系
		emp.setDept(null);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	// D. 删除数据，对关系的影响！
	@Test
	public void test_deleteData() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, 2);
		// 删除部门
		session.delete(dept);
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	@Test
	public void back() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.getTransaction().commit();
		session.close();
	}
}












