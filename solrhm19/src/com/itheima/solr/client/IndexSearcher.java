package com.itheima.solr.client;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

/**
 *  
 * <p>
 * Title: IndexSearcher
 * </p>
 *  
 * <p>
 * Description: TODO(这里用一句话描述这个类的作用) 
 * <p>
 * <p>
 * Company: www.itcast.com
 * </p>
 *  @author 传智.关云长   @date 2015-12-28 下午3:50:48    @version 1.0
 */
public class IndexSearcher {

	@Test
	public void search01() throws Exception {
		// 创建HttpSolrServer
		HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr");
		// 创建SolrQuery对象
		SolrQuery query = new SolrQuery();
		// 输入查询条件
		query.setQuery("product_name:小黄人");
		// 执行查询并返回结果
		QueryResponse response = server.query(query);
		// 获取匹配的所有结果
		SolrDocumentList list = response.getResults();
		// 匹配结果总数
		long count = list.getNumFound();
		System.out.println("匹配结果总数:" + count);
		for (SolrDocument doc : list) {
			System.out.println(doc.get("id"));
			System.out.println(doc.get("product_name"));
			System.out.println(doc.get("product_catalog"));
			System.out.println(doc.get("product_price"));
			System.out.println(doc.get("product_picture"));
			System.out.println("=====================");
		}
	}

	@Test
	public void search02() throws Exception {
		// 创建HttpSolrServer
		HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr");
		// 创建SolrQuery对象
		SolrQuery query = new SolrQuery();

		// 输入查询条件
		query.setQuery("product_name:小黄人");
		// query.set("q", "product_name:小黄人");

		// 设置过滤条件
		// 如果设置多个过滤条件的话，需要使用query.addFilterQuery(fq)
		query.setFilterQueries("product_price:[1 TO 10]");

		// 设置排序
		query.setSort("product_price", ORDER.asc);
		// 设置分页信息（使用默认的）
		query.setStart(0);
		query.setRows(10);

		// 设置显示的Field的域集合
		query.setFields("id,product_name,product_catalog,product_price,product_picture");

		// 设置默认域
		query.set("df", "product_keywords");

		// 设置高亮信息
		query.setHighlight(true);
		query.addHighlightField("product_name");
		query.setHighlightSimplePre("<em>");
		query.setHighlightSimplePost("</em>");

		// 执行查询并返回结果
		QueryResponse response = server.query(query);
		// 获取匹配的所有结果
		SolrDocumentList list = response.getResults();
		// 匹配结果总数
		long count = list.getNumFound();
		System.out.println("匹配结果总数:" + count);

		// 获取高亮显示信息
		Map<String, Map<String, List<String>>> highlighting = response
				.getHighlighting();
		for (SolrDocument doc : list) {
			System.out.println(doc.get("id"));

			List<String> list2 = highlighting.get(doc.get("id")).get(
					"product_name");
			if (list2 != null)
				System.out.println("高亮显示的商品名称：" + list2.get(0));
			else {
				System.out.println(doc.get("product_name"));
			}

			System.out.println(doc.get("product_catalog"));
			System.out.println(doc.get("product_price"));
			System.out.println(doc.get("product_picture"));
			System.out.println("=====================");
		}
	}
}
