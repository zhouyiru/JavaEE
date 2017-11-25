<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'listFile.jsp' starting page</title>  
  </head>
  
  <body>
    <table border="1" width="300px">
    	<tr>
    		<th>编号</th>
    		<th>文件名称</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${list}" var="file" varStatus="varSta">
    	<tr>
    		<td>${varSta.count }</td>
    		<td>${file }</td>
    		<td><a href="${pageContext.request.contextPath }/upload/down_down?name=${file}">下载</a></td>
    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
