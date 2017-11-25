package cn.it.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.it.dao.impl.DeptDaoImpl;
import cn.it.entity.Dept;

public class TestDeptDaoImpl {
	private static DeptDaoImpl deptDaoImpl;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		deptDaoImpl = new DeptDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		deptDaoImpl = null;
	}

	
	@Test
	public void testSelectListUseIf() {
		Dept paramDept = new Dept();
/*		paramDept.setDeptId(1);
		paramDept.setDeptName("研发部一部");
		paramDept.setDeptAddress("广州");*/
		List<Dept> depts = deptDaoImpl.selectListUseIf(paramDept);
		for (Dept dept : depts) {
			System.out.println("部门信息："+dept);
		}
	}
	
	@Test
	public void testSelectListUseWhere() {
		Dept paramDept = new Dept();
		//paramDept.setDeptId(1);
		//paramDept.setDeptName("研发部一部");
		//paramDept.setDeptAddress("广州");
		List<Dept> depts = deptDaoImpl.selectListUseWhere(paramDept);
		for (Dept dept : depts) {
			System.out.println("部门信息："+dept);
		}
	}
	
	@Test
	public void testSelectListUseChoose() {
		Dept paramDept = new Dept();
		//paramDept.setDeptId(1);
		//paramDept.setDeptName("研发部一部");
		paramDept.setDeptAddress("广州");
		List<Dept> depts = deptDaoImpl.selectListUseChoose(paramDept);
		for (Dept dept : depts) {
			System.out.println("部门信息："+dept);
		}
	}
	
	@Test
	public void testUpdateDeptUseChoose() {
		Dept paramDept = new Dept();
		paramDept.setDeptId(1);
		paramDept.setDeptName("研发中心");
		paramDept.setDeptAddress("武汉2");
		System.out.println("受影响的行数："+deptDaoImpl.updateDeptUseChoose(paramDept));		
	}
	
	@Test
	public void testSelectListUseForeach() {
		List<Integer> deptIds = new ArrayList<Integer>();
		deptIds.add(1);
		deptIds.add(3);
		deptIds.add(6);
		List<Dept> depts = deptDaoImpl.selectListUseForeach(deptIds);
		for (Dept dept : depts) {
			System.out.println("部门信息："+dept);
		}
	}
	
	@Test
	public void testInsertDeptUseInclude() {
		Dept dept = new Dept();
		dept.setDeptName("市场3部");
		dept.setDeptAddress("东莞");
		System.out.println("受影响的行数："+ deptDaoImpl.insertDeptUseInclude(dept));
	}
	


}
