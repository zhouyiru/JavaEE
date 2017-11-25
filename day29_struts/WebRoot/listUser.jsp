<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'listUser.jsp' starting page</title>  
  </head>
  
  <body>
  	<h3>request域</h3>
    <table border="1">
    <c:forEach items="${requestScope.request_list}" var="user">
    	<tr>
    		<td>${user}</td>
    	</tr>
    </c:forEach>
    </table>
    <hr/>
    <h3>session域</h3>
    <table border="1">
    <c:forEach items="${sessionScope.session_list}" var="user">
    	<tr>
    		<td>${user}</td>
    	</tr>
    </c:forEach>
    </table>
    <h3>context域</h3>
    <table border="1">
    <c:forEach items="${applicationScope.context_list}" var="user">
    	<tr>
    		<td>${user}</td>
    	</tr>
    </c:forEach>
    </table>
  </body>
</html>
