package com.code.servlet;

import com.code.dao.ProductDao;
import com.code.entity.Product;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ʾ��Ʒ�����servlet
 * @author APPle
 *
 */
@SuppressWarnings("serial")
public class DetailProdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1)����id�Ĳ���
		String id = request.getParameter("id");
		//2)��ѯָ��id����Ʒ����
		ProductDao dao = new ProductDao();
		Product product = dao.findById(id);
		//3)��ʾ���������
		response.setContentType("text/html;charset=utf-8");
		String html = "";
		
		html += "<html>";
		html += "<head><title>�鿴��Ʒ����</title></head>";
		html += "<body>";
		html += "<table border='1' align='center' width='250px'>";
		html += "<tr><th>���</th><td>"+product.getId()+"</td></tr>";
		html += "<tr><th>��Ʒ����</th><td>"+product.getName()+"</td></tr>";
		html += "<tr><th>��Ʒ�ͺ�</th><td>"+product.getType()+"</td></tr>";
		html += "<tr><th>�۸�</th><td>"+product.getPrice()+"</td></tr>";
		html += "</table>";
		html += "<center><a href='"+request.getContextPath()+"/ListProdServlet'>[������Ʒ�б�]</a></center>";
		html += "</body>";
		html += "</html>";
		
		response.getWriter().write(html);
		
		//4)����Cookie���󣬴�����������Ʒ���
		Cookie c = new Cookie("prodHist",getCookieValue(request,product.getId()));
		//5)���͵����������
		response.addCookie(c);
	}

	/**
	 *   ���� 
	 *     1�����ܳ���3�������3��
	 *     2�������ʵ���Ʒ������ǰ��
	 *     
	 * �÷��������������ɵ����������Ʒ�ı���б�
	 * 		���ڵ�ֵ                                               �����idֵ                                 ���յ�ֵ          �㷨
	 *     null��û��prodHist          1                  1              ֱ�ӷ��ش����id   
	 *         2,1                   1                  1,2        С��3������id���ظ��ģ� ɾ���ظ���id���Ѵ����id��ǰ��
	 *         2,1                   3                  3,2,1 С��3������idû���ظ��ģ�ֱ�ӰѴ����id��ǰ��
	 *         3,2,1                 2                  2,3,1 ����3������id���ظ��ģ� ɾ���ظ���id���Ѵ����id��ǰ��
	 *         3,2,1                 4                  4,3,2 ����3������idû���ظ��ģ�    ɾ����β��id���Ѵ����id��ǰ��                     
	 *       
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String getCookieValue(HttpServletRequest request,String id) {
		Cookie[] cookies = request.getCookies();
		String prodHist = null;
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("prodHist")){
					prodHist = cookie.getValue();
					break;
				}
			}
		}
		if(cookies==null || prodHist==null){
			// 1)ֱ�ӷ��ش����id 
			return id;
		}
		
		//3,10   1
		// �����������������������ж�Ԫ���Ƿ��ظ�  2��������ɾԪ������        ʹ�ü��ϣ� Collection   coll.contains(id): �ж�ָ��Ԫ���Ƿ����   
														//     List: ArrayList LinkedList(����)
		// String-> String[]
		String[] prodHists = prodHist.split(",");
		// String->Collection
		@SuppressWarnings("rawtypes")
		Collection colls = Arrays.asList(prodHists);
		// Collectoin->LinkedList
		@SuppressWarnings({ "rawtypes" })
		LinkedList list = new LinkedList(colls);
															
		if(list.size()<3){
			//���ظ���
			if(list.contains(id)){
				// ɾ���ظ���id���Ѵ����id��ǰ��
				list.remove(id);
				list.addFirst(id);
			}else{
				//ֱ�ӰѴ����id��ǰ��
				list.addFirst(id);
			}
		}else{
			//���ظ���
			if(list.contains(id)){
				// ɾ���ظ���id���Ѵ����id��ǰ��
				list.remove(id);
				list.addFirst(id);
			}else{
				//  ɾ����β��id���Ѵ����id��ǰ��                     
				list.removeLast();
				list.addFirst(id);
			}
		}				
		
		//List->String
		String str = "";
		for (Object obj : list) {
			str += obj+",";
		}
		//ȥ�����Ķ���
		str = str.substring(0, str.length()-1);
		return str;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

