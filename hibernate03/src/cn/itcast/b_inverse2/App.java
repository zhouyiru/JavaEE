package cn.itcast.b_inverse2;

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
	//  只有inverse=false 表示有控制权的时候，才可以保存数据、处理数据的关系！
	//  否则，只能保存各自数据！
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
		dept.getEmployees().add(emp1);
		dept.getEmployees().add(emp2);
		// 保存
		session.save(emp1);
		session.save(emp2);
		session.save(dept);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	// B. 通过其中一方获取另外一方
	// 是否设置inverse属性，对获取数据没有影响！  (只要配置关系，就可以加载到关联数据！)
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
	// inverse=false , 即有控制权才可以解除关系！  
	// 如果为true, 没有控制权，不能解除关系（不报错）!
	@Test
	public void test_releaseRelation() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 主键查询
		Dept dept = (Dept) session.get(Dept.class, 2);
		//解除关系
		dept.getEmployees().clear();
		
		
		Employee emp = (Employee) session.get(Employee.class, 1);
		// 解除员工与部门的关系
		emp.setDept(null);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	// D. 删除数据，对关系的影响！
	// inverse=true, 如果数据有被其他外键关联，不能删除数据，报违反主外键约束错误！
	//         true, 数据没有没其他表引用，可以直接删除！ 
	// inverse = false, 有控制权，  始终可以删除！ 先清空所有引用，再删除自身！
	@Test
	public void test_deleteData() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Dept dept = (Dept) session.get(Dept.class, 3);
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












