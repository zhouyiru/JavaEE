package cn.itcast.c_many2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sf;
	static {
		sf = new Configuration()
			.configure()
			.addClass(Person.class)
			.addClass(Project.class)
			.buildSessionFactory();
	}
	
	// 保存数据， 不能重复维护关系！
	// inverse=true  如果没有控制权，不能维护关系！ 不能往中间插入记录！
	@Test
	public void test_save() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 创建对象
		Project p_oa = new Project();
		p_oa.setName("OA项目");
		Project p_crm = new Project();
		p_crm.setName("CRM项目");
		
		Person p_wl = new Person();
		p_wl.setName("王磊");
		Person p_lc = new Person();
		p_lc.setName("刘昌");
		
		// 关系  【crm： 王磊/刘昌】  
		p_crm.getPerson().add(p_wl);
		p_crm.getPerson().add(p_lc);
		// 【OA:  王磊】
		p_oa.getPerson().add(p_wl);
		
		// p_wl.getProjects().add(p_oa); 错误， 不能重复维护！ 因为每次维护关系，都是往中间表插入记录，所有不能重复插入！
		
		// 保存
		session.save(p_crm);
		session.save(p_oa);
		session.save(p_wl);
		session.save(p_lc);
		
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	// 通过一方获取另外一方
	@Test
	public void test_get() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		// 主键查询项目
		Project prj =(Project) session.get(Project.class, 1);
		System.out.println(prj.getName());
		/*
		 * lazy
		 * 		true  set集合默认懒加载(在映射中关联数据默认都是懒加载)
		 * 		false 关闭懒加载
		 *      extra 懒加载，在真正使用数据的时候，才向数据库发送查询的sql； 当前执行集合的isEmpty()/size()方法的时候，只是统计!
		 */
		//System.out.println(prj.getPerson());// set集合默认是懒加载 
		
//		//prj.getPerson().isEmpty();
		prj.getPerson().size();
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	// 解除关系
	// inverse=false, 有控制权，可以解除关系，指删除中间表数据！
	//         true, 不能解除，没有执行任何操作！
	@Test
	public void test_releaseRealtion() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Project prj =(Project) session.get(Project.class, 1);
		prj.getPerson().clear(); // 清空集合数据，提交事务时候，会反映到数据库中 （持久化对象）
		
		session.getTransaction().commit();
		session.close();
	}
	// inverse=false, 删除数据时候，会先删除中间表数据，再删除自身！
	//         true, 只有删除的数据没有被关联的时候，才可以删除！
	@Test
	public void test_deleteDate() {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Project prj =(Project) session.get(Project.class, 1);
		session.delete(prj);
		
		session.getTransaction().commit();
		session.close();
	}
}












