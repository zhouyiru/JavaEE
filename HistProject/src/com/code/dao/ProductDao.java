package com.code.dao;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.code.entity.Product;
import com.code.util.xmlutil;

public class ProductDao {

	public List<Product> findAll(){
		Document doc = xmlutil.getDocument();
	
		@SuppressWarnings("unchecked")
		List<Element> prolist = doc.getRootElement().elements("product");
		List<Product> list = new ArrayList<Product>();
		for (Element proElem : prolist) {
			Product p = new Product();
			p.setId(proElem.attributeValue("id"));
			p.setName(proElem.elementText("name"));
			p.setType(proElem.elementText("type"));
			p.setPrice(proElem.elementText("price"));
			list.add(p);
		}
		return list;
	}
	public Product findById(String id){
		Document doc = xmlutil.getDocument();
		Element proElem = (Element)doc.selectSingleNode("//product[@id='"+id+"']");
		Product p = null;
		if(proElem!=null){
			p = new Product();
			p.setId(proElem.attributeValue("id"));
			p.setName(proElem.elementText("name"));
			p.setType(proElem.elementText("type"));
			p.setPrice(proElem.elementText("price"));
		}
		return p;
	}
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
	    List<Product> list = dao.findAll();
		for (Product product : list) {
			System.out.println(product);
		}
		
		/*Product p = dao.findById("2");
		System.out.println(p);*/
		}
	}
	

