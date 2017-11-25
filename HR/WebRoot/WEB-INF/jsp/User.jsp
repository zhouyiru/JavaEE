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
      window.location.href="DeleteUser?id="+id;
      }
     
     
  }
  </script>
  </head>
  
  <body>
  <table>
  <tr><td>
  <form action="User" method="post">
      登录名：<input type="text" name="loginname"> 用户名<input type="text" name="username">
      <input type="submit" value="搜索">
  </form>
  </td></tr>
  </table>
  
  <table>
  <tr>
  <th>id</th><th>loginname</th><th>password</th>
  <th>username</th><th>status</th>
  </tr>
  <c:forEach items="${requestScope.users}"
  var="user" >
  <tr>
  <td>${user.id}</td>
  <td>${user.loginname}</td>
  <td>${user.password}</td>
  <td>${user.username}</td>
  <td>${user.status}</td>
  <td><input type="button" value="修改" onclick="window.location.href='ModifyUser?id=${user.id}'"></td>
  <td><input type="button" value="删除" onclick="areYouSure(${user.id})"></td>
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
	  	        submitUrl="${ctx}/User?pageIndex={0}"/>
	  </td></tr>
  </table>
  <a href="main">回首页</a>
  </body>
</html>
