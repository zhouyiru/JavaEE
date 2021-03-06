package cn.itcast.d_crud;

import java.util.Date;

import org.junit.Test;

public class TestEmployeeDao {
	
	private IEmployeeDao dao = new EmployeeDao();
    
	@Test
	public void testSave() {
		dao.save(new Employee());
        
	}
	
	@Test
	public void testDelete() {
		dao.delete(1);
	}

	@Test
	public void testFindById() {
		System.out.println(dao.findById(1));
	}

	@Test
	public void testGetAll() {
		System.out.println(dao.getAll());
	}

	@Test
	public void testGetAllIntInt() {
		System.out.println(dao.getAll(1, 1));
	}

	

	@Test
	public void testUpdate() {
		Employee e = new Employee();
		e.setId(1);
		e.setBirth(new Date());
		e.setName("Jack");
		
		dao.update(e);
	}

}
