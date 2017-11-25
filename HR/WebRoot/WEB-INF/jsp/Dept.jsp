<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'User.jsp' starting page</title>
    
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
      window.location.href="DeleteDept?id="+id;
      }
     
     
  }
  </script>
  </head>
  
  <body>
  <table>
  <tr><td>
  <form action="Dept" method="post">
       部门名称：<input type="text" name="name">
      <input type="submit" value="搜索">
  </form>
  </td></tr>
  </table>
  
  <table>
  <tr>
  <th>id</th><th>name</th><th>remark</th>
  </tr>
  <c:forEach items="${requestScope.depts}"
  var="dept" >
  <tr>
  <td>${dept.id}</td>
  <td>${dept.name}</td>
  <td>${dept.remark}</td>
  <td><input type="button" value="修改" onclick="window.location.href='ModifyDept?id=${dept.id}'"></td>
  <td><input type="button" value="删除" onclick="areYouSure(${dept.id})"></td>
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
	  	        submitUrl="${ctx}/Dept?pageIndex={0}"/>
	  </td></tr>
  </table>
  <a href="main">回首页</a>
  </body>
</html>
