package cn.itcast.c_hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App_1_hql {

	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Dept.class)
			.addClass(Employee.class)
			.buildSessionFactory();
	}
	//1. 1. 统计每个部门人数 
	@Test
	public void test_demo1() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query q = session.createQuery("select e.dept, count(*) from Employee e group by e.dept having count(*) > 1");
		List<Object[]> list = q.list();  // 返回的每一行记录封装在Object[]数据中
										 // 数据中第一个元素： dept对象
										 // 数据中第二个元素： 统计的记录结果
		
		session.getTransaction().commit(); 
		session.close();
		
	}
	
	// 2. 统计部门及部门下的员工
	@Test
	public void test_dempo2() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 内连接
//		Query q = session.createQuery("from Employee e inner join e.dept");// 多对一
		// 或者， 
//		Query q = session.createQuery("from Dept d inner join d.employees");// 一对多
		// 做外连接，
//		Query q = session.createQuery("from Employee e left join e.dept");// 多对一
		// 右外连接
		Query q = session.createQuery("from Dept d right join d.employees");// 多对一
		
		List<Object[]> list = q.list();
		// 迭代: 显示部门名称与员工名称
		for (int i = 0; i<list.size(); i++) {
			Object[] values = list.get(i);
			// 获取数组第一个元素
			Employee e = (Employee) values[0];
			// 获取数组第二个元素
			Dept d = (Dept) values[1];
			// 测试
			System.out.println(e.getName() + "," + d.getDeptName());
		}
		
		
		session.getTransaction().commit(); 
		session.close();
		
	}
	
	// 3. 迫切关联查询，始终会把“右表”数据填充到“左表”中！
	@Test
	public void test_dempo3() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//  迫切内连接, 会自动封装数据
		Query q = session.createQuery("from Employee e inner join fetch e.dept");
		q.list();
		
		//  迫切左外连接,
		q = session.createQuery("from Employee e left join fetch e.dept");
		q.list();
		
		
		/*
		 *  如何解决jsp页面访问懒加载报错问题？  如：显示员工，同时显示员工关联的部门名称！
		 *      连接查询！
		 *  
		 *  懒加载：
		 *  	1) 先用一下数据，   会先查询出来
		 *  	2) 强迫代理对象初始化
		 *  	3） session不关闭
		 *  	4)需要哪些数据，先查询出来！  ---> hql 连接查询
		 *  总结：
		 *  	要在session关闭前，把懒加载的数据拿出来！
		 *  
		 *  
		 */
		
		
		session.getTransaction().commit(); 
		session.close();
		
	}
	
	@Test
	public void test_dempo4() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		//  N + 1 
		// 显示员工，以及员工的部门
		Query q = session.createQuery("from Employee ");
		List<Employee> list = q.list();
		for (Employee e : list) {
			System.out.println(e.getName() + "," + e.getDept().getDeptName());
		}
		
		System.out.println("========");
		
		// N+1, 如何解决？
		q = session.createQuery("from Employee e left join fetch e.dept ");
		list = q.list();
		for (Employee e : list) {
			System.out.println(e.getName() + "," + e.getDept().getDeptName());
		}
		
		session.getTransaction().commit(); 
		session.close();
		
	}
}












