<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Employee.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


  <script>
  function areYouSure(id)
  {
  
      if(window.confirm("确定要删除本条记录吗？"))
      {
      window.location.href="DeleteEmployee?id="+id;
      }    
  }
  </script>
  </head>
  
  <body>
  <table>
  <tr><td>
  <form action="Employee" method="post">
        员工姓名:<input type="text" name="name"> <br>
        电话：<input type="text" name=phone><br>
       身份证号码：<input type="text" name="cardId"><br>
  <input type="submit" value="搜索">
  </form>
  </td></tr>
  </table>
  <table>
  <tr>
  <th>id</th><th>name</th><th>time</th><th>dept_name</th><th>job_name</th>
  </tr>
  <c:forEach items="${requestScope.employees}"
  var="employee" >
  <tr>
  <td>${employee.id}</td>
  <td>${employee.name}</td>
  <td><f:formatDate value="${employee.createDate}" 
								type="date" dateStyle="long"/></td>
  <td>${employee.dept.name}</td>
  <td>${employee.job.name}</td>

  <td><input type="button" value="修改" onclick="window.location.href='ModifyEmployee?id=${employee.id}'"></td>
  <td><input type="button" value="删除" onclick="areYouSure(${employee.id})"></td>
  </tr>
  </c:forEach>
  </table>
  <!-- 分页标签 -->
  <table>
	  <tr valign="top"><td align="center" >
	  	 <fkjava:pager
	  	        pageIndex="${requestScope.pageModel.pageIndex}" 
	  	        pageSize="${requestScope.pageModel.pageSize}" 
	  	        recordCount="${requestScope.pageModel.recordCount}" 
	  	        submitUrl="${ctx}/Employee?pageIndex={0}"/>
	  </td></tr>
  </table>
  <a href="main">回首页</a>
  </body>
</html>
