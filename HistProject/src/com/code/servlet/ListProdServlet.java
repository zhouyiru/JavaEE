package com.code.servlet;

import com.code.dao.ProductDao;
import com.code.entity.Product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 商品列表的servlet
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class ListProdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1)读取到所有商品列表信息
		ProductDao dao = new ProductDao();
		List<Product> list = dao.findAll();
		
		//2)把商品显示到浏览器
		response.setContentType("text/html;charset=utf-8");
		String html = "";
		
		html += "<html>";
		html += "<head><title>查看商品列表</title></head>";
		html += "<body>";
		html += "<table border='1' align='center' width='600px'>";
		html += "<tr><th>编号</th><th>商品名称</th><th>商品型号</th><th>价格</th><th>查看详情</th></tr>";
		//2.1 遍历所有的商品，有几个商品有几行数据
		if(list!=null){
			for (Product product : list) {
				html += "<tr>";
				html += "<td>"+product.getId()+"</td>";
				html += "<td>"+product.getName()+"</td>";
				html += "<td>"+product.getType()+"</td>";
				html += "<td>"+product.getPrice()+"</td>";
				//访问DetailProdServlet同时传递一个名称为id的参数
				html += "<td><a href='"+request.getContextPath()+"/DetailProdServlet?id="+product.getId()+"'>查看</a></td>";
				html += "</tr>";
			}
		}

		html += "</table>";
		//3)显示浏览过的商品
		html += "<hr/>";
		html += "最近浏览过的商品:<br/>";
		//3.1)从cookie取出prodHist
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("prodHist")){
					String prodHist = cookie.getValue(); // 包含商品编号 。 3,2,1
					String[] ids = prodHist.split(",");
					for (String id : ids) {//取出每个商品编号
						//使用商品编号查询对应的商品
						Product p = dao.findById(id);
						//显示商品信息
						html += ""+p.getId()+"&nbsp;"+p.getName()+"&nbsp;"+p.getPrice()+"<br/>";
					}
					break;
				}
			}
		}

		html += "</body>";
		html += "</html>";
		
		response.getWriter().write(html);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

