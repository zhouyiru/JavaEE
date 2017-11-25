package cn.it.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.it.entity.Goods;
import cn.it.entity.LuceneDaoImpl;

public class TestLucene {
	
	private static LuceneDaoImpl luceneDaoImpl;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		luceneDaoImpl = new LuceneDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		luceneDaoImpl = null;
	}

	@Test
	public void testSaveGoods() {
		Goods goods = new Goods();
		goods.setGoodsId(3);
		goods.setGoodsName("goods three 2");
		goods.setGoodsPrice(11.1);
		goods.setGoodsRemark("goods three 2 is good");
		luceneDaoImpl.saveGoods(goods);
	}
	
	@Test
	public void testSelectGoods() {
	
		List<Goods> list = luceneDaoImpl.selectGoods("three");
		for(Goods goods: list){
			System.out.println("商品信息："+goods);
		}
	}
	@Test
	public void testUpdateGoods() {
	
		Goods goods = new Goods();
		goods.setGoodsId(3);
		goods.setGoodsName("goods three 4");
		goods.setGoodsPrice(33.3);
		goods.setGoodsRemark("goods three 4 is good");
		luceneDaoImpl.updateGoods(goods);
	}
	
	@Test
	public void testDeleteGoods() {
	
		Goods goods = new Goods();
		goods.setGoodsId(3);
		
		luceneDaoImpl.deleteGoods(goods);
	}

}
