package cn.itcast.e_aop_anno;

import org.springframework.stereotype.Repository;

@Repository			
public class OrderDao {
	
	public void save() {
		System.out.println("保存订单..");
	}
}



